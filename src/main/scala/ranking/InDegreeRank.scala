package ranking

class InDegreeRank extends RankingAlgorithm {
    type T = List[(Int, Int)]

    /**
     * Performs ranking of a graph's nodes according to their normalized in-degree.
     *
     * @param edgesList list of graph's edges
     * @param N number of nodes in the graph
     **/
    override def rank(edgesList: T, N: Int): List[(Int, Float)] = {
      val inDegreeRank: List[(Int, Float)] = edgesList.groupBy(edge => edge._2)
        .map(edge => (edge._1, edge._2.length.toFloat / edgesList.length ))
        .toList.sortBy(- _._2)
      inDegreeRank
    }

}

