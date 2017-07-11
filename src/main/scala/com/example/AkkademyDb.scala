package com.example

import akka.actor.Actor
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
