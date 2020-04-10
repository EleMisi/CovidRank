import ranking.{InDegreeRank, RankingAlgorithm}
import utils.{FileUtils, VisualizationUtils}


object Main {

    def main(args: Array[String]): Unit = {
        val graphFilePath = "data/citations_500.txt"
        val edgesList = FileUtils.loadGraphFromFile(graphFilePath)
        val nodes = FileUtils.loadNodesFromFile(graphFilePath)
        val r : RankingAlgorithm = new InDegreeRank
        println(nodes)
        println(edgesList)
        VisualizationUtils.printTopK(r.rank(edgesList), nodes)
    }
}
