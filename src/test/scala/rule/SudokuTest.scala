package rule

import model.Board
import org.scalatest.prop.Checkers
import org.scalatest.{FunSpec, Matchers}

class SudokuTest extends FunSpec with Checkers with Matchers {
  describe("A Sudoku") {

    it("is valid when all board cells are empty") {
      val b = new Board()
      assert(Sudoku.isValid(b))
    }
  }
}
