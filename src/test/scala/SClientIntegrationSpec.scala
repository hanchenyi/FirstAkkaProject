import akka.actor.{ActorSystem, Props}
import akka.testkit.TestActorRef
import akka.util.Timeout
import com.example.SClient
import org.scalatest.{FunSpecLike, _}
import scala.concurrent.Await
import scala.concurrent.duration._

class SClientIntegrationSpec extends FunSpecLike with Matchers {
	val client = new SClient("127.0.0.1:2552")
	describe("akkademyDbClient") {
		it("should set a value") {
		client.set("123", new Integer(123))
		val futureResult = client.get("123")
		val result = Await.result(futureResult, 10 seconds)
		result should equal(123)
		}
	}
	
}