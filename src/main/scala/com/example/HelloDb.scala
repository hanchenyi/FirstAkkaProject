package com.example

import akka.actor.{Actor, Status}
import akka.event.Logging
import scala.collection.mutable.HashMap
import scala.concurrent.duration._
/**
  * Created by vagrant on 17-7-10.
  */

class HelloDb extends Actor{
  val map = new HashMap[String, Object]
  val log = Logging(context.system, this)

  override def receive = {
    case SetRequest(key, value) => {
      log.info(s"received SetRequest - key: {$key} value: {$value}")
      map.put(key,value)
      sender() ! Status.Success
    }
    case GetRequest(key) => {
      log.info(s"received GetRequest - key: {$key}")
      val response: Option[String] = map.get(key) map(_.toString)
      response match {
        case Some(x) => sender() ! x
        case None => sender() ! Status.Failure(new KeyNotFoundException(key))
      }
    }
    case others => sender() ! Status.Failure(new Exception("unknow message"))
  }
}

class ScalaPongActor extends Actor{
  override def receive: Receive = {
    case "ping" => sender() ! "pong"
    case _ => sender() ! Status.Failure(new Exception("unknow message"))
  }
}