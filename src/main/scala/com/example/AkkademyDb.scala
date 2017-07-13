package com.example

import akka.actor.{Actor, Status}
import akka.event.Logging

import scala.collection.mutable.HashMap

/**
  * Created by vagrant on 17-7-10.
  */

class AkkademyDb extends Actor{
  val map = new HashMap[String, Object]
  val log = Logging(context.system, this)

  override def receive = {
    case SetRequest(key, value) => {
      log.info(s"received SetRequest - key: {$key} value: {$value}")
      map.put(key,value)
    }
    case others => log.info(s"received unknown messages: {$others}")
  }

}

class ScalaPongActor extends Actor{
  override def receive: Receive = {
    case "ping" => sender() ! "pong"
    case _ => sender() ! Status.Failure(new Exception("unknow message"))
  }
}