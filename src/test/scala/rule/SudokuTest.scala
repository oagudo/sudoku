package rule

import model.{Board, Fill, Position}
import org.scalatest.prop.Checkers
import org.scalatest.{FunSpec, Matchers}

class SudokuTest extends FunSpec with Checkers with Matchers {
  describe("A Sudoku") {

    it("is valid when all board cells are empty") {
      val b = new Board()
      assert(Sudoku(b))
    }

    it("should be valid if all filled cells are unique in the same in a row") {
      val b = new Board()
      b.setCell(Fill(1), Position(0, 0))
      assert(Sudoku(b))
    }

    it("should be invalid if two filled cells are repeated in a row") {
      val b = new Board()
      b.setCell(Fill(1), Position(0, 0))
      b.setCell(Fill(1), Position(0, 1))
      assert(Sudoku(b) == false)
    }

    it("should be invalid if two filled cells are repeated in a column") {
      val b = new Board()
      b.setCell(Fill(7), Position(0, 0))
      b.setCell(Fill(7), Position(1, 0))
      assert(Sudoku(b) == false)
    }

    it("should be invalid if two filled cells are repeated in a small square") {
      val b = new Board()
      b.setCell(Fill(7), Position(0, 0))
      b.setCell(Fill(7), Position(1, 1))
      assert(Sudoku(b) == false)
    }
  }
}
