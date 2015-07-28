import sbtassembly.Plugin._
import AssemblyKeys._

import com.scalapenos.sbt.prompt._
import SbtPrompt.autoImport._


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

promptTheme := PromptTheme(
  List(
    text("[", fg(white)),
    currentProject(fg(cyan)),
    text("] ", fg(white)),
    gitBranch(clean = fg(green), dirty = fg(red)),
    text(" $ ", fg(yellow))
  )
)

