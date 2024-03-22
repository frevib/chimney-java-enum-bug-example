ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"


//Compile / compileOrder := CompileOrder.JavaThenScala

//Compile / javaSource := baseDirectory.value / "src"



lazy val root = (project in file("."))
  .settings(
    name := "chimney-java-enum-bug-example"
  )
  .settings(libraryDependencies ++= List(
    "io.scalaland" %% "chimney" % "0.8.5",
    "io.scalaland" %% "chimney-java-collections" % "0.8.5"
  ))
