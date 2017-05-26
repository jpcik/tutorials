package tests

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class DemoTest extends FlatSpec with Matchers  {

    "Una cadena " should "cumplir" in{
      val s="cadena"
      s should not be (null)
      s.length shouldBe (6)
      s should startWith ("c")
      s should contain ('d')
    }
  }