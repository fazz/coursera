import streams._

object test  {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(76); 
  println("Welcome to the Scala worksheet");$skip(110); 


  def f(s: Stream[Int]): Stream[Int] = {
    val tmp = for {
      n <- s
    } yield n*10
    s ++ tmp
  };System.out.println("""f: (s: Stream[Int])Stream[Int]""");$skip(27); val res$0 = 
  f(List(1,2).toStream)(4);System.out.println("""res0: Int = """ + $show(res$0))}

}
