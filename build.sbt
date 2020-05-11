name := "CovidRank"

version := "0.1"

scalaVersion := "2.11.12"

assemblyMergeStrategy in assembly := {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case x => MergeStrategy.first
}

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.4"
libraryDependencies += "org.scalatra.scalate" %% "scalate-core" % "1.9.5"
