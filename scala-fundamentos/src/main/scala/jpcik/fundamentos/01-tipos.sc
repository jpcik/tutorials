package jpcik.fundamentos

// Fundamentos de Scala

object tipos {
  println("Tipos de datos en Scala")              //> Tipos de datos en Scala
  1                                               //> res0: Int(1) = 1
  true                                            //> res1: Boolean(true) = true
  2+3                                             //> res2: Int(5) = 5
  2.4+3                                           //> res3: Double(5.4) = 5.4
  math.Pi                                         //> res4: Double(3.141592653589793) = 3.141592653589793
  math.log(1)                                     //> res5: Double = 0.0
  "cadena"                                        //> res6: String("cadena") = cadena
  "cadena" + 4                                    //> res7: String = cadena4
// esto devuelve una excepción
//  3/0
  2.+(3)                                          //> res8: Int(5) = 5
  "34".toInt < 20                                 //> res9: Boolean = false
}