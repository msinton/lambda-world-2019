package check

import org.scalacheck._
import org.scalacheck.Prop.forAll

object DiamondKataSpec extends Properties("DiamondKata") {

  import DiamondKata._

  val charAToZ = Gen.choose('A', 'Z')
  val charBToZ = Gen.choose('B', 'Z')

  property("line length == 2 * (distance from A plus 1), when char >= A") = forAll(charAToZ) { c =>
    diamond(c).length == 2 * (c - 'A').toInt + 1
  }

  property("starts with A") = forAll(charAToZ) { c =>
    diamond(c).head.contains("A")
  }

  property("the middle content has a repeated value") = forAll(charBToZ) { c =>
    diamond(c).tail.init.forall { s =>
      val List(head, last) = s.replaceAll(" ", "").toList
      head == last
    }
  }

  property("the last value is the char") = forAll(charAToZ) { c =>
    val List(last) = diamond(c).reverse.drop(1).head.replaceAll(" ", "").toList
    last == c
  }

}
