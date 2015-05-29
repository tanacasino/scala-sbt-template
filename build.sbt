import sbtassembly.Plugin._
import AssemblyKeys._

name := "scala-sbt-template"

version := "0.1.0"

scalaVersion := "2.11.6"

organization := "com.github.tanacasino"

scalacOptions ++= (
  "-deprecation" ::
  "-unchecked" ::
  "-Xlint" ::
  "-Ywarn-dead-code" ::
  "-Ywarn-numeric-widen" ::
  "-Ywarn-unused" ::
  "-Ywarn-unused-import" ::
  "-Ywarn-value-discard" ::
  "-language:existentials" ::
  "-language:higherKinds" ::
  "-language:implicitConversions" ::
  Nil
)

shellPrompt := { state =>
  val branch = if(file(".git").exists){
    "git branch".lines_!.find{_.head == '*'}.map{_.drop(1)}.getOrElse("")
  } else ""
  Project.extract(state).currentRef.project + branch + " > "
}

libraryDependencies ++= {
  Seq(
   "org.scalatest"  % "scalatest_2.11" % "2.2.1" % "test"
  )
}

resolvers ++= Seq(
  "snapshots"     at "http://oss.sonatype.org/content/repositories/snapshots",
  "releases"      at "http://oss.sonatype.org/content/repositories/releases"
)

assemblySettings
