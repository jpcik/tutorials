package jpcik.fundamentos

object cases {
  case class PlatoTipico(nombre:String,departamento:String)
  
  val majao=PlatoTipico("majadito","Santa Cruz")  //> majao  : jpcik.fundamentos.cases.PlatoTipico = PlatoTipico(majadito,Santa Cr
                                                  //| uz)
  val fricase=PlatoTipico("fricase","La Paz")     //> fricase  : jpcik.fundamentos.cases.PlatoTipico = PlatoTipico(fricase,La Paz)
                                                  //| 
  println(majao.departamento)                     //> Santa Cruz
  
  val majadito=PlatoTipico("majadito","Santa Cruz")
                                                  //> majadito  : jpcik.fundamentos.cases.PlatoTipico = PlatoTipico(majadito,Santa
                                                  //|  Cruz)
  
  majao == majadito                               //> res0: Boolean = true
  val sonso=majao.copy(nombre="sonso")            //> sonso  : jpcik.fundamentos.cases.PlatoTipico = PlatoTipico(sonso,Santa Cruz)
                                                  //| 
  println(sonso)                                  //> PlatoTipico(sonso,Santa Cruz)
   
}