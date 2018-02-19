package solver

import model.{Board, Empty, Fill, Position}
import rule.Sudoku

/**
  *  Brute force solver for sudokus
  *
  *  Backtracking implementation for solving sudokus
 */
object SudokuBruteForceSolver {

  private def emptyPositions(b : Board) : List[Position] = {
    b.positions.filter(b.getCell(_) == Empty()).toList
  }

  private def anyEmptyCell(b : Board) : Boolean = {
    emptyPositions(b).length > 0
  }

  def backtrackingSolver(b : Board) : Boolean = {

    if (!anyEmptyCell(b))
      return true

    val emptyPosition = emptyPositions(b)(0)

    for (i <- (1 to 9)) {

      b.setCell(Fill(i.toShort), emptyPosition)

      if (Sudoku(b) && backtrackingSolver(b)) {
            return true
      }
      // Undo the current cell for backtracking
      b.setCell(Empty(), emptyPosition)
    }
    return false
  }

  def solve(b : Board) : Unit = backtrackingSolver(b)
}
