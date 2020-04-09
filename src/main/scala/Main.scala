import utils.FileUtils

object Main {

    def main(args: Array[String]): Unit = {
        val graphFilePath = "data/citations_500.txt"
        val edgesList = FileUtils.loadGraphFromFile(graphFilePath)
        val nodes = FileUtils.loadNodesFromFile(graphFilePath)
        println(edgesList)
        println(nodes)
    }

}
