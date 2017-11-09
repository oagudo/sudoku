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

private object RowRule {
  def apply(b : Board): Boolean = {
    NonRepeatedInLineRule(b, { (b,r) => b.getRow(r) })
  }
}

private object ColRule {
  def apply(b : Board): Boolean = {
    NonRepeatedInLineRule(b, { (b,c) => b.getCol(c) })
  }
}

object Sudoku {
  def apply(b : Board) : Boolean = {
      RowRule(b) && ColRule(b)
  }
}
