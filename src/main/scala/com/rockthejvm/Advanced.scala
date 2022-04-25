package com.rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global
object Advanced extends App{

  /**lazy evaluation - not evaluated untill first used
   */
  lazy val aLazyVal = 2
  lazy val lazyValueWithSideEffect = { //remeber code blocks have the value of the last expression
    println("i am lazy")
    43
  }
  val eagerValue = lazyValueWithSideEffect +1 //only because lazyValWithSideEffect is being used, does the above code block get evaluates
  //useful in infinite collections

  /**"psuedo collections": Option, Try - their own types
   */

  def methodWhichCanReturnNull(): String = "hello scala"
  //to prevent null point errors, wrap unsafe code in an option and then do a pattern match

  //try guards against methods that can throw exceptions
  def methodWhichCanThrowException(): String = throw new RuntimeException
//  try{
//    methodWhichCanThrowException()
//  } catch {
//    case e: Exception => "defend againsT "
//  }
  val aTry = Try(methodWhichCanThrowException()) //a try containing a string if method went well and exception if it threw

  //a try is a "collection" with a value if code went well, or an exception if the code threw one

  //can patternmatch against the two subtypes of try, success or failure (import from scala util)

  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"I have obtained a valid string: $validValue"
    case Failure(exception) => s"i have obtained an exception: $exception"
  }


  /**
   * Evaluate something on another thread
   * (asynch programming
   */

  val aFuture = Future{ //Future.apply
  println("loading...")
    Thread.sleep(1000)
    println("I have computed a value")
    67
  } // the main thread of the jvm/application finishes before the Future had a chance to evaluate, this is due to the code block being evaluated on another thread?
  Thread.sleep(2000)

  //future is a "collection" which contains a value when its evaluated.
  //future is composable with map, flatmap and filter

  /**
   * Implicits basics
   */
  //1)implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg+1
  implicit val myImplicitInt = 46
  println(aMethodWithImplicitArgs) //aMethodWithImplicitArgs(myImplicitInt)

  //2) Implicit conversions
  implicit class myRichInteger(n: Int){
    def isEven()= n % 2 ==0
  }
  println(23.isEven()) //equivalent to new mRichinteger(23).isEven()
}
