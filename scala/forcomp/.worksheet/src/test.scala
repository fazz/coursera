import forcomp.Anagrams._
import forcomp._

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(101); 
  println("Welcome to the Scala worksheet");$skip(45); 


  val s: Sentence = List("Linux", "rulez");System.out.println("""s  : forcomp.Anagrams.Sentence = """ + $show(s ));$skip(59); 


  val d = computeDbyO(List("xx", "tere", "ema", "reet"));System.out.println("""d  : forcomp.Anagrams.Omap = """ + $show(d ));$skip(32); 
  
  val s2 = List("tereemaxx");System.out.println("""s2  : List[String] = """ + $show(s2 ));$skip(34); 
  val o = sentenceOccurrences(s2);System.out.println("""o  : forcomp.Anagrams.Occurrences = """ + $show(o ));$skip(85); val res$0 = 
  for (r <- computeSA(o, combinations(o), d) if sentenceOccurrences(r) == o) yield r;System.out.println("""res0: List[forcomp.Anagrams.Sentence] = """ + $show(res$0));$skip(91); val res$1 = 
                                                  
  sentenceAnagrams(List()) == List(Nil);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(25); val res$2 = 
  
  sentenceAnagrams(s);System.out.println("""res2: List[forcomp.Anagrams.Sentence] = """ + $show(res$2))}

}
