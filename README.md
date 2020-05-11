# CovidRank
This project has been realized as part of the *Languages and algorithms for AI* exam of the [Master's degree in Artificial Intelligence,  University of Bologna](https://corsi.unibo.it/2cycle/artificial-intelligence).

The following ranking algorithms were implemented to analyze the citations graph derived from [CORD-19](https://www.kaggle.com/allen-institute-for-ai/CORD-19-research-challenge):

* **InDegreeRank** which performs the ranking of a graph's nodes according to their normalized in-degree;
* **PageRank** (see **References**).

The algorithms were tested on 5 citations graphs built by lower-bounding the Indegree of the vertices.
## Running the tests

You can test the algorithm by running:

```
run <citations_graph> <algorithm>
```
The implemented algorithms are:
* `InDegree`
* `DistribuitedInDegree`
* `PageRank`
* `DistributedPageRank`

The available citations graphs are:
* *citation_500*: 
    * Indegree lower bound = 500
    * 1,760 nodes
    * 2,747 edges
    
* *citation_100*: 
    *  Indegree lower bound = 100
    *  9,648 nodes
    *  23,437 edges 
    
* *citation_50*: 
    * Indegree lower bound = 50
    * 14,925 nodes
    * 51,814 edges 
* *citation_10*: 
    * Indegree lower bound = 10
    * 32,686 nodes
    * 227,433 edges 
* *ciattion_1*: 
    * Indegree lower bound = 1 
    * 1,015,682 nodes
    * 1,576,019 edges 

## Results
We performed our tests on two different configutations:
* **Local machine**: 32 GB RAM, i7 7700k CPU 
* **AWS**: 2x machines with 4 cores and 16gb memory

In the figures below we report the comparison results on the 5 citations graphs: 
![Algorithms performance](https://github.com/EleMisi/CovidRank/images/Algorithms_performance.png)
![Algorithms performance plot](https://github.com/EleMisi/CovidRank/images/Algorithms_performance_thrs.png)

## Built With

* [Scala 2.11.12](https://www.scala-lang.org/)
* [Apache Spark](https://spark.apache.org/)


## Authors

* [alexpod1000](https://github.com/alexpod1000)
* [EleMisi](https://github.com/EleMisi)


## License

This project is licensed under the Apache License 2.0 - see the [LICENSE.md](LICENSE.md) file for details.

## References

[PageRank - Wikipedia](https://it.wikipedia.org/wiki/PageRank)
