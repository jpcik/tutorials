package jpcik.fundamentos

object listas {
  List(1,3,5,6,9)                                 //> res0: List[Int] = List(1, 3, 5, 6, 9)
  Seq(3,6,8,9)                                    //> res1: Seq[Int] = List(3, 6, 8, 9)
  (1 to 6)                                        //> res2: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6)
  (0 until 10)                                    //> res3: scala.collection.immutable.Range = Range(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
                                                  //| 
  val lista=(1 to 5)                              //> lista  : scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5)
  lista.filter(i => i<4)                          //> res4: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2, 3)
  lista.filter(i=>i%2==0)                         //> res5: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 4)
  lista.map(i=>i*2)                               //> res6: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 4, 6, 8, 10)
  lista.sum                                       //> res7: Int = 15
  lista.foreach(i => println(s"*$i*"))            //> *1*
                                                  //| *2*
                                                  //| *3*
                                                  //| *4*
                                                  //| *5*
  
  val lista2=List(3,5.6,45,"hola",34.5,"chau")    //> lista2  : List[Any] = List(3, 5.6, 45, hola, 34.5, chau)
  lista2.head                                     //> res8: Any = 3
  lista2.take(3)                                  //> res9: List[Any] = List(3, 5.6, 45)
  "adios" :: lista2                               //> res10: List[Any] = List(adios, 3, 5.6, 45, hola, 34.5, chau)
  List(20,30) ::: List(40,50)                     //> res11: List[Int] = List(20, 30, 40, 50)
  lista2.map {
    case s:String=>"*"
    case _ => "+"
  }                                               //> res12: List[String] = List(+, +, +, *, +, *)
}