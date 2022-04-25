package com.rockthejvm
//methods on objects are similar to java static methods, extends app is like java public static void main(String[] args)
//this executes the object body, ie you need "extends app"
object ObjectOrientation extends App{

  //class and creating an instance of the class
  class Animal{
    //define some fields/ members?
    val age: Int = 0
    //defining some methods
    def eat() = println("im eating")
  }
  val anAnimal = new Animal

  //inheritance //class dog will also have an age and eat method
  class Dog (val name: String) extends Animal //constructor definition(passing an argument to a class

  val aDog = new Dog ("Lassie")

  //constructor arguments are not fields ie cant do aDog.name: need to put a val before the constructor argument
  //promotes the constructor argument to a field - saves the constructor argument as a member of the class
  aDog.name

  //subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() //at compile time the compiler only knows that you're calling the eat method from an animal object
  //at runtime the method will be called from the most derived method i.e. the dog eat method rather than animal superclass

  //abstract class - ie not all fields/methods need implementations
  abstract class WalkingAnimal {
    val hasLegs = true //all fields and methods are public by default, can restrict by adding protected.private
    def walk(): Unit//no implementation, whichever class ends up extending WalkingAnimal will need to overide/provide implementation
  }

  //interface = ultimate abstract type
  trait Carnivore{
    def eat(animal: Animal): Unit
  }

  trait Philosopher{
    def?!(thought: String): Unit //?! is a valid method name
  }

  //single class inheritance, multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I am eating u animal") //when implementing a method also present in a super type, called an override
    override def ?! (thought: String): Unit = println(s"I was thinking: $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog //infix notation = object method argument, only available for methods with one argument
  //the philosopher trait also has only 1 method - can use the infix notation
  aCroc ?! "What if we could fly?"

  //operators in scala are actually methods
  val basicMath = 1+2 //+ is an int method

  //anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("Im a dinosaur eat anything")
  }

  /* what you tell the compiler:
  create a new class carnivore anon which extends carnivore
  class Carnivore_Anonymous_35768 extends Carnivore {
      override def eat(animal: Animal): Unit = println("Im a dinosaur eat anything")
    }
    now compiler please instanciate the carnivore anon class for me

    val dinosaur = new Carnivore_Anonymous_35768
   */

  //singleton objects
  object MySingleton { // the only instance of the MySingleton type
    val mySpecialValue = 54321
    def mySpecialMethod(): Int = 54321
    def apply(x: Int): Int = x+1 //special method that can take any arguments
  }
  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) // equivalent to MySingleton.apply(65)
  //the presence of an apply method in a class allows instances of that class to be invoked like functions

  object Animal { //class animal and object animal are companions (this is a companion object - same name as existing class or trait)
    //companions can access each others private fields/methods
    //NB the animal singleton object and instances of the animal class are different things
    //singlton Animal and instances of Animal are different
    val canLiveIndefinitely = false

  }
  val animalsCanLiveForever = Animal.canLiveIndefinitely //"static" fields or methods

  /*
  case classes = lightweight data structures with some boilerplate
  -sensible equals and hashcode
  - serialization?
  - companion with apply
  - pattern matching
   */

  case class Person(name: String, age: Int)

  //may be constructed without the keyword new
  val bob = Person("Bob", 54) //equivalent to Person.apply("Bob", 54) - person companion object is automatically created by compiler when making a case class

  //exceptions
  try {
    //code that can throw
  val x: String = null
  x.length
  }catch{
   case e: Exception => "some faulty message"
} finally {
    //execute a piece of code no matter what - useful for closing connections or files
  }

  //generics - take a type as a parameter within square brackets (convention is to use T
  abstract class MyList[T] { //passing in a type argument in square brackets
    def head: T
    def tail: MyList [T] //T can be used as value or method definitions
  }

  //using a generic with a concrete type
  val aList: List[Int] = List (1,2,3)//passing in a concrete type //list companion object applied to (1,2,3) ie List.apply(1,2,3)
  //above list applicable to type int
  val first = aList.head
  //the head method as defined above returns an element of type T
  val aStringList = List("hello", "scala") //generics are used to reuse the same functionality and apply it to multiple types
  val firstString = aStringList.head //calling the same head method initially used in val first to val firstString


  //scala usually operates with IMMUTABLE values
  val reversedList = aList.reverse //returns a NEW LIST - any modification of an object ie reversing a list should return a new object
  //you dont change values inside a given object you always return another object
  /*
  benefits1)
  a) multithreaded/distributed environments
  b) helps making sense of the code ("reasoning about")

  1) nothing in scala is outside a class or an object

   */

}
