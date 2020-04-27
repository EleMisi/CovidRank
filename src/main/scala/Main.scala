import org.apache.spark.{SparkConf, SparkContext}
import ranking.{DistributedInDegreeRank, DistributedPageRank, InDegreeRank, PageRank, RankingAlgorithm}
import utils.{FileUtils, VisualizationUtils}


object Main {

    def performRanking(edgesList: List[(Int, Int)], N: Int, algorithm: RankingAlgorithm): List[(Int, Float)] = {
        algorithm match {
            case r: InDegreeRank => r.rank(edgesList, N)
            case r: PageRank => r.rank(edgesList, N)
            case r: DistributedInDegreeRank =>
                val conf = new SparkConf().setAppName("covidInDegreeRank").setMaster("local[*]")
                val sc = new SparkContext(conf)
                val distEdgesList = sc.parallelize(edgesList)
                r.rank(distEdgesList, N)
            case r: DistributedPageRank =>
                val conf = new SparkConf().setAppName("covidPageRank").setMaster("local[*]")
                val sc = new SparkContext(conf)
                val distEdgesList = sc.parallelize(edgesList)
                r.rank(distEdgesList, N)
        }
    }

    def main(args: Array[String]): Unit = {
        val graphFilePath = "data/citations_500.txt"
        val edgesList = FileUtils.loadGraphFromFile(graphFilePath)
        val nodes = FileUtils.loadNodesFromFile(graphFilePath)
        val N: Int = nodes.size

        println("Loaded "+N+" nodes.")
        println("Loaded "+edgesList.size+" edges.")

        val r : RankingAlgorithm = new DistributedPageRank
        val ranking = performRanking(edgesList, N, r)

        VisualizationUtils.printTopK(ranking, nodes)
    }
}
