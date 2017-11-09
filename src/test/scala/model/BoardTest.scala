package model

import org.scalatest.prop.Checkers
import org.scalatest.{FunSpec, Matchers}

class BoardTest extends FunSpec with Checkers with Matchers {
  describe("A Board") {

    it("should initialize all cells to empty") {
      val b = new Board()
      assert(b.positions.forall(b.getCell(_) == Empty()))
    }

    it("is divided into 9 small squares which can be retrieved") {
      val b = new Board()

      // First small square
      b.setCell(Fill(1), Position(0,0))
      b.setCell(Fill(2), Position(1,1))
      b.setCell(Fill(3), Position(2,2))

      // Fourth small square
      b.setCell(Fill(4), Position(3,0))
      b.setCell(Fill(5), Position(4,1))
      b.setCell(Fill(6), Position(5,2))

      // Nineth small square
      b.setCell(Fill(7), Position(6,6))
      b.setCell(Fill(8), Position(7,7))
      b.setCell(Fill(9), Position(8,8))

      val squares = b.getSquares()

      // First small square
      assert(squares(0)(0) == Fill(1))
      assert(squares(0)(4) == Fill(2))
      assert(squares(0)(8) == Fill(3))

      // Fourth small square
      assert(squares(3)(0) == Fill(4))
      assert(squares(3)(4) == Fill(5))
      assert(squares(3)(8) == Fill(6))

      // Nineth small square
      assert(squares(8)(0) == Fill(6))
      assert(squares(8)(4) == Fill(7))
      assert(squares(8)(8) == Fill(8))
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
