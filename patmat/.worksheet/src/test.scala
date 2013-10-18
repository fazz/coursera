object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(57); 
  println("Welcome to the Scala worksheet");$skip(58); 

	val l: List[(Int, Int)] = List[(Int, Int)]((0,0),(1,2));System.out.println("""l  : List[(Int, Int)] = """ + $show(l ));$skip(14); 


  val i = 7;System.out.println("""i  : Int = """ + $show(i ));$skip(79); val res$0 = 
  l match {
  	case l1 :: (i,2) :: l2 => l1 :: l2
  	case (1,2) :: l2 => l2
 };System.out.println("""res0: List[(Int, Int)] = """ + $show(res$0));$skip(35); val res$1 = 

 List('a','b') ::: List('c', 'd');System.out.println("""res1: List[Char] = """ + $show(res$1));$skip(31); val res$2 = 

 List('a', 'b').contains('c');System.out.println("""res2: Boolean = """ + $show(res$2));$skip(26); val res$3 = 

'a' :: Nil ::: List('c');System.out.println("""res3: List[Char] = """ + $show(res$3))}
}
