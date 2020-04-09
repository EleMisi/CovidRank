package utils

import scala.io.Source

object FileUtils {

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

    /**
     * Loads node labels from a given file path.
     * */
    def loadNodesFromFile(path: String): Map[Int, String] = {
        val graphFile = Source.fromFile(path)
        val nodes: Map[Int, String] = graphFile.getLines
          .filter(line => line.startsWith("n"))
          .map(line => line.split("\\s").splitAt(2))
          .map(tokens => (tokens._1(1).toInt, tokens._2.mkString(" ")))
          .toMap[Int, String]
        nodes
    }

}
