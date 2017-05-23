package jpcik.fundamentos

import math._

object funciones {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(89); val res$0 = 
  (s:String) => "cadena" + s;System.out.println("""res0: String => String = """ + $show(res$0));$skip(36); 
  val sumarPi = (num:Int) => Pi+num;System.out.println("""sumarPi  : Int => Double = """ + $show(sumarPi ));$skip(14); val res$1 = 
  sumarPi(23);System.out.println("""res1: Double = """ + $show(res$1));$skip(69); 
  val calcular=(n1:Int,n2:Double) => {
    val n3=n1*n2
    n3*5
  };System.out.println("""calcular  : (Int, Double) => Double = """ + $show(calcular ));$skip(18); val res$2 = 
  calcular(3,4.5);System.out.println("""res2: Double = """ + $show(res$2))}
}
