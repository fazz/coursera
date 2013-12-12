import streams._

object test  {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet


  def f(s: Stream[Int]): Stream[Int] = {
    val tmp = for {
      n <- s
    } yield n*10
    s ++ tmp
  }                                               //> f: (s: Stream[Int])Stream[Int]
  f(List(1,2).toStream)(4)                        //> java.lang.IndexOutOfBoundsException: 4
                                                  //| 	at scala.collection.LinearSeqOptimized$class.apply(LinearSeqOptimized.sc
                                                  //| ala:52)
                                                  //| 	at scala.collection.immutable.Stream.apply(Stream.scala:185)
                                                  //| 	at test$$anonfun$main$1.apply$mcV$sp(test.scala:13)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at test$.main(test.scala:3)
                                                  //| 	at test.main(test.scala)

}