package jpcik.fundamentos

object strings {
  val s1="cadena"                                 //> s1  : String = cadena
  s1.split('a')                                   //> res0: Array[String] = Array(c, den)
  val s2=s"$s1 es un string"                      //> s2  : String = cadena es un string
  val num=34.56                                   //> num  : Double = 34.56
  val s3=f"$s1 y un valor de $num%2.1f"           //> s3  : String = cadena y un valor de 34.6
  val s4="""cadena de
            varias
            líneas"""                             //> s4  : String = cadena de
                                                  //|             varias
                                                  //|             líneas
  "ab,cd,ef;gh;ij".split(",|;")                   //> res1: Array[String] = Array(ab, cd, ef, gh, ij)
  
  val r="[a-z]+".r                                //> r  : scala.util.matching.Regex = [a-z]+
  r.findFirstIn("2653abc7878") match {
    case Some(patron)=>patron
  }                                               //> res2: String = abc
}