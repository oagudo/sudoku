package model

import org.scalatest.FunSpec
import org.scalatest.prop.Checkers

class BoardTest extends FunSpec with Checkers {
  describe("A Board") {

    it("should have positions") {
      val s = new Board()
      s.positions
    }
  }

  describe("A Position") {
    it("can be empty") {
      val p = Empty()
    }
  }
}
