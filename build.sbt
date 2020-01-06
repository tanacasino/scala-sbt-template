ThisBuild / scalaVersion := "2.13.1"
ThisBuild / version := "0.1.0"
ThisBuild / organization := "com.github.tanacasino.example"
ThisBuild / organizationName := "tanacasino.example"
ThisBuild / scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-Xlint",
  "-Xlint:deprecation",
  "-Xfatal-warnings"
)

lazy val libDependencies = Seq(
  Dependencies.ScalaTest % Test
)

lazy val root = (project in file("."))
  .settings(
    name := "scala-sbt-template",
    libraryDependencies ++= libDependencies
  )
