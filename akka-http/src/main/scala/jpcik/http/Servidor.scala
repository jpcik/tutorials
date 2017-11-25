package jpcik.http

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import scala.io.StdIn

object Servidor {
   implicit val system = ActorSystem("my-system")
   implicit val materializer = ActorMaterializer()
   implicit val executionContext = system.dispatcher

    val route =
      path("demo") {
        get {
          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, 
              "<h1>Servicio Disponible!</h1>"))
        }
      }

   def main(args: Array[String]) {

    // Iniciar el servidor (binding en el puerto especificado)
    val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

    println(s"Servidor accesible en: http://localhost:8080/\n...")
    StdIn.readLine() // corre hasta que se presione enter
    bindingFuture
      .flatMap(_.unbind()) // lanzar el proceso de unbind
      .onComplete(_ => system.terminate()) // terminar el system de actores
  } 
}