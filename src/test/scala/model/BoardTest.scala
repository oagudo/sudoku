package model

import org.scalatest.prop.Checkers
import org.scalatest.{FunSpec, Matchers}

class BoardTest extends FunSpec with Checkers with Matchers {
  describe("A Board") {

    it("should initialize all cells to empty") {
      val b = new Board()
      assert(b.positions.forall(b.getCell(_) == Empty()))
    }
  }


  describe("A Cell") {

    it("can be empty") {
      Empty()
    }

    it("can be filled with a number between range [1 .. 9]") {
      Fill(1)
    }

    it("cannot be filled with a number out of range [1 .. 9]") {
      an [IllegalArgumentException] shouldBe thrownBy {
        Fill(0)
      }
    }
  }
}
