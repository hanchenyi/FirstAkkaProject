package com.example

import akka.actor.{ActorSystem, Props}
import akka.util.Timeout
import scala.concurrent.duration._

object main extends App {
	val system = ActorSystem("hello")
	system.actorOf(Props[HelloDb], name="hello-db")
	println("hello ActorSystem started...")
}