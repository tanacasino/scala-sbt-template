package com.github.tanacasino.example

import org.scalatest._

class HelloSpec extends FlatSpec with Matchers {
  "The Hello object" should "say hello" in {
    Hello.main(Array.empty)
    Hello.greeting shouldBe "hello"
  }
}
