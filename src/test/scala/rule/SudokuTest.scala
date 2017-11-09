package rule

import model.{Board, Fill, Position}
import org.scalatest.prop.Checkers
import org.scalatest.{FunSpec, Matchers}

class SudokuTest extends FunSpec with Checkers with Matchers {
  describe("A Sudoku") {

    it("is valid when all board cells are empty") {
      val b = new Board()
      assert(Sudoku.isValid(b))
    }

    it("should be valid all filled cells are unique in the same in a row") {
      val b = new Board()
      b.setCell(Fill(1), Position(0, 0))
      assert(Sudoku.isValid(b))
    }

    it("should be invalid when two numbers are the same in a row") {
      val b = new Board()
      b.setCell(Fill(1), Position(0, 0))
      b.setCell(Fill(1), Position(0, 1))
      assert(Sudoku.isValid(b) == false)
    }
  }
}
