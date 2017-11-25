package jpcik.http

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.model.headers._
import akka.http.scaladsl.server.Directives._
import scala.io.StdIn
import akka.http.scaladsl.server.Route

object Rutas {
   implicit val system = ActorSystem("sistema")
   implicit val materializer = ActorMaterializer()
   implicit val executionContext = system.dispatcher

   val escritores=Seq(
       "nataniel-aguirre",
       "franz-tamayo",
       "augusto-cespedes",
       "oscar-cerruto")
   
   val pintores=Seq(
       "melchor-perez-de-holguin",
       "ricardo-perez-alcala",
       "arturo-borda")
   
   val rutaGet =
     get {
       pathPrefix("bolivia") {
         path("escritores") { 
           complete(escritores.mkString(","))
         } ~ 
         path("pintores") { 
           complete(pintores.mkString(","))
         } 
       }
     }

  val rutaEscritores = get {
    pathPrefix("bolivia") {
         path("escritores") { 
           complete(escritores.mkString(","))
         } ~
         path("escritores" / IntNumber) {i=>
           if (i<escritores.size)
             complete(escritores(i))
           else 
             complete(NotFound,"No existe ese id de escritor")
         } ~
         path("escritores" / Remaining) {nombre=>
           val option=escritores.find(_.equals(nombre))
           if (option.isDefined)
             complete(option.get)
           else
             complete(NotFound,s"No existe el escritor $nombre")
         }
  }} 
  
  def crearEscritor(req:HttpRequest)= Unit
  
  val rutaEscritores2 = 
    pathPrefix("bolivia") {
         pathPrefix("escritores") {
           (get & pathEnd){
         
           complete(escritores.mkString(","))
         } ~
         (post & extractRequest) {req=>
           crearEscritor(req)
           complete(OK,"para update")
         } ~
         (path(IntNumber) & delete) {i=>
           if (i>=escritores.size) complete(NotFound,s"No existe el escritor con id $i")
           else complete(OK,"para delete")
         }
         }}
  val rutaHeader =
    (path("ejemplo1") & headerValueByName(`User-Agent`.name)) {agent=>
        complete(s"El header User-Agent es: $agent")
    } ~
    (path("ejemplo2") & extractRequest) {req=>
        complete(s"Los headers: ${req.headers}")
    } ~ 
    (path("ejemplo3") & parameter('nombre)) { nombre=>
        complete(s"El parametro nombre: $nombre")
    } ~
    (path("ejemplo4") & parameter('edad) & parameter('talla)) { (nombre,talla)=>
        complete(s"Los parametros : $nombre $talla")
    }
   
  def iniciarServidor(route:Route) = {
    val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

    println(s"Servidor accesible en: http://localhost:8080/\n...")
    StdIn.readLine() // corre hasta que se presione enter
    bindingFuture
      .flatMap(_.unbind()) // lanzar el proceso de unbind
      .onComplete(_ => system.terminate()) // terminar el system de actores
   }
   
   def main(args: Array[String]) {
     //iniciarServidor(rutaGet)  
     //iniciarServidor(rutaEscritores)  
     iniciarServidor(rutaEscritores2)  
     //iniciarServidor(rutaHeader)  
     
  } 
}