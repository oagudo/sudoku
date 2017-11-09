package model

case class Position(x : Int, y : Int) {
  def +(other : Position) = Position(x + other.x, y + other.y)
}

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

  def getRow(r : Int) : List[Cell] = {
    (0 until 9).map(c => getCell(Position(r, c))).toList
  }

  def getCol(c : Int) : List[Cell] = {
    (0 until 9).map(r => getCell(Position(r, c))).toList
  }

  def getSquares() : List[List[Cell]] = {

    val startOfSmallSquarePositions = for {
      r <- (0 until 3)
      c <- (0 until 3)
    } yield Position(r * 3, c * 3)

    val squarePos = for {
      r <- (0 until 3)
      c <- (0 until 3)
    } yield Position(r, c)

    startOfSmallSquarePositions.toList.map(start => squarePos.map(p => getCell(start + p)).toList)
  }

}