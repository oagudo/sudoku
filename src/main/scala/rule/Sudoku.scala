package rule

import model._

private object NonRepeatedInLineRule {

  def apply(b : Board, extractLineFun : (Board, Int) => List[Cell]): Boolean = {

    val lines = for {
      line <- 0 until 9
    } yield extractLineFun(b, line).collect {case c : Fill => c}

    lines.forall(l => l.toSet.size == l.size) // all are uniques
  }
}

private object NonRepeatedInRowRule {
  def apply(b : Board): Boolean = {
    NonRepeatedInLineRule(b, { (b,r) => b.getRow(r) })
  }
}

private object NonRepeatedInColRule {
  def apply(b : Board): Boolean = {
    NonRepeatedInLineRule(b, { (b,c) => b.getCol(c) })
  }
}

private object NonRepeatedInSmallSquare {

  def apply(b : Board): Boolean = {
    val squares = b.getSquares()
    squares.forall(s => {
      val filledCells = s.collect {case c : Fill => c}
      filledCells.toSet.size == filledCells.size // all are uniques
    } )
  }
}

object Sudoku {
  def apply(b : Board) : Boolean = {

      NonRepeatedInRowRule(b) &&
      NonRepeatedInColRule(b) &&
      NonRepeatedInSmallSquare(b)

  }
}
