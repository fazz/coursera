object test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

	val l: List[(Int, Int)] = List[(Int, Int)]((0,0),(1,2))
                                                  //> l  : List[(Int, Int)] = List((0,0), (1,2))


  val i = 7                                       //> i  : Int = 7
  l match {
  	case l1 :: (i,2) :: l2 => l1 :: l2
  	case (1,2) :: l2 => l2
 }                                                //> res0: List[(Int, Int)] = List((0,0))

 List('a','b') ::: List('c', 'd')                 //> res1: List[Char] = List(a, b, c, d)

 List('a', 'b').contains('c')                     //> res2: Boolean = false

'a' :: Nil ::: List('c')                          //> res3: List[Char] = List(a, c)
}