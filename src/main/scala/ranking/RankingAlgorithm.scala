package ranking

abstract class RankingAlgorithm {
    type T
    /**
     * Performs ranking of a graph's nodes via some policy
     *
     * @param edgesList list of graph's edges
     * */
    def rank(edgesList: T): List[(Int, Float)]
}
