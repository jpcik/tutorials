package jpcik.fundamentos

// Fundamentos de Scala

object tipos {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(103); 
  println("Tipos de datos en Scala");$skip(4); val res$0 = 
  1;System.out.println("""res0: Int(1) = """ + $show(res$0));$skip(7); val res$1 = 
  true;System.out.println("""res1: Boolean(true) = """ + $show(res$1));$skip(6); val res$2 = 
  2+3;System.out.println("""res2: Int(5) = """ + $show(res$2));$skip(8); val res$3 = 
  2.4+3;System.out.println("""res3: Double(5.4) = """ + $show(res$3));$skip(10); val res$4 = 
  math.Pi;System.out.println("""res4: Double(3.141592653589793) = """ + $show(res$4));$skip(14); val res$5 = 
  math.log(1);System.out.println("""res5: Double = """ + $show(res$5));$skip(11); val res$6 = 
  "cadena";System.out.println("""res6: String("cadena") = """ + $show(res$6));$skip(15); val res$7 = 
  "cadena" + 4;System.out.println("""res7: String = """ + $show(res$7));$skip(48); val res$8 = 
// esto devuelve una excepción
//  3/0
  2.+(3);System.out.println("""res8: Int(5) = """ + $show(res$8));$skip(18); val res$9 = 
  "34".toInt < 20;System.out.println("""res9: Boolean = """ + $show(res$9))}
}
