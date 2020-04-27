package utils
import java.io.{File, FileWriter}

import org.fusesource.scalate._

import scala.collection.mutable.ListBuffer


object VisualizationUtils {

    /**
     * Prints the top K articles according to the rank.
     *
     * @param rank: ranking of articles.
     * @param nodes: articles labels and titles.
     * @param k: number of articles to print.
     * */
    def printTopK(rank: List[(Int, Float)], nodes: Map[Int, String], k: Int = 10)  = {
        val limit = k.min(rank.length)

        for (i <- 0 until limit) {
          println(nodes(rank(i)._1), rank(i)._1, rank(i)._2)
        }
    }

    /**
     * Outputs top K articles according to the rank into an HTML page, and saves it.
     *
     * @param outPath: path of the HTML output file.
     * @param graphPath: filename of the graph path (just for clarity purposes).
     * @param rank: ranking of articles.
     * @param nodes: articles labels and titles.
     * @param k: number of articles to output.
     * */
    def outputHtmlPage(outPath: String, graphPath: String, rank: List[(Int, Float)], nodes: Map[Int, String], k: Int = 10) = {
        // https://scalate.github.io/scalate/documentation/scalate-embedding-guide.html
        val limit = k.min(rank.length)
        // prepare data for template
        val entriesLb = new ListBuffer[Map[String, String]]()
        for (i <- 0 until limit) {
            entriesLb += Map(
                "position" -> (i+1).toString,
                "title" -> nodes(rank(i)._1),
                "id" -> rank(i)._1.toString,
                "rank" -> rank(i)._2.toString
            )
        }

        val engine = new TemplateEngine
        val output = engine.layout("templates/rank.mustache", Map("graphFilePath" -> graphPath, "rankEntries" -> entriesLb.toList))

        val fileStream = new FileWriter(new File(outPath))
        fileStream.write(output)
        fileStream.close()
    }

}
