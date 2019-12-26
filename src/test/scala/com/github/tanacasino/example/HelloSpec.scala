package com.github.tanacasino.example

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class HelloSpec extends AnyFlatSpec with Matchers {
  "The Hello object" should "say hello" in {
    Hello.main(Array.empty)
    Hello.greeting shouldBe "hello"
  }
}
