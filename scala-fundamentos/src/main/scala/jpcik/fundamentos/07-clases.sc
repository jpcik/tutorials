package jpcik.fundamentos

object clases {
  class Banda(nombre:String,genero:String)
  val kjarkas=new Banda("Kjarkas","folclore")     //> kjarkas  : jpcik.fundamentos.clases.Banda = jpcik.fundamentos.clases$Banda@7
                                                  //| e0b37bc
  
  class Musico(val nombre:String,banda:Banda) {
    def cantar(cancion:String)={
      println(s"♫♫  $cancion ♫♫")
    }
  }
  val elmer=new Musico("Elmer Hermosa",kjarkas)   //> elmer  : jpcik.fundamentos.clases.Musico = jpcik.fundamentos.clases$$anonfun
                                                  //| $main$1$Musico$1@7e0ea639
  elmer.cantar("bolivia")                         //> ♫♫  bolivia ♫♫
  
  println(elmer.nombre)                           //> Elmer Hermosa
  //println(elmer.banda)
  
  class Instrumento(nombre:String,esAutoctono:Boolean=false){
    override def toString=s"El instrumento: $nombre"
  }
  val charango=new Instrumento("charango",true)   //> charango  : jpcik.fundamentos.clases.Instrumento = El instrumento: charango
  val bajo=new Instrumento("bajo")                //> bajo  : jpcik.fundamentos.clases.Instrumento = El instrumento: bajo
  
  println(bajo)                                   //> El instrumento: bajo
}