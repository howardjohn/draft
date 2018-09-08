package helloworld

import fs2.StreamApp
import cats.effect.IO
import org.http4s.server.blaze.BlazeBuilder
import scala.concurrent.ExecutionContext.Implicits.global

object HelloWorldServer extends StreamApp[IO] {
  def helloWorldRoutes = new HelloWorldRoutes[IO].routes

  override def stream(args: List[String], requestShutdown: IO[Unit]) =
    BlazeBuilder[IO]
      .bindHttp(sys.env("PORT").toInt, "0.0.0.0")
      .mountService(helloWorldRoutes, "/")
      .serve
}
