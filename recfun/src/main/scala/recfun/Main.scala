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
  def pascal(c: Int, r: Int): Int = ???

  /**
   * Exercise 2
   */
  def balance2(chars: List[Char], offset: Int): Int = 
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
    
  def balance(chars: List[Char]): Boolean = 
    balance2(chars, 0) == 0

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???
}
