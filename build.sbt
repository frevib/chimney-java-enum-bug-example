ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"

lazy val root = (project in file("."))
  .settings(
    name := "chimney-java-enum-bug-example"
  )
  .settings(libraryDependencies ++= List("io.scalaland" %% "chimney" % "0.8.5"))
