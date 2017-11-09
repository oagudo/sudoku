package model

import org.scalatest.{FunSpec, Matchers}
import org.scalatest.prop.Checkers

class BoardTest extends FunSpec with Checkers with Matchers {
  describe("A Board") {

    it("should have positions") {
      val s = new Board()
      s.positions
    }
  }

  describe("A Position") {

    it("can be empty") {
      Empty()
    }

    it("can be filled with a number between 1 and 9") {
      Fill(1)
    }

    it("cannot be filled with a number between 1 and 9") {
      an [IllegalArgumentException] shouldBe thrownBy {
        Fill(0)
      }
    }
  }
}
