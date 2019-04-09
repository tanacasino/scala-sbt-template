package com.github.tanacasino.example

import org.scalatest._

class OptionSpec extends WordSpec with Matchers {

  "A Option" should {

    val o1: Option[Int] = Some(1)
    val o2: Option[Int] = Option(1)
    val o3: Option[Int] = None
    val o4: Option[Int] = Option.none

    "apply" in {
      o1 shouldBe o2
      o3 shouldBe o4
    }

    "isDefined" in {
      o1.isDefined shouldBe true
      o2.isDefined shouldBe true
    }

    "isEmpty" in {
      o3.isEmpty shouldBe true
      o4.isEmpty shouldBe true
    }

    "foreach" when {
      "Some" in {
        var called: Boolean   = false
        val stub: Int => Unit = _ => called = true
        o1.foreach(stub)
        called shouldBe true
      }
      "None" in {
        var called: Boolean   = false
        val stub: Int => Unit = _ => called = true
        o3.foreach(stub)
        called shouldBe false
      }
    }

    "map" in {
      o1.map(a1 => a1 + 2) shouldBe Option(3)
      o3.map(a3 => a3 + 2) shouldBe None
    }

    "getOrElse" in {
      o1.getOrElse(0) shouldBe 1
      o2.getOrElse(0) shouldBe 1
      o3.getOrElse(0) shouldBe 0
      o4.getOrElse(0) shouldBe 0
    }

    "flatMap" in {
      val actual1 = o1.flatMap { a1 =>
        o2.map { a2 =>
          a1 + a2
        }
      }
      actual1 shouldBe Option(2)

      val actual2 = for {
        a1 <- o1
        a2 <- o2
      } yield a1 + a2
      actual2 shouldBe Option(2)

      val actual3 = for {
        a1 <- o1
        a3 <- o3
      } yield a1 + a3
      actual3 shouldBe None
    }

    "orElse" in {
      o1.orElse(Some(2)) shouldBe o1
      o3.orElse(Some(2)) shouldBe Some(2)
    }

    "filter" in {
      o1.filter(_ == 1) shouldBe o1
      o1.filter(_ != 1) shouldBe None
      o3.filter(_ == 1) shouldBe None
      o3.filter(_ != 1) shouldBe None

      o1.filterViaFlatMap(_ == 1) shouldBe o1
      o1.filterViaFlatMap(_ != 1) shouldBe None
      o3.filterViaFlatMap(_ == 1) shouldBe None
      o3.filterViaFlatMap(_ != 1) shouldBe None
    }

    "fold" in {
      o1.fold(5, _ + 1) shouldBe 2
      o1.fold(5, _.toString) shouldBe "1"
      o3.fold(5, _ + 1) shouldBe 5
    }

    "lift" in {
      val f: Int => String = _.toString
      val lifted           = Option.lift(f)
      f(12) shouldBe "12"
      lifted(Some(12)) shouldBe Some("12")
    }

    "map2" in {
      Option.map2(o1, o2)(_ + _) shouldBe Some(2)
    }

    "traverse" in {
      val l1 = List(1, 2, 3)
      val l2 = List(2, 4, 6)
      Option.traverse(l1)(Some.apply) shouldBe Some(l1)
      Option.traverse(l1)(a => Option(a).filter(_ % 2 == 0)) shouldBe None
      Option.traverse(l2)(a => Option(a).filter(_ % 2 == 0)) shouldBe Some(l2)
    }

    "sequence" in {
      val l1: List[Option[Int]] = List(Option(1), Option(2), Option(3))
      val l2: List[Option[Int]] = List(Option(1), Option(2), None)
      Option.sequence(l1) shouldBe Some(List(1, 2, 3))
      Option.sequence(l2) shouldBe None
    }

  }

}
