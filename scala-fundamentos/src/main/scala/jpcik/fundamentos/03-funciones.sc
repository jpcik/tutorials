package jpcik.fundamentos

import math._

object funciones {
  (s:String) => "cadena" + s                      //> res0: String => String = <function1>
  val sumarPi = (num:Int) => Pi+num               //> sumarPi  : Int => Double = <function1>
  sumarPi(23)                                     //> res1: Double = 26.141592653589793
  val calcular=(n1:Int,n2:Double) => {
    val n3=n1*n2
    n3*5
  }                                               //> calcular  : (Int, Double) => Double = <function2>
  calcular(3,4.5)                                 //> res2: Double = 67.5
}