package com.rockthejvm

object Basics extends App{

  //defining a value
  val meaningOfLife: Int =42

  //Int Bool Char Double Float
  val aBoolean = false //type is optional most of the time

  //strings and string operations
  val aString = "i love scala"
  val aComposedString = "i" + "love" + "scala"
  val anInterpolatedString = s"the meaning of life is $meaningOfLife"

  //expressions are structures that can be reduced to a value
  val anExpression = 2+3

  //if-expression
  val ifExpression = if (meaningOfLife>43) 56 else 999 //like a turnery statement in java
  val chainedIfExpression = {
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0}

    //code-block - can define as much as you want but must return something at end
    val aCodeBlock = {
      //definitions
      val aLocalValue = 67

      //value of block is the last expression - compiler can figure out the type
      aLocalValue + 3
    }

    //define a function, arguments passed into () in the form name, colon, type eg x:Int
    //can be on a single line or code block -  a code block is also an expression

    def myFunction (x: Int, y: String): String = {
      y + " " + x
    }

    //recursive functions
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n-1)

  /*
    factorial(5) = 5 * factorial (4)        5*24 = 120
    factorial(4) = 4 * factorial(3)         4*6
    factorial(3) = 3 * factorial(2)         3*2
    factorial(2) = 2 * factorial (1)        2*1
    factorial(1) = 1
  */

  //in scala dont use loops or iteration, use recursion (a function can call upon itself again and again)


  //the Unit return type = no meaningful value === "null" or "void"
  //type of side effect -
  println("hi") //return value is unit - doesnt return a meaningful value

  def myUnitReturningFunction (): Unit = {
    println("this returns a unit")
  }

  val theUnit = () //what the unit returns
}
