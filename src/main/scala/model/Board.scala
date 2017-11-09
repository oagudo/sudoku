package model

case class Position(x : Int, y : Int)

sealed trait Cell
case class Empty() extends Cell
case class Fill(n : Short) extends Cell {
  require(n >= 1 && n <= 9)
}

class Board() {
  private val cells = Array.ofDim[Cell](9, 9)

  val positions = for {
    x <- 0 until 9
    y <- 0 until 9
  } yield Position(x, y)

  positions.foreach(setCell(Empty(), _))

  def setCell(c : Cell, p : Position): Unit = {
    cells(p.x)(p.y) = c
  }

  def getCell(p : Position): Cell = {
    return cells(p.x)(p.y)
  }


}