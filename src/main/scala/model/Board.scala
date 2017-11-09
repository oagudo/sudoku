package model

sealed trait Position
case class Empty() extends Position
case class Fill(n : Short) extends Position

class Board() {
  val positions = Array.ofDim[Empty](9, 9)

}