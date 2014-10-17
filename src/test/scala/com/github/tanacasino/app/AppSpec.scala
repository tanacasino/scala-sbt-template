package com.github.tanacasino.app

import org.scalatest.{FunSpec, Matchers}

class AppSpec extends FunSpec with Matchers {
  describe("main") {
    describe("when no arguments") {
      it("it should run successfully") {
        App.main(Array.empty)
      }
    }
  }
}
