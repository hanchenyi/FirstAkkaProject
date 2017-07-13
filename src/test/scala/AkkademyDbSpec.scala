import akka.actor.{ActorSystem, Props}
import akka.testkit.TestActorRef
import akka.util.Timeout
import com.example.{AkkademyDb, ScalaPongActor, SetRequest}
import org.scalatest.{FunSpecLike, _}

import scala.concurrent.duration._

class AkkademyDbSpec extends FunSpecLike with Matchers {
  implicit val system = ActorSystem()
  implicit val timeout = Timeout(5 seconds)

  describe("akkademyDb") {
    describe("given SetRequest") {
      it("should place key/value into your map") {
        
        val actorRef = TestActorRef(new AkkademyDb)
        actorRef ! SetRequest("key", "value")

        val akkademyDb = actorRef.underlyingActor
        akkademyDb.map.get("key") should equal(Some("value"))
      }
    }
  }
}

class ScalaPongActorSpec extends FunSpecLike with Matchers {
  implicit val system = ActorSystem()
  implicit val timeout = Timeout(5 seconds)

  describe("scalaPongActor") {
    describe("given Ping") {
      it("should return message Pong") {

        val actorRef = system.actorOf(Props[ScalaPongActor], "PongFoo")
        actorRef ! "ping"

        true
      }
    }
  }
}
