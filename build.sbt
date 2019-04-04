ThisBuild / scalaVersion := "2.12.8"
ThisBuild / version := "0.1.0"
ThisBuild / organization := "com.github.tanacasino.example"
ThisBuild / organizationName := "tanacasino.example"
ThisBuild / scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-Xlint",
  "-Xwarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Xwarn-unused",
  "-Xwarn-unused-import",
  "-Xwarn-value-discard",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
)

lazy val dependencies = Seq(
  Dependencies.ScalaTest,
)

lazy val root = (project in file("."))
  .settings(
    name := "scala-sbt-template",
    libraryDependencies ++= dependencies
  )
