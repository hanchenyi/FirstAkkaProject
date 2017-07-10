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
    "org.scalatest" %% "scalatest" % "3.0.1" % "test")
)

lazy val root = (project in file("."))
  .settings(
    commonSettings
  )
