package rule

import inout.SudokuReader
import org.scalatest.prop.Checkers
import org.scalatest.{FunSpec, Matchers}
import solver.SudokuBruteForceSolver

class SudokuBruteForceSolverTest extends FunSpec with Checkers with Matchers {
  describe("A Sudoku solver") {

    it("solves a one single solution sudoku correctly") {

      val sudoku =  """5  9  3     2  ?  6     ?  ?  ?
                      |?  ?  ?     5  9  ?     ?  ?  6
                      |2  ?  ?     ?  4  ?     5  9  3
                      |
                      |6  ?  ?     1  8  ?     ?  5  ?
                      |?  5  ?     ?  ?  4     ?  ?  ?
                      |1  ?  ?     ?  5  7     6  ?  4
                      |
                      |?  3  ?     4  6  8     ?  ?  5
                      |9  ?  5     7  3  ?     4  ?  ?
                      |4  6  8     ?  ?  5     7  ?  2""".stripMargin

      val b = SudokuReader.read(sudoku)
      SudokuBruteForceSolver.solve(b)

      val solution = """5  9  3     2  7  6     8  4  1
                       |8  4  1     5  9  3     2  7  6
                       |2  7  6     8  4  1     5  9  3
                       |
                       |6  2  4     1  8  9     3  5  7
                       |3  5  7     6  2  4     1  8  9
                       |1  8  9     3  5  7     6  2  4
                       |
                       |7  3  2     4  6  8     9  1  5
                       |9  1  5     7  3  2     4  6  8
                       |4  6  8     9  1  5     7  3  2""".stripMargin

      val sudokuSolution = SudokuReader.read(solution)

      assert(b == sudokuSolution)
    }


    it("solves another one single solution sudoku correctly") {

      val sudoku =  """?  ?  9     7  6  1     ?  ?  ?
                      |4  2  8     ?  ?  9     6  ?  7
                      |?  6  1     ?  ?  8     3  ?  ?
                      |
                      |?  7  3     1  ?  6     5  ?  ?
                      |8  ?  ?     9  ?  ?     4  6  1
                      |?  ?  ?     ?  5  2     7  ?  9
                      |
                      |?  ?  7     6  8  ?     9  5  ?
                      |2  ?  5     3  1  7     ?  ?  6
                      |?  ?  ?     ?  ?  ?     ?  ?  3""".stripMargin

      val b = SudokuReader.read(sudoku)

      SudokuBruteForceSolver.solve(b)

      val solution = """5  3  9     7  6  1     2  8  4
                       |4  2  8     5  3  9     6  1  7
                       |7  6  1     4  2  8     3  9  5
                       |
                       |9  7  3     1  4  6     5  2  8
                       |8  5  2     9  7  3     4  6  1
                       |1  4  6     8  5  2     7  3  9
                       |
                       |3  1  7     6  8  4     9  5  2
                       |2  9  5     3  1  7     8  4  6
                       |6  8  4     2  9  5     1  7  3""".stripMargin


      val sudokuSolution = SudokuReader.read(solution)

      assert(b == sudokuSolution)
    }

  }
}
