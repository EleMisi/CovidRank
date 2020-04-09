package ranking

abstract class RankingAlgorithm {

    /**
     * Performs ranking of a graph's nodes via some policy
     *
     * @param edgesList list of graph's edges
     * */
    def rank(edgesList: List[(Int, Int)]): List[(Int, Float)]
}
