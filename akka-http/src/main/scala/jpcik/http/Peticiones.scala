package jpcik.http

import akka.http.scaladsl.Http
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model.headers._
import akka.http.scaladsl.model.MediaTypes._
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.model._

object Peticiones {
  // ejemplo de URI
  val uriPando=Uri("http://bolivia.bo/pando")
  // ejemplo de verbo
  val verbo=HttpMethods.POST
  // ejemplo de protocol
  val proto=HttpProtocols.`HTTP/1.1`
  // ejemplo de cabecera
  val cabecera=Accept(`text/plain`)
  //ejemplo de cuerpo
  val datos="""{ "nombre":"Pando","capital":"Cobija"}"""
  val mensaje=HttpEntity(datos)
    
  // petición
  val peticion=HttpRequest(
      uri=uriPando,
      method=verbo,
      protocol=proto,
      headers=List(cabecera),
      entity=mensaje)
        
   // mas simple
   val peticion2=HttpRequest(POST,uriPando,List(cabecera),mensaje)
}