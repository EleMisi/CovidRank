package ranking

import org.apache.spark.rdd.RDD

class DistributedInDegreeRank extends RankingAlgorithm {
    type T = RDD[(Int, Int)]

    /**
     * Performs ranking of a graph's nodes via some policy
     *
     * @param edgesList list of graph's edges
     * @param N number of nodes in the graph
     **/
    override def rank(edgesList: T, N: Int): List[(Int, Float)] = {
        val numEdges = edgesList.count()
        edgesList.map(edge => (edge._2, 1f / numEdges)).reduceByKey((x, y) => x + y).sortBy(- _._2).collect().toList
    }
}
