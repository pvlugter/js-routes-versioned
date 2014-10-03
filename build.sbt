name := """js-routes-versioned"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)

pipelineStages := Seq(digest)

// Create a map of versioned assets, replacing the empty versioned.js
DigestKeys.indexPath := Some("javascripts/versioned.js")

// Assign the asset index to a global versioned var
DigestKeys.indexWriter ~= { writer => index => s"var versioned = ${writer(index)};" }
