package jpcik.fundamentos

object valores {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(55); 
  val num=3;System.out.println("""num  : Int = """ + $show(num ));$skip(15); 
  println(num);$skip(26); 
  val texto="go catecbol";System.out.println("""texto  : String = """ + $show(texto ));$skip(17); 
  val num2:Int=3;System.out.println("""num2  : Int = """ + $show(num2 ));$skip(30); 
  val mix="texto" + 34 + true;System.out.println("""mix  : String = """ + $show(mix ));$skip(13); 
  var num3=3;System.out.println("""num3  : Int = """ + $show(num3 ));$skip(11); 
  num3 = 5}
  // no se puede reasignar un val
  //num2 = 5
  // no se puede reasignar con un tipo incompatible
  //num3 = "texto"
}
