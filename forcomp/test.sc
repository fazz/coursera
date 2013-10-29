import forcomp.Anagrams._
import forcomp._

object test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet


  val s: Sentence = List("Linux", "rulez")        //> s  : forcomp.Anagrams.Sentence = List(Linux, rulez)


  val d = computeDbyO(List("xx", "tere", "ema", "reet"))
                                                  //> d  : forcomp.Anagrams.Omap = Map(List((x,2)) -> List(xx), List((a,1), (e,1),
                                                  //|  (m,1)) -> List(ema), List((e,2), (r,1), (t,1)) -> List(reet, tere))
  
  val s2 = List("tereemaxx")                      //> s2  : List[String] = List(tereemaxx)
  val o = sentenceOccurrences(s2)                 //> o  : forcomp.Anagrams.Occurrences = List((a,1), (e,3), (m,1), (r,1), (t,1), 
                                                  //| (x,2))
  for (r <- computeSA(o, combinations(o), d) if sentenceOccurrences(r) == o) yield r
                                                  //> res0: List[forcomp.Anagrams.Sentence] = List(List(ema, reet, xx), List(ema, 
                                                  //| tere, xx), List(ema, xx, reet), List(ema, xx, tere), List(reet, ema, xx), Li
                                                  //| st(reet, xx, ema), List(tere, ema, xx), List(tere, xx, ema), List(xx, ema, r
                                                  //| eet), List(xx, ema, tere), List(xx, reet, ema), List(xx, tere, ema))
                                                  
  sentenceAnagrams(List()) == List(Nil)           //> res1: Boolean = true
  
  sentenceAnagrams(s)                             //> res2: List[forcomp.Anagrams.Sentence] = List(List(rulez, Linux), List(Rex, n
                                                  //| il, Zulu), List(Rex, Lin, Zulu), List(Rex, Uzi, null), List(Rex, Zulu, nil),
                                                  //|  List(Rex, Zulu, Lin), List(Rex, null, Uzi), List(Linux, rulez), List(nil, R
                                                  //| ex, Zulu), List(nil, Zulu, Rex), List(Lin, Rex, Zulu), List(Lin, Zulu, Rex),
                                                  //|  List(Uzi, Rex, null), List(Uzi, null, Rex), List(Zulu, Rex, nil), List(Zulu
                                                  //| , Rex, Lin), List(Zulu, nil, Rex), List(Zulu, Lin, Rex), List(null, Rex, Uzi
                                                  //| ), List(null, Uzi, Rex))

}