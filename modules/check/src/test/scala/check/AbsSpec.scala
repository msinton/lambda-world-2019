package check

import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

object Abs {

  def abs(x: Int): Int =
    if (x < 0) -x else x
}

object AbsSpec extends Properties("Abs") {

  import Abs._

  property("non-negative") = forAll { (i: Int) =>
    abs(i) >= 0
  }
}
