package inout

import model._

object SudokuReader {

  private def toShort(s: String): Option[Short] = {
    try {
      Some(s.toShort)
    } catch {
      case e: Exception => None
    }
  }

  def read(input : String) : Board = {

    var lines = input.split("\n")
    lines = lines.filterNot(_.replaceAll("\\s", "") == "") // Remove empty lines
    require(lines.length == 9)

    val b = new Board()

    for (r <- (0 until 9)) {
      val line = lines(r)
      val cells = line.split("\\s+")

      require(cells.length == 9)

      for (c <- (0 until 9)) {

        val currentCell = cells(c)
        val cell : Cell = toShort(currentCell) match {
          case Some(v) if (1 to 9).contains(v) => Fill(v)
          case _ => Empty()
        }

        b.setCell(cell, Position(r, c))
      }
    }
    b
  }
}
