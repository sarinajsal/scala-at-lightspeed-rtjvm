package com.rockthejvm
import scala.collection.immutable

object FunctionalProgramming extends App {
  //scala is object oriented
  class Person(name: String){
    def apply(age: Int) = println(s"I have aged $age years")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) //INVOKING bob as a function === bob.apply(43)
  //the presence of an apply method allows an instance of a class to be invoked like a function

  /*
  Scala runs on jvm - jvm built for OOP how to use functional programming?
  Functional programming:
  - compose functions
  -pass functions as arguments
  -returns functions as results

  Conclusion: Function x
   */

  val simpleIncrementer = new Function1 [Int, Int] { //plain trait w apply method?
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementer.apply(23)//24
  simpleIncrementer(23)//same thing
  //defined a function! ie takes args and returns something else

  //ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTIONX TYPES
  //you make instances of the so called Function1, Function2 ... Function 22

  val stringConcatonater = new Function2[String, String, String] { // takes 2 string types and returns a string
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }

  stringConcatonater("I love", "scala") //returns "I love scala"


  //syntax sugars
  val doubler: Int => Int = (x:Int) => 2 * x
  doubler(4) //8

  /*
  above is equivalent to the much longer

  val doubler: Function[Int, Int] = new Function1 [Int, Int] {            //Int int being the input and return tyype, can be inferred by compiler
   override def apply(x: Int) = 2 * x
   }
   */




  //HIGHER ORDER FUNCTIONS: take functions as arguments and/or return functions as results
  //.map allows passing of a function
  val aMappedList: List[Int] = List(1,2,3).map(x => x + 1) //(x=>x+1) is an anonymous function passed to map
  val aFlatMappedList = List(1,2,3).flatMap (x => List(x, 2*x))
  println(aFlatMappedList)


  //alternative syntax - curly braces
  val aFlatMappedList2: List[Int] = List(1,2,3).flatMap {x =>
    List(x, 2*x)
  }

  val aFilteredList = List(1,2,3,4,5).filter(x => x <= 3) //an anonymous function (made of an expression x<=3, a boolean) returns new list of true values from original
  println(aFilteredList)

  //alternative syntax
  val anotherFilteredList = List(1,2,3,4,5).filter(_ <=3) //equivalent to x => x

  //all the pairs between the numbers 1,2,3 and the letters a,b,c
  val allPairs = List(1,2,3).flatMap(number => List('a','b,'c').map(letter => s"$number-$letter"))
  println(allPairs)
  //no looping, just using maps, flatmaps etc// calling flatmap on the original list returns a number of other small lists which are then concatanated together

  //for comprehensions
  val alternativePairs = for { //not a for loop!
    number <- List(1,2,3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"
  //equivalent to the map/flatmap chain above

  /**
   * Collections
   */

  //lists
  val aList = List(1,2,3,4,5)
  val firstElement = aList.head
  val rest = aList.tail
  val aPrependedList = 0 :: aList //creates (0,1,2,3,4,5)
  val anExtendedList = 0 +: aList :+ 6 //creates (1,2,3,4,5,6)


  //sequences
  val aSequence: Seq[Int] = Seq(1,2,3) //seq.apply(1,2,3)    seq has a companion object that has an apply method
  val accessedElement = aSequence(1) //equivalent to aSequence.apply(1), returns the value at index 1 which in this case is 2

  //vectors: fast seq implementation
  val aVector = Vector(1,2,3,4,5) //has exact same methods as lists or seqs v fast

  //sets = no duplicates
  val aSet = Set(1,2,3,4,1,2,3) //set(1,2,3,4)
  val setHas5 = aSet.contains(5) // false
  val anAddedSet = aSet(5) // remember the + is actually a method, which is available to the set type, adds the value to the set ie set(1,2,3,4,5) 5 can be anywhere order unimportant
  val aRemovedSet = aSet -3 //(1,2,4)

  //ranges
  val aRange = Range(1, 1000) //changed!! was 1to 1000 - got invalid literal number error
  val twoByTwo = aRange.map(x => 2*x).toList //List(2,4,5,6...2000), can use .toList, .toSet, .toSeq

  //tuples = groups of values under the same value
  val aTuple =("Bon Jove", "Rock", 1982)

  //maps
  val aPhonebook: Map[String, Int] = Map(
    ("Daniel", 356476353),
    ("Jane", 487932)
  )



}
