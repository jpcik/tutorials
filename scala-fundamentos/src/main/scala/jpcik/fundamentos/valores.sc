package jpcik.fundamentos

object valores {
  val num=3                                       //> num  : Int = 3
  println(num)                                    //> 3
  val texto="go catecbol"                         //> texto  : String = go catecbol
  val num2:Int=3                                  //> num2  : Int = 3
  val mix="texto" + 34 + true                     //> mix  : String = texto34true
  var num3=3                                      //> num3  : Int = 3
  num3 = 5
  // no se puede reasignar un val
  //num2 = 5
  // no se puede reasignar con un tipo incompatible
  //num3 = "texto"
}