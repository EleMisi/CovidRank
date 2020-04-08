import scala.io.Source

object Main {

    /**
     * Loads a graph's list of edges from a given file path.
     * */
    def loadGraphFromFile(path: String): List[(Int, Int)] = {
        val graphFile = Source.fromFile(path)
        val edgesList: List[(Int, Int)] = graphFile.getLines
          .filter(line => line.startsWith("e"))
          .map(line => line.split("\\s"))
          .map(tokens => (tokens(1).toInt, tokens(2).toInt))
          .toList
        edgesList
    }

    def main(args: Array[String]): Unit = {
        val edgesList = loadGraphFromFile("data/citations_500.txt")
        println(edgesList)
    }

}
