import patmat._
import patmat.Huffman._

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

	val chars = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbc".toList
                                                  //> chars  : List[Char] = List(a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a
                                                  //| , a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a,
                                                  //|  a, a, a, a, b, b, c)

	  val tree = Huffman.createCodeTree(chars)//> tree  : patmat.Huffman.CodeTree = Fork(Fork(Leaf(c,1),Leaf(b,2),List(c, b),3
                                                  //| ),Leaf(a,46),List(c, b, a),49)
	

	  
	  makeOrderedLeafList(times(chars))       //> res4: List[patmat.Huffman.Leaf] = List(Leaf(c,1), Leaf(b,2), Leaf(a,46))
                                                  
                                                  

   combine(combine(List(Leaf('c',1), Leaf('b',2), Leaf('a',46))))
                                                  //> res5: List[patmat.Huffman.CodeTree] = List(Fork(Fork(Leaf(c,1),Leaf(b,2),Lis
                                                  //| t(c, b),3),Leaf(a,46),List(c, b, a),49))
   combine(combine(combine(List(Leaf('c',1), Leaf('b',2), Leaf('a',46)))))
                                                  //> res6: List[patmat.Huffman.CodeTree] = List(Fork(Fork(Leaf(c,1),Leaf(b,2),Lis
                                                  //| t(c, b),3),Leaf(a,46),List(c, b, a),49))
def f(a: Int)(b: Int): Int = {
	a+b
}                                                 //> f: (a: Int)(b: Int)Int

  val g = f(1)(_)                                 //> g  : Int => Int = <function1>

  g(2)                                            //> res7: Int = 3
}