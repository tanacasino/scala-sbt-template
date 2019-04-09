ThisBuild / scalaVersion := "2.12.8"
ThisBuild / version := "0.1.0"
ThisBuild / organization := "com.github.tanacasino.example"
ThisBuild / organizationName := "tanacasino.example"
ThisBuild / scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-Ypartial-unification",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-unused",
  "-Ywarn-unused-import",
  "-Ywarn-value-discard",
  "-Xlint",
  "-Xfatal-warnings"
)

lazy val dependencies = Seq(
  Dependencies.ScalaTest
)

lazy val root = (project in file("."))
  .settings(
    name := "scala-sbt-template",
    libraryDependencies ++= dependencies
  )
