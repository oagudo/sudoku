package inout

import model.{Cell, Empty, Fill, Position}
import org.scalatest.prop.Checkers
import org.scalatest.{FunSpec, Matchers}

class SudokuReaderTest extends FunSpec with Checkers with Matchers {
  describe("A SudokuReader") {

    it("should correctly parse a string into a Sudoku board") {

      val input = """5  ?  ?     ?  ?  ?     ?  ?  ?
                    |?  ?  ?     ?  ?  ?     ?  ?  ?
                    |?  ?  ?     ?  ?  ?     ?  ?  ?
                    |
                    |?  ?  ?     ?  ?  ?     ?  ?  ?
                    |?  ?  ?     ?  ?  ?     ?  9  ?
                    |1  ?  ?     ?  ?  ?     ?  ?  ?
                    |
                    |?  ?  ?     ?  ?  ?     ?  ?  ?
                    |?  ?  ?     ?  ?  ?     ?  ?  ?
                    |2  ?  ?     ?  ?  ?     ?  ?  7""".stripMargin

      val b = SudokuReader.read(input)

      val filledCells: List[(Position, Cell)] = List(
        (Position(0, 0), Fill(5)),
        (Position(5, 0), Fill(1)),
        (Position(4, 7), Fill(9)),
        (Position(8, 0), Fill(2)),
        (Position(8, 8), Fill(7)))

      val emptyCellPositions = for {
        r <- (0 until 9)
        c <- (0 until 9)
        if filledCells.forall(Position(r, c) != _._1)
      } yield Position(r, c)


      for (filledCell <- filledCells) {
        assert(b.getCell(filledCell._1) == filledCell._2)
      }

      for (emptyCell <- emptyCellPositions) {
        assert(b.getCell(emptyCell) == Empty())
      }

    }
  }

}
