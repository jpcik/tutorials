package jpcik.fundamentos

import scala.collection.mutable.ArrayBuffer
import collection.JavaConverters._

object collecciones {
  val arr1=Array(3,5,6,4)                         //> arr1  : Array[Int] = Array(3, 5, 6, 4)
  val arr2=Array(Array(5,4,2),
                 Array(3,2,4),
                 Array(1,5,4))                    //> arr2  : Array[Array[Int]] = Array(Array(5, 4, 2), Array(3, 2, 4), Array(1, 5
                                                  //| , 4))
  arr1(2)                                         //> res0: Int = 6
  arr2.flatten                                    //> res1: Array[Int] = Array(5, 4, 2, 3, 2, 4, 1, 5, 4)
  val arr3=ArrayBuffer(3,2,4)                     //> arr3  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(3, 2, 4)
  arr3+=4                                         //> res2: jpcik.fundamentos.collecciones.arr3.type = ArrayBuffer(3, 2, 4, 4)
  val map1=Map("cbba"->"Cochabamba","lp"->"La Paz","tri"->"Trinidad")
                                                  //> map1  : scala.collection.immutable.Map[String,String] = Map(cbba -> Cochabam
                                                  //| ba, lp -> La Paz, tri -> Trinidad)
  map1("cbba")                                    //> res3: String = Cochabamba
  map1.getOrElse("abc", "ninguno")                //> res4: String = ninguno
  val bol=("bol","Bolivia")                       //> bol  : (String, String) = (bol,Bolivia)
  val chi=("chi","Chile")                         //> chi  : (String, String) = (chi,Chile)
  val arg=("arg","Argentina")                     //> arg  : (String, String) = (arg,Argentina)
  Seq(bol,chi,arg).toMap                          //> res5: scala.collection.immutable.Map[String,String] = Map(bol -> Bolivia, ch
                                                  //| i -> Chile, arg -> Argentina)
  map1.asJava                                     //> res6: java.util.Map[String,String] = {cbba=Cochabamba, lp=La Paz, tri=Trinid
                                                  //| ad}
}