package jpcik.fundamentos

object traits {
  trait Artista{
    val nombre:String
    val edad:Int
  }
  
  class Cantante(val nombre:String, val edad:Int, val discos:Int)
    extends Artista
    
  class Actor(val nombre:String,val edad:Int,val peilculas:Int)
   extends Artista
   
  val luzmila=new Cantante("Luzmila Carpio",50,30)//> luzmila  : jpcik.fundamentos.traits.Cantante = jpcik.fundamentos.traits$Cant
                                                  //| ante@48533e64
  val jenny=new Actor("Jenny Serrano",40,2)       //> jenny  : jpcik.fundamentos.traits.Actor = jpcik.fundamentos.traits$Actor@19d
                                                  //| fb72a
  
  val artistas=Seq(luzmila,jenny)                 //> artistas  : Seq[jpcik.fundamentos.traits.Artista] = List(jpcik.fundamentos.t
                                                  //| raits$Cantante@48533e64, jpcik.fundamentos.traits$Actor@19dfb72a)
  
  artistas.foreach(artista=>println(artista.nombre))
                                                  //> Luzmila Carpio
                                                  //| Jenny Serrano
  
}