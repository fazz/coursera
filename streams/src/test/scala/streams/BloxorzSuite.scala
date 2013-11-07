package streams

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import Bloxorz._

@RunWith(classOf[JUnitRunner])
class BloxorzSuite extends FunSuite {

  trait SolutionChecker extends GameDef with Solver with StringParserTerrain {
    /**
     * This method applies a list of moves `ls` to the block at position
     * `startPos`. This can be used to verify if a certain list of moves
     * is a valid solution, i.e. leads to the goal.
     */
    def solve(ls: List[Move]): Block =
      ls.foldLeft(startBlock) { case (block, move) => move match {
        case Left => block.left
        case Right => block.right
        case Up => block.up
        case Down => block.down
      }
    }
  }

  trait Level1 extends SolutionChecker {
      /* terrain for level 1*/

    val level =
    """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin

    val optsolution = List(Right, Right, Down, Right, Right, Right, Down)
  }

  trait Level2 extends SolutionChecker {
      /* terrain for level 1*/

    val level =
    """ooo-------
      |oS--------
      |ooo-------
      |-ooooooooo
      |--T--ooooo
      |------ooo-""".stripMargin

    val optsolution = List(Right, Right, Down, Right, Right, Right, Down)
  }

  
  test("terrain function level 1") {
    new Level1 {
      assert(terrain(Pos(0,0)), "0,0")
      assert(!terrain(Pos(4,11)), "4,11")
    }
  }

  test("findChar level 1") {
    new Level1 {
      assert(startPos == Pos(1,1))
    }
  }

  test("Neighbours") {
    new Level1 {
      neighborsWithHistory(startBlock, List())
      neighborsWithHistory(startBlock, List()).take(4).toList

      val z = neighborsWithHistory(startBlock, List())
      assert(newNeighborsOnly(z, Set(startBlock)).take(4).toList === List((Block(Pos(1,2),Pos(1,3)),List(Right)), (Block(Pos(2,1),Pos(3,1)),List(Down))))

      from(List((startBlock, List())).toStream, Set(startBlock))
    }
  }

  test("optimal solution for level 2") {
    new Level2 {
      assert(neighborsWithHistory(startBlock, List()).take(4).toList === List((startBlock.down, List(Down))))

      assert(solution === List(Down, Right, Down))
    }
  }


  test("optimal solution for level 1") {
    new Level1 {
      println(solution)
      assert(solve(solution) == Block(goal, goal))
    }
  }


  test("optimal solution length for level 1") {
    new Level1 {
      assert(solution.length == optsolution.length)
    }
  }
}
