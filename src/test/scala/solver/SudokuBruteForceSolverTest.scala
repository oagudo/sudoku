package rule

import inout.SudokuReader
import org.scalatest.prop.Checkers
import org.scalatest.{FunSpec, Matchers}
import solver.SudokuBruteForceSolver

class SudokuBruteForceSolverTest extends FunSpec with Checkers with Matchers {
  describe("A Sudoku solver") {

    it("solves an easy sudoku correctly") {

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


    it("solves another easy sudoku correctly") {

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

    it("solves a difficult sudoku") {

      val sudoku =  """?  ?  ?     ?  ?  ?     4  ?  ?
                      |5  9  ?     ?  ?  ?     ?  ?  3
                      |?  ?  1     9  ?  ?     ?  7  ?
                      |
                      |?  2  ?     ?  3  ?     ?  ?  ?
                      |?  7  9     ?  ?  8     ?  ?  ?
                      |?  ?  ?     ?  ?  4     ?  8  2
                      |
                      |?  8  ?     ?  ?  6     ?  ?  ?
                      |3  ?  5     ?  ?  ?     ?  ?  ?
                      |?  1  2     ?  5  3     ?  ?  8""".stripMargin

      val b = SudokuReader.read(sudoku)

      SudokuBruteForceSolver.solve(b)

      val solution = """7  6  8     3  1  2     4  5  9
                       |5  9  4     6  8  7     1  2  3
                       |2  3  1     9  4  5     8  7  6
                       |
                       |8  2  6     5  3  1     9  4  7
                       |4  7  9     2  6  8     3  1  5
                       |1  5  3     7  9  4     6  8  2
                       |
                       |9  8  7     1  2  6     5  3  4
                       |3  4  5     8  7  9     2  6  1
                       |6  1  2     4  5  3     7  9  8""".stripMargin


      val sudokuSolution = SudokuReader.read(solution)

      assert(b == sudokuSolution)
    }

    it("solves another difficult sudoku") {

      val sudoku = """?  ?  ?     ?  9  ?     ?  ?  ?
                     |3  ?  ?     ?  ?  ?     8  6  ?
                     |?  ?  6     5  ?  4     ?  ?  ?
                     |
                     |?  9  ?     ?  ?  ?     ?  ?  ?
                     |?  7  1     ?  5  9     ?  4  ?
                     |?  ?  4     ?  6  ?     ?  ?  5
                     |
                     |4  5  ?     ?  1  ?     ?  7  ?
                     |?  ?  7     ?  ?  ?     2  3  1
                     |?  ?  ?     ?  ?  ?     ?  ?  ?""".stripMargin

      val b = SudokuReader.read(sudoku)

      SudokuBruteForceSolver.solve(b)

      val solution = """7  1  2     6  9  8     4  5  3
                       |3  4  5     2  7  1     8  6  9
                       |9  8  6     5  3  4     1  2  7
                       |
                       |5  9  8     4  2  3     7  1  6
                       |6  7  1     8  5  9     3  4  2
                       |2  3  4     1  6  7     9  8  5
                       |
                       |4  5  9     3  1  2     6  7  8
                       |8  6  7     9  4  5     2  3  1
                       |1  2  3     7  8  6     5  9  4""".stripMargin


      val sudokuSolution = SudokuReader.read(solution)

      assert(b == sudokuSolution)
    }

  }
}
