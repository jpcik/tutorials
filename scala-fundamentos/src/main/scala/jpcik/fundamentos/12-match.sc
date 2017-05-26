package jpcik.fundamentos

object matches {
  
  def evaluar(nota:String)={
    nota match {
      case "A" => 70
      case "B" => 50
      case "F" => 30
      case _ => 0
    }
  }                                               //> evaluar: (nota: String)Int
  
  evaluar("B")                                    //> res0: Int = 50
  evaluar("h")                                    //> res1: Int = 0
  
  def verificar(a:Any)=a match{
    case "A" => "una letra A"
    case 4   => "un int 45"
    case 4.5 => "un double 4.5"
  }                                               //> verificar: (a: Any)String
  verificar("A")                                  //> res2: String = una letra A
  // match error
  //verificar("a")
  
 def verificar2(a:Any)=a match {
   case s:String => "string"
   case d:Double => "double"
   case i:Int    => "int"
   case _ => "otro"
 }                                                //> verificar2: (a: Any)String
 
 Seq("ab",5,3.4,"2",List).map(verificar2)         //> res3: Seq[String] = List(string, int, double, string, otro)
 
  trait Region{
    val nombre:String
  }
  case class Departamento(nombre:String) extends Region
  case class Provincia(nombre:String,dpto:Departamento) extends Region
  case class Municipio(nombre:String,prov:Provincia) extends Region
  
  val cocha=Departamento("Cochabamba")            //> cocha  : jpcik.fundamentos.matches.Departamento = Departamento(Cochabamba)
  val cercado=Provincia("Cercado",cocha)          //> cercado  : jpcik.fundamentos.matches.Provincia = Provincia(Cercado,Departame
                                                  //| nto(Cochabamba))
  val chuqui=Departamento("Chuquisaca")           //> chuqui  : jpcik.fundamentos.matches.Departamento = Departamento(Chuquisaca)
  val oropeza=Provincia("Oropeza",chuqui)         //> oropeza  : jpcik.fundamentos.matches.Provincia = Provincia(Oropeza,Departame
                                                  //| nto(Chuquisaca))
  val sucre=Municipio("Sucre",oropeza)            //> sucre  : jpcik.fundamentos.matches.Municipio = Municipio(Sucre,Provincia(Or
                                                  //| opeza,Departamento(Chuquisaca)))
  
  val list:Seq[Region]=Seq(cocha,cercado,oropeza,sucre)
                                                  //> list  : Seq[jpcik.fundamentos.matches.Region] = List(Departamento(Cochabamb
                                                  //| a), Provincia(Cercado,Departamento(Cochabamba)), Provincia(Oropeza,Departam
                                                  //| ento(Chuquisaca)), Municipio(Sucre,Provincia(Oropeza,Departamento(Chuquisac
                                                  //| a))))
  list map {
   case Departamento(nom) => s"Depto $nom"
   case Provincia(nom,dpto) => s"prov $nom en ${dpto.nombre}"
   case Municipio(nom,prov) => s"muni $nom en ${prov.nombre}, dpto ${prov.dpto.nombre}"
  }                                               //> res4: Seq[String] = List(Depto Cochabamba, prov Cercado en Cochabamba, prov
                                                  //|  Oropeza en Chuquisaca, muni Sucre en Oropeza, dpto Chuquisaca)
  list map {
   case d:Departamento => s"Depto ${d.nombre}"
   case p:Provincia => s"prov ${p.nombre} en ${p.dpto.nombre}"
   case m:Municipio => s"muni ${m.nombre} en ${m.prov.nombre}, dpto ${m.prov.dpto.nombre}"
  }                                               //> res5: Seq[String] = List(Depto Cochabamba, prov Cercado en Cochabamba, prov
                                                  //|  Oropeza en Chuquisaca, muni Sucre en Oropeza, dpto Chuquisaca)
  
  list map (_.nombre)                             //> res6: Seq[String] = List(Cochabamba, Cercado, Oropeza, Sucre)
}