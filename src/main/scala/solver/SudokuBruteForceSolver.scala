package solver

import model.{Board, Empty, Fill}
import rule.Sudoku

/**
  *  Brute force solver for sudokus
  *
  *  Current implementation works for Sudokus where
  *  there is just one possible solution
 */
object SudokuBruteForceSolver {

  private def AnyEmptyCell(b : Board) : Boolean = {
    !b.positions.forall(b.getCell(_) != Empty())
  }

  def solve(b : Board) : Unit = {

    while (AnyEmptyCell(b)) {

      val emptyPositions = b.positions.filter(b.getCell(_) == Empty())

      for (emptyPos <- emptyPositions) {

        var goodSolutions = List[Short]()

        for( n <- 1 to 9){
          b.setCell(Fill(n.toShort), emptyPos)
          if (Sudoku(b)) {
            goodSolutions = goodSolutions ++ List(n.toShort)
          }
        }

        if (goodSolutions.length == 1) { // Only when 1 possible solution is good !
          b.setCell(Fill(goodSolutions(0)), emptyPos)
        } else {
          b.setCell(Empty(), emptyPos)
        }

      }

    }
  }
}
