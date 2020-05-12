# CovidRank
CovidRank is a project realized as part of the *Languages and algorithms for AI* exam of the [Master's degree in Artificial Intelligence,  University of Bologna](https://corsi.unibo.it/2cycle/artificial-intelligence).
The aim of this project is to use different ranking algorithms on  [CORD-19](https://www.kaggle.com/allen-institute-for-ai/CORD-19-research-challenge) dataset to figure out what are the most relevant publications in virology field.
### Available algorithms 
The following ranking algorithms were implemented both in a non-distributed and in a distributed version: 
* **InDegreeRank** which performs the ranking of a graph's nodes according to their normalized in-degree;
* **PageRank** (see *References*).

The available algorithms are:
* `InDegree`
* `DistribuitedInDegree`
* `PageRank`
* `DistributedPageRank`

### Available data 
Given the original dataset, we've extracted article names and their citations lists into a graph, and built the following citations graph by thresholding by thresholding the Indegree of the vertices:
* *citation_500*: 
    * Indegree threshold = 500
    * 1,760 nodes
    * 2,747 edges
    
* *citation_100*: 
    *  Indegree threshold = 100
    *  9,648 nodes
    *  23,437 edges 
    
* *citation_50*: 
    * Indegree threshold = 50
    * 14,925 nodes
    * 51,814 edges 
* *citation_10*: 
    * Indegree threshold = 10
    * 32,686 nodes
    * 227,433 edges 
* *ciattion_1*: 
    * Indegree threshold = 1 
    * 1,015,682 nodes
    * 1,576,019 edges 

## Running the tests

You can test the program by typing 
```
run <citations_graph> <algorithm>
```

## Results
We performed our tests on two different configurations:
* **Local machine**: 32 GB RAM, i7 7700k CPU 
* **AWS**: 2x machines with 4 cores and 16gb memory

In the figures below we report the comparison results on the 5 citations graphs: 
![Algorithms performances 1](https://github.com/EleMisi/CovidRank/blob/master/images/Algorithms_performance.png)
![Algorithms performances 2](https://github.com/EleMisi/CovidRank/blob/master/images/Algorithms_performance_thrs.png)

As an example, we report the top 10 articles extracted from *citetion_1* using `DistribuitedInDegree`:

Position | Title
------------ | -------------
1 | Isolation of a novel coronavirus from a man with pneumonia in Saudi Arabia
2 | Identification of a novel coronavirus in patients with severe acute respiratory syndrome
3 | A novel coronavirus associated with severe acute respiratory syndrome
4 | Coronavirus as a possible cause of severe acute respiratory syndrome
5 | Characterization of a novel coronavirus associated with severe acute respiratory syndrome
6 | Angiotensin-converting enzyme 2 is a functional receptor for the SARS coronavirus
7 | Bats are natural reservoirs of SARS-like coronaviruses
8 | The molecular biology of coronaviruses
9 | Global trends in emerging infectious diseases
10 | A major outbreak of severe acute respiratory syndrome in Hong Kong

### Built With

* [Scala 2.11.12](https://www.scala-lang.org/)
* [Apache Spark](https://spark.apache.org/)


### Authors

* [alexpod1000](https://github.com/alexpod1000)
* [EleMisi](https://github.com/EleMisi)


### License

This project is licensed under the Apache License 2.0 - see the [LICENSE.md](https://github.com/EleMisi/CovidRank/blob/master/LICENSE) file for details.

### References

[PageRank - Wikipedia](https://it.wikipedia.org/wiki/PageRank)
