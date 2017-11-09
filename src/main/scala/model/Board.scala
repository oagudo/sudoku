package model

sealed trait Position
case class Empty() extends Position
case class Fill(n : Short) extends Position {
  require(n >= 1 && n <= 9)
}

class Board() {
  val positions = Array.ofDim[Empty](9, 9)

}