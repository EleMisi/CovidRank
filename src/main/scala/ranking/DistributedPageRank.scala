package ranking

import org.apache.spark.rdd.RDD
import scala.collection.immutable.Map

class DistributedPageRank extends RankingAlgorithm {
  type T = RDD[(Int, Int)]

  /**
   * Performs ranking of a graph's nodes by using PageRank algorithm.
   *
   * @param edgesList list of graph's edges
   * @param N number of nodes in the graph
   **/
  override def rank(edgesList: T, N: Int): List[(Int, Float)] = {
    val maxIter : Int = 10
    val damping : Float = 0.85f

    val outEdges: RDD[(Int, Iterable[Int])] = edgesList.map(edge => (edge._2, edge._1))
      .groupBy(edge => edge._2)
      .mapValues(_.map(_._1))
      .persist()
    var pageRank: RDD[(Int, Float)] = outEdges.mapValues(v => 1f / N).persist()

      for (t <- 1 to maxIter) {
        val nodeSuccessorsScores = outEdges.join(pageRank)
          .flatMap {
              case (node: Int, (nodeSuccessors: List[Int], rank: Float)) =>
              val outDegree = nodeSuccessors.size 
              nodeSuccessors.map(nodeSuccessor => (nodeSuccessor, rank / outDegree))
            }
        pageRank = nodeSuccessorsScores.reduceByKey((x, y) => x + y)
          .mapValues(score => (1 - damping) / N + damping * score)
      }      
    pageRank.sortBy(- _._2).collect().toList
  }

}

