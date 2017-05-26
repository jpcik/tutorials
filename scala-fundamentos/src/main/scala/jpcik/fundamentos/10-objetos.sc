package jpcik.fundamentos

object objetos {
  class Departamento(val nombre:String)
  object Cochabamba extends Departamento("Cochabamba")
  object Beni extends Departamento("Beni")
  
  def iniciales(dpto:Departamento)=
    dpto.nombre.take(3)                           //> iniciales: (dpto: jpcik.fundamentos.objetos.Departamento)String
    
  iniciales(Beni)                                 //> res0: String = Ben
  
  object Departamento{
    def apply(s:String)=new Departamento(s)
  }
  
  Departamento("Tarija")                          //> res1: jpcik.fundamentos.objetos.Departamento = jpcik.fundamentos.objetos$Dep
                                                  //| artamento@6fadae5d
  
  object Geometria {
    def area(radio:Int)=math.Pi*radio*radio
  }
  
  Geometria.area(4)                               //> res2: Double = 50.26548245743669
  
}