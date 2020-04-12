package ranking

class PageRank extends RankingAlgorithm {
    type T = List[(Int, Int)]

    /**
     * Performs ranking of a graph's nodes by using PageRank algorithm
     *
     * @param edgesList list of graph's edges
     **/
    override def rank(edgesList: T): List[(Int, Float)] = ???
}
