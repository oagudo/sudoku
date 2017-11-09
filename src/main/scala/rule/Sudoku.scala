package rule

import model._

object Sudoku {

  def isValid(b : Board) : Boolean = {

    def getFilledCells(row : Int) : List[Fill] = {
      val rowCells = (0 until 9).map(col => b.getCell(Position(row, col)))
      rowCells.collect {case c : Fill => c}.toList
    }

    val rows = for {
      row <- 0 until 9
    } yield getFilledCells(row)

    rows.forall(r => r.toSet.size == r.size)

  }
}
