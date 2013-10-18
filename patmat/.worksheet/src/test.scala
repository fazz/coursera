import patmat._
import patmat.Huffman._

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(98); 
  println("Welcome to the Scala worksheet");$skip(58); 

	val l: List[(Int, Int)] = List[(Int, Int)]((0,0),(1,2));System.out.println("""l  : List[(Int, Int)] = """ + $show(l ));$skip(14); 


  val i = 7;System.out.println("""i  : Int = """ + $show(i ));$skip(79); val res$0 = 
  l match {
  	case l1 :: (i,2) :: l2 => l1 :: l2
  	case (1,2) :: l2 => l2
 };System.out.println("""res0: List[(Int, Int)] = """ + $show(res$0));$skip(35); val res$1 = 

 List('a','b') ::: List('c', 'd');System.out.println("""res1: List[Char] = """ + $show(res$1));$skip(31); val res$2 = 

 List('a', 'b').contains('c');System.out.println("""res2: Boolean = """ + $show(res$2));$skip(26); val res$3 = 

'a' :: Nil ::: List('c');System.out.println("""res3: List[Char] = """ + $show(res$3));$skip(73); 

	val chars = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbc".toList;System.out.println("""chars  : List[Char] = """ + $show(chars ));$skip(45); 

	  val tree = Huffman.createCodeTree(chars);System.out.println("""tree  : patmat.Huffman.CodeTree = """ + $show(tree ));$skip(44); val res$4 = 
	

	  
	  makeOrderedLeafList(times(chars));System.out.println("""res4: List[patmat.Huffman.Leaf] = """ + $show(res$4));$skip(169); val res$5 = 
                                                  
                                                  

   combine(combine(List(Leaf('c',1), Leaf('b',2), Leaf('a',46))));System.out.println("""res5: List[patmat.Huffman.CodeTree] = """ + $show(res$5));$skip(75); val res$6 = 
   combine(combine(combine(List(Leaf('c',1), Leaf('b',2), Leaf('a',46)))));System.out.println("""res6: List[patmat.Huffman.CodeTree] = """ + $show(res$6));$skip(38); 
def f(a: Int)(b: Int): Int = {
	a+b
};System.out.println("""f: (a: Int)(b: Int)Int""");$skip(19); 

  val g = f(1)(_);System.out.println("""g  : Int => Int = """ + $show(g ));$skip(8); val res$7 = 

  g(2);System.out.println("""res7: Int = """ + $show(res$7))}
}
