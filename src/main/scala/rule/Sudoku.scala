package rule

import model._

object Sudoku {

  def isValid(b : Board) : Boolean = {

    def getFilledRowCells(row : Int) : List[Fill] = {
      val rowCells = (0 until 9).map(col => b.getCell(Position(row, col)))
      rowCells.collect {case c : Fill => c}.toList
    }

    def getFilledColCells(col : Int) : List[Fill] = {
      val colCells = (0 until 9).map(row => b.getCell(Position(row, col)))
      colCells.collect {case c : Fill => c}.toList
    }

    val rows = for {
      row <- 0 until 9
    } yield getFilledRowCells(row)

    if (!rows.forall(r => r.toSet.size == r.size))
      return false

    val columns = for {
      col <- 0 until 9
    } yield getFilledColCells(col)

    if (!columns.forall(c => c.toSet.size == c.size))
      return false

    return true
  }
}
