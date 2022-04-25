package com.rockthejvm

object PatternMatching extends App{

  //switch expression
  val anInteger = 55
  val order = anInteger match { //keyword match
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  }
  println(order)

  //Pattern match is an expression so it can be reduced to a value

  case class Person(name: String, age:Int) //remember case classes dont need to be instanciated with new keyword BECAUSE the person case class has a companion object with an apply method
  val bob = Person("bob", 43) //Person.apply

  val personGreeting = bob match {
    case Person(n,a) => s"hi my name is $n and I am $a years old" //if bob conforms to the structure  Person(n, a), then these can be used in the switch statement
    case _ => "something else"
  }
  println(personGreeting)

  //nb beneefits of case classes - deconstructing them using pattern matching (v hard to do with normal classes)



  //deconstructing tuples
  val aTuple = ("bon jovi", "rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to genre $genre"
    case _ => "what"
  }

  //decomposing lists
  val aList = List(1,2,3)
  val listDescription = aList match{
    case List(_, 2, _) => "list containing 2 at second position" //meaning the list must have 3 elements, any at positions 0 and 2, a 2 must be in position 1
    case _ => "unknown list" //always add underscore case otherwise it will throw a matchError
  }

  //pm will try all cases in sequence ie if case _ is first then "unknown list" will be returned rather than the case list


}
