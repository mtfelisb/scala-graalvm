package com.github.mtfelisb.scalagraalvm

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.{ActorMaterializer, Materializer}
import scala.concurrent.ExecutionContext

object App {
  def main(args: Array[String]): Unit = {
    implicit val system: ActorSystem = ActorSystem()
    implicit val materializer: Materializer = ActorMaterializer()
    implicit val ec: ExecutionContext = system.dispatcher

    val route = path("health") {
      get {
        complete("Hello, World!")
      }
    }

    Http().bindAndHandleAsync(Route.asyncHandler(route), "0.0.0.0", 9000)
  }
}