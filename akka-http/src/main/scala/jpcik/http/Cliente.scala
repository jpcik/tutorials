package jpcik.http

import akka.http.scaladsl.Http
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model.headers._
import akka.http.scaladsl.model.MediaTypes._
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.model._
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import concurrent.ExecutionContext.Implicits.global
import concurrent.duration._
import scala.language.postfixOps
import akka.stream.scaladsl.Framing
import akka.util.ByteString
import akka.stream.scaladsl.Sink

object Cliente {
  implicit val system=ActorSystem()
  implicit val materializer=ActorMaterializer()
  
  
  
  def ejemploGETSimple ={
    val paisURI="https://restcountries.eu/rest/v2/name/bolivia"
    val pais=Http().singleRequest(HttpRequest(GET,uri = paisURI))
    pais.map{resp=>
      println(resp.entity)
    }
    //HttpEntity.Strict(application/json,[{"name":"Bolivia (Plurinational State of)","topLevelDomain":[".bo"],"alpha2Code":"BO","alpha3Code":"BOL","callingCodes":["591"],"capital":"Sucre","altSpellings":["BO","Buliwya","Wuliwya","Plurinational State of Bolivia","Estado Plurinacional de Bolivia","Buliwya Mamallaqta","Wuliwya Suyu","Tetã Volívia"],"region":"Americas","subregion":"South America","population":10985059,"latlng":[-17.0,-65.0],"demonym":"Bolivian","area":1098581.0,"gini":56.3,"timezones":["UTC-04:00"],"borders":["ARG","BRA","CHL","PRY","PER"],"nativeName":"Bolivia","numericCode":"068","currencies":[{"code":"BOB","name":"Bolivian boliviano","symbol":"Bs."}],"languages":[{"iso639_1":"es","iso639_2":"spa","name":"Spanish","nativeName":"Español"},{"iso639_1":"ay","iso639_2":"aym","name":"Aymara","nativeName":"aymar aru"},{"iso639_1":"qu","iso639_2":"que","name":"Quechua","nativeName":"Runa Simi"}],"translations":{"de":"Bolivien","es":"Bolivia","fr":"Bolivie","ja":"ボリビア多民族国","it":"Bolivia","br":"Bolívia","pt":"Bolívia","nl":"Bolivia","hr":"Bolivija","fa":"بولیوی"},"flag":"https://restcountries.eu/data/bol.svg","regionalBlocs":[{"acronym":"USAN","name":"Union of South American Nations","otherAcronyms":["UNASUR","UNASUL","UZAN"],"otherNames":["Unión de Naciones Suramericanas","União de Nações Sul-Americanas","Unie van Zuid-Amerikaanse Naties","South American Union"]}],"cioc":"BOL"}])
 
    val resp=Http().singleRequest(HttpRequest(uri = paisURI))
  }
  
  val uriPosts="https://jsonplaceholder.typicode.com/posts"
  
  def ejemploOPTIONS = {
    val resp=Http().singleRequest(HttpRequest(OPTIONS,uriPosts))
    resp.map(msg=>println(msg.getHeader("Access-Control-Allow-Methods")))
  }
  
  def ejemploHEAD = {
    val resp=Http().singleRequest(HttpRequest(HEAD,uriPosts))
    resp.map{msg=>
      println("Status "+msg.status)
      msg.headers.foreach{cabezera=>
        println(cabezera.name+":"+cabezera.value)
      }
    }
  }
  
  def ejemploGET = {
    val resp=Http().singleRequest(HttpRequest(GET,s"$uriPosts/1"))
    resp.map{msg=>
      println("Status "+msg.status)
      println("Content-Type "+msg.entity.contentType)
      println("Content-Length "+msg.entity.contentLengthOption.get)
      
      msg.entity.toStrict(5 seconds).map{ent=>
        println(ent.data.utf8String)
      }
     
    }
  }
  def ejemploStream = {
    val future=Http().singleRequest(HttpRequest(GET,s"$uriPosts/1"))
    
    future.map(_.entity.dataBytes
      .map(a=>a.utf8String)
      .runWith(Sink.foreach(println))
      )
  }
  
  def imprimirResponse(resp:HttpResponse)=
     resp.entity.toStrict(5 seconds).map{ent=>
        println(ent.data.utf8String)
     }
  
  def ejemploPOST = {
    
    val mensaje="""
      {
        "userId": 1,
        "title": "Un post corto",
        "body": "El contenido va aqui"
      }"""
    val cuerpo=HttpEntity(`application/json`,mensaje)
    val resp=Http().singleRequest(HttpRequest(POST,s"$uriPosts",entity=cuerpo))
    
    resp.map{msg=>
      println("Status "+msg.status)
      imprimirResponse(msg)
    }
  }
  
  def ejemploPUT= {
    val mensaje="""
      {
        "userId": 1,
        "title": "Un post corto",
        "body": "El contenido va aqui"
      }"""
    val cuerpo=HttpEntity(`application/json`,mensaje)
    val resp=Http().singleRequest(HttpRequest(PUT,s"$uriPosts/3",entity=cuerpo))
    
    resp.map{msg=>
      println("Status "+msg.status)
      imprimirResponse(msg)
    }
  }
  
   def ejemploPATCH= {
    val mensaje="""
      {
        "title": "Cambio de titulo"
      }"""
    val cuerpo=HttpEntity(`application/json`,mensaje)
    val resp=Http().singleRequest(HttpRequest(PATCH,s"$uriPosts/3",entity=cuerpo))
    
    resp.map{msg=>
      println("Status "+msg.status)
      imprimirResponse(msg)
    }
  }
   
   def ejemploDELETE= {
   
    val resp=Http().singleRequest(HttpRequest(DELETE,s"$uriPosts/300"))  
    resp.map{msg=>println("Status "+msg.status)}
    
    val resp2=Http().singleRequest(HttpRequest(DELETE,s"$uriPosts/3"))  
    resp2.map{msg=>println("Status "+msg.status)}
  }
  //al resp = Http().singleRequest(HttpRequest(GET,paisURI,List(Accept(mediaType))))
  def main(args:Array[String]):Unit={
    //ejemploGETSimple
    //ejemploOPTIONS
    //ejemploHEAD
    //ejemploGET
    //ejemploPOST
    //ejemploPUT
    //ejemploPATCH
    ejemploDELETE
    //ejemploStream
  }
}