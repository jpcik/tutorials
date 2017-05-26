package jpcik.fundamentos

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object futuros {
  def operacionLarga={
    Thread.sleep(5000)
    println("terminó larga")
    4
  }                                               //> operacionLarga: => Int
  def operacionCorta={
    Thread.sleep(1)
    println("terminó corta")
  }                                               //> operacionCorta: => Unit
  
  operacionLarga                                  //> terminó larga
                                                  //| res0: Int = 4
  operacionCorta                                  //> terminó corta
  
  val fut=Future(operacionLarga)                  //> fut  : scala.concurrent.Future[Int] = List()
  operacionCorta                                  //> terminó corta
  fut.onComplete { result => println(result) }
  
  
  Future(operacionLarga)                          //> res1: scala.concurrent.Future[Int] = List()
  Future(operacionLarga)                          //> res2: scala.concurrent.Future[Int] = List()
  Future(operacionLarga)                          //> res3: scala.concurrent.Future[Int] = List()
  
  
  Thread.sleep(10000)                             //> terminó larga
                                                  //| Success(4)
                                                  //| terminó larga
                                                  //| terminó larga
                                                  //| terminó larga-
  
}