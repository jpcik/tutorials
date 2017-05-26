package jpcik.fundamentos

import scala.util.Try
import scala.util._

object excepciones {

  def dividir(a:Int,b:Int):Option[Double]=
  try {
    Some(a/b)
  }
  catch {
    case ex:Exception=>
      ex.printStackTrace
      None
  }                                               //> dividir: (a: Int, b: Int)Option[Double]
  
  val div=dividir(3,0)                            //> java.lang.ArithmeticException: / by zero
                                                  //| 	at jpcik.fundamentos.excepciones$$anonfun$main$1.dividir$1(jpcik.fundame
                                                  //| ntos.excepciones.scala:10)
                                                  //| 	at jpcik.fundamentos.excepciones$$anonfun$main$1.apply$mcV$sp(jpcik.fund
                                                  //| amentos.excepciones.scala:18)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at jpcik.fundamentos.excepciones$.main(jpcik.fundamentos.excepciones.sca
                                                  //| la:6)
                                                  //| 	at jpcik.fundamentos.excepciones.main(jpcik.fundamentos.excepciones.scal
                                                  //| a)
                                                  //| div  : Option[Double] = None
  def dividir2(a:Int,b:Int):Try[Double]=
    Try(a/b)                                      //> dividir2: (a: Int, b: Int)scala.util.Try[Double]
    
  val  div2=dividir2(3,0)                         //> div2  : scala.util.Try[Double] = Failure(java.lang.ArithmeticException: / by
                                                  //|  zero)
  div2.isSuccess                                  //> res0: Boolean = false
  div2 match {
    case Success(d)=>println(d)
    case Failure(ex)=>ex.printStackTrace
  }                                               //> java.lang.ArithmeticException: / by zero
                                                  //| 	at jpcik.fundamentos.excepciones$$anonfun$main$1$$anonfun$dividir2$1$1.a
                                                  //| pply$mcD$sp(jpcik.fundamentos.excepciones.scala:20)
                                                  //| 	at jpcik.fundamentos.excepciones$$anonfun$main$1$$anonfun$dividir2$1$1.a
                                                  //| pply(jpcik.fundamentos.excepciones.scala:20)
                                                  //| 	at jpcik.fundamentos.excepciones$$anonfun$main$1$$anonfun$dividir2$1$1.a
                                                  //| pply(jpcik.fundamentos.excepciones.scala:20)
                                                  //| 	at scala.util.Try$.apply(Try.scala:192)
                                                  //| 	at jpcik.fundamentos.excepciones$$anonfun$main$1.dividir2$1(jpcik.fundam
                                                  //| entos.excepciones.scala:20)
                                                  //| 	at jpcik.fundamentos.excepciones$$anonfun$main$1.apply$mcV$sp(jpcik.fund
                                                  //| amentos.excepciones.scala:22)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport
                                                  //| Output exceeds cutoff limit.
  div2.toOption                                   //> res1: Option[Double] = None
  
}