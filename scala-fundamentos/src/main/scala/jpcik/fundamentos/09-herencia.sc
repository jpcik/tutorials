package jpcik.fundamentos

object herencia {

  class Cancion(val titulo:String)
  trait Cantante{
    def cantar(cancion:Cancion)
  }
  
  trait Compositor{
    def componer(titulo:String):Cancion
  }
  
  class Cantautor extends Cantante with Compositor{
    def componer(titulo:String)={
      new Cancion(titulo)
    }
    def cantar(cancion:Cancion)=
      println(s"♫♫  ${cancion.titulo} ♫♫")
  }
  
  val matilde=new Cantautor                       //> matilde  : jpcik.fundamentos.herencia.Cantautor = jpcik.fundamentos.herencia
                                                  //| $Cantautor@48533e64
  val regreso=matilde.componer("Regreso")         //> regreso  : jpcik.fundamentos.herencia.Cancion = jpcik.fundamentos.herencia$C
                                                  //| ancion@19dfb72a
  matilde.cantar(regreso)                         //> ♫♫  Regreso ♫♫
  
  
  
}