name := "Scala sbt template"

version := "0.1.0"

scalaVersion := "2.11.2"

organization := "com.github.tanacasino"

scalacOptions ++= Seq("-unchecked", "-deprecation")

libraryDependencies ++= {
  Seq(
    "jp.co.bizreach" %% "s3scala-scala" % "0.0.1",
    "org.scalatest"  % "scalatest_2.11" % "2.2.1" % "test"
  )
}

resolvers ++= Seq(
  "snapshots"     at "http://oss.sonatype.org/content/repositories/snapshots",
  "releases"      at "http://oss.sonatype.org/content/repositories/releases"
)

