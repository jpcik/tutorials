package jpcik.fundamentos

import scala.collection.mutable.ArrayBuffer
import scala.language.implicitConversions
import java.util.UUID
import com.sun.xml.internal.messaging.saaj.util.Base64

object implicitos {
  class PlatoTipico{
    val ingredientes=new ArrayBuffer[Ingrediente]
  }
  case class Ingrediente(i:String)
  
  def aumentar(ing:Ingrediente)(implicit plato:PlatoTipico)={
    plato.ingredientes+=ing
  }                                               //> aumentar: (ing: jpcik.fundamentos.implicitos.Ingrediente)(implicit plato: jp
                                                  //| cik.fundamentos.implicitos.PlatoTipico)scala.collection.mutable.ArrayBuffer[
                                                  //| jpcik.fundamentos.implicitos.Ingrediente]
  
  implicit val silpancho=new PlatoTipico          //> silpancho  : jpcik.fundamentos.implicitos.PlatoTipico = jpcik.fundamentos.im
                                                  //| plicitos$PlatoTipico@1d251891
  aumentar(Ingrediente("huevo"))                  //> res0: scala.collection.mutable.ArrayBuffer[jpcik.fundamentos.implicitos.Ingr
                                                  //| ediente] = ArrayBuffer(Ingrediente(huevo))
  aumentar(Ingrediente("arroz"))                  //> res1: scala.collection.mutable.ArrayBuffer[jpcik.fundamentos.implicitos.Ingr
                                                  //| ediente] = ArrayBuffer(Ingrediente(huevo), Ingrediente(arroz))
  println(silpancho.ingredientes)                 //> ArrayBuffer(Ingrediente(huevo), Ingrediente(arroz))
  
  implicit def strToIngrediente(s:String)=Ingrediente(s)
                                                  //> strToIngrediente: (s: String)jpcik.fundamentos.implicitos.Ingrediente
  
  aumentar("apanado")                             //> res2: scala.collection.mutable.ArrayBuffer[jpcik.fundamentos.implicitos.Ingr
                                                  //| ediente] = ArrayBuffer(Ingrediente(huevo), Ingrediente(arroz), Ingrediente(a
                                                  //| panado))
  implicit class StringPlus(s:String){
    def quitarEspacios=s.replaceAll(" ","")
    def codificar=Base64.encode(s.getBytes)
  }
  
  "la unión es la fuerza".quitarEspacios          //> res3: String = launióneslafuerza
  "catecbol".codificar                            //> res4: Array[Byte] = Array(89, 50, 70, 48, 90, 87, 78, 105, 98, 50, 119, 61)
}