package jpcik.fundamentos

object opciones {
   
   val equipos=Map("lp"->"The Strongest",
                   "scz"->"Oriente",
                   "cocha"->"Wilster",
                   "oru"->"San Jose")             //> equipos  : scala.collection.immutable.Map[String,String] = Map(lp -> The Str
                                                  //| ongest, scz -> Oriente, cocha -> Wilster, oru -> San Jose)

   def obtenerEquipo(dpto:String):Option[String]={
     equipos.get(dpto)
   }                                              //> obtenerEquipo: (dpto: String)Option[String]
   
   def hayEquipo(dpto:String)=equipos.get(dpto) match {
     case Some(eq) => println(s"el equipo es $eq")
     case None => println("no hay equipo")
   }                                              //> hayEquipo: (dpto: String)Unit
   
   hayEquipo("scz")                               //> el equipo es Oriente
   hayEquipo("abc")                               //> no hay equipo
   
   case class Persona(nombre:String,email:Option[String])
   
   Persona("felix",Some("felix@home.org"))        //> res0: jpcik.fundamentos.opciones.Persona = Persona(felix,Some(felix@home.org
                                                  //| ))
   Persona("lucas",None)                          //> res1: jpcik.fundamentos.opciones.Persona = Persona(lucas,None)
   
}