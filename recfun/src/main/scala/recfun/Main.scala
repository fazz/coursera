package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || r == 0 || c == r) {
      1
    } else {
      pascal(c-1,r-1)+pascal(c,r-1)
    }
  }
  
  /*{
    def min(i1: Int, i2: Int) = if(i1<i2) i1 else i2
    def pascal2(c: Int, r: Int): Int = {
      0
    }
    pascal2(min(c+1, (r+1)-c), r+1)
  }*/

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
  	def balance2(chars: List[Char], offset: Int): Int =  {
     if(chars.isEmpty || offset < 0) {
      offset
     } else {
      balance2(chars.tail, offset +
        (chars(0) match {
        case '(' => 1
        case ')' => -1
        case _ => 0
      }))
     }
  	}
    balance2(chars, 0) == 0
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) {
      0
    } else if (coins.isEmpty) {
      0
    } else {
      (if (money == coins(0)) {
        1
      } else if (money > coins(0)) {
        countChange(money-coins(0), coins)
      } else {
        0
      }) + 
      countChange(money, coins.tail)
    }
  }
}


