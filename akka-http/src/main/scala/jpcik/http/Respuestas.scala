package jpcik.http

import akka.http.scaladsl.Http
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model.headers._
import akka.http.scaladsl.model.MediaTypes._
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.model._

object Respuestas {
  //ejemplo de cuerpo
  val datos="""{ "nombre":"Pando","capital":"Cobija"}"""
  val respuesta=HttpResponse(
        StatusCodes.OK,
        List(ETag("737060cd8c284d8af7ad3082f209582d")),
        HttpEntity(`application/json`, datos) )
  
  // respuesta 200 OK
  val respuesta1=HttpResponse(200)
  // respuesta NotFound
  val respuesta2=HttpResponse(NotFound,entity="No se pudo encontrar el recurso.")
}