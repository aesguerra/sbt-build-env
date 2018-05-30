name := "sbt-build-env"

version := "1.0.0"

scalaVersion := "2.11.8"
lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.3"

lazy val root = (project in file("."))
  .configs(Test)
  .settings(
    inThisBuild(List(
      organization := "com.minyodev",
      scalaVersion := "2.11.8",
      version := "1.0.0"
    )),
    name := "sbt-build-env",
    libraryDependencies += scalaTest % Test
  )

parallelExecution in Test := false

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.1"
)

parallelExecution := false


assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs@_*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

