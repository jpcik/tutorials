package jpcik.http

import akka.http.scaladsl.model.Uri

object Uris {
  val uri1 = Uri.from(scheme="ftp", host="mi-servidor.com", port=8090, path="archivos/documento.zip")
  
  val uri2 = Uri.from(scheme="mailto",path="jean-paul.calbimonte@hevs.ch")
  
  val uri3: Uri="http://mi-servidor.com:8080/directorio"
}