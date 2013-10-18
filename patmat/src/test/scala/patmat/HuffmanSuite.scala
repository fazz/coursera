package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  }

  test("times") {
    new TestTrees {
      {
      val list = Huffman.string2Chars("aa")
      val c = Huffman.times(list)
      assert(c == List(('a', 2)))
      }
      {
      val list = Huffman.string2Chars("babacZ")
      val c = Huffman.times(list)
      assert(c == ('c', 1) :: ('b', 2) :: ('a', 2) :: ('Z', 1) :: Nil)
      }
    }
  }
  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  test("decode") {
    val tree = Fork(Leaf('a',1), Leaf('b', 2), 'a' :: 'b' :: Nil, 3)
    val r = decode(tree, 0 :: 0 :: 1 :: Nil)
    println (r)
  }

  test("decode secret") {
    new TestTrees {
      println(Huffman.decodedSecret)
    }
  }
  test("decode and encode a very short text should be identity") {
    new TestTrees {
      println(encode(t1)("ab".toList))
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }
}
