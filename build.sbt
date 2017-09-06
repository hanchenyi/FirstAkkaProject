//import com.typesafe.sbt.SbtScalariform
import sbt._
import Keys.{scalaVersion, _}

lazy val commonSettings = Seq(
  name := "Hello",
  organization := "com.example",
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.11.8",
  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.5.3",
    "com.typesafe.akka" %% "akka-testkit" % "2.5.3" % Test,
    "org.scalatest" %% "scalatest" % "3.0.1" % "test",
    "org.scala-lang" % "scala-reflect" % "2.11.7",
    "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.4",
    "com.typesafe.akka" %% "akka-remote" % "2.3.6")
)

lazy val root = (project in file("."))
  .settings(SbtScalariform.scalariformSettings: _*)
  .settings(
    commonSettings
  )


fork in run := true