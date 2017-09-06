package com.example

import akka.actor.{ActorSystem, Props}
import akka.util.Timeout
import akka.pattern.ask
import scala.concurrent.duration._

class SClient(remoteAddress: String) {
	private implicit val timeOut = Timeout(2 seconds)
	private implicit val system = ActorSystem("LocalSystem")
	private val remoteDb = system.actorSelection(s"akka.tcp://hello@remoteAddress/user/hello-db")

	def set(key: String, value: Object) = {
		remoteDb ? SetRequest(key, value)
	}

	def get(key: String) = {
		remoteDb ? GetRequest(key)
	}

}