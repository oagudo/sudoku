package inout

import model.{Board, Empty, Fill, Position}

object SudokuPrinter {

  def print(b : Board): Unit = {
    for(x <- 0 until 9){
      for(y <- 0 until 9){
        val c = b.getCell(Position(x, y))
        c match {
          case Empty() => printf("?  ")
          case Fill(n) => printf(n.toString + "  ")
        }
      }
      println()
    }
  }

}