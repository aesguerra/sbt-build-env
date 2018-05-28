name := "sbt-build-env"

version := "1.0.0"

scalaVersion := "2.11.8"
lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.3"

enablePlugins(JavaAppPackaging)
mappings in Universal += {
  // logic like this belongs into an AutoPlugin
  val confFile = buildEnv.value match {
    case BuildEnv.Development => "application-dev.conf"
    case BuildEnv.Stage => "application-stage.conf"
    case BuildEnv.Production => "application-prod.conf"
  }
  ((resourceDirectory in Compile).value / confFile) -> "conf/application.conf"
}

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

