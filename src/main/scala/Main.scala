import org.apache.spark.{SparkConf, SparkContext}
import ranking.{DistributedInDegreeRank, InDegreeRank, RankingAlgorithm}
import utils.{FileUtils, VisualizationUtils}


object Main {

    def performRanking(edgesList: List[(Int, Int)], algorithm: RankingAlgorithm): List[(Int, Float)] = {
        algorithm match {
            case r: InDegreeRank => r.rank(edgesList)
            case r: DistributedInDegreeRank =>
                val conf = new SparkConf().setAppName("covidRank").setMaster("local[*]")
                val sc = new SparkContext(conf)

                val distEdgesList = sc.parallelize(edgesList)
                r.rank(distEdgesList)
        }
    }

    def main(args: Array[String]): Unit = {
        val graphFilePath = "data/citations_500.txt"

        val edgesList = FileUtils.loadGraphFromFile(graphFilePath)
        val nodes = FileUtils.loadNodesFromFile(graphFilePath)

        println("Loaded "+nodes.size+" nodes.")
        println("Loaded "+edgesList.size+" edges.")

        //val r : RankingAlgorithm = new InDegreeRank
        val r : RankingAlgorithm = new DistributedInDegreeRank

        val ranking = performRanking(edgesList, r)
        VisualizationUtils.printTopK(ranking, nodes)
    }
}
