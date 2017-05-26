package jpcik.fundamentos

import org.joda.time.DateTime
import collection.JavaConversions._

object javaconv {
  "esta cadena".getClass                          //> res0: Class[?0] = class java.lang.String
  
  val fecha=DateTime.now                          //> fecha  : org.joda.time.DateTime = 2017-05-26T21:44:14.778+02:00
  fecha.toTimeOfDay()                             //> res1: org.joda.time.TimeOfDay = T21:44:14.778
  
  val javaLista=new java.util.ArrayList[String]   //> javaLista  : java.util.ArrayList[String] = []
  javaLista.add("a")                              //> res2: Boolean = true
  javaLista.add("b")                              //> res3: Boolean = true
  javaLista.add("c")                              //> res4: Boolean = true
  
  javaLista.foreach(println)                      //> a
                                                  //| b
                                                  //| c
  javaLista.map(_.toUpperCase)                    //> res5: scala.collection.mutable.Buffer[String] = ArrayBuffer(A, B, C)
  
  
}