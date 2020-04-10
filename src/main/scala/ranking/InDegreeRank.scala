package ranking

class InDegreeRank extends RankingAlgorithm {

    /**
     * Performs ranking of a graph's nodes according to their normalized in-degree.
     *
     * @param edgesList list of graph's edges
     **/
    override def rank(edgesList: List[(Int, Int)]): List[(Int, Float)] = {
      val inDegreeRank: List[(Int, Float)] = edgesList.groupBy(edge => edge._2)
        .map(edge => (edge._1, edge._2.length.toFloat / edgesList.length ))
        .toList
        .sortBy(- _._2)
      inDegreeRank
    }

}

