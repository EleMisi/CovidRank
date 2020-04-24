package ranking

class PageRank extends RankingAlgorithm {
    type T = List[(Int, Int)]

    /**
     * Performs ranking of a graph's nodes by using PageRank algorithm
     *
     * @param edgesList list of graph's edges
     * @param N number of nodes in the graph
     **/
    override def rank(edgesList: T, N: Int): List[(Int, Float)] = ???


}
