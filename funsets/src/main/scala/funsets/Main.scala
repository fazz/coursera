package funsets

object Main extends App {
  import FunSets._
      val S = union(singletonSet(1), singletonSet(2))
      
      val s = (x: Int) => {x==1||x==2||x==1000}
      val f = filter(s, (x => x < 5))
      printSet(f)
//      assert(contains(f, 2), "F 2")
//      assert(!contains(f, 1), "F 1")

}
