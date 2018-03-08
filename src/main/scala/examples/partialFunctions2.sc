

val divide = (x : Int) => 42 / x
List(1,2).map(divide)
divide(2)


val dividePF = new PartialFunction[Int, Int] {

  def apply(x : Int) = 42 / x

  override def isDefinedAt(x : Int) : Boolean = x != 0

}

val x = 2
if(dividePF.isDefinedAt(x)) {
  dividePF(x)
} else {
  println("Cant handle 0")
}

/**
  * Define a partial function short hand with a  case statement
  * PartialFunction [-A, +B]
  * A = input type
  * B = output type
  *
  */

val handleZeros : PartialFunction[Int, Int] = {
  case y => y
}

// another p function

val dividePF2 : PartialFunction[Int,Int] = {
  case y if y != 0 => 42 / y
}

/**
  * Using function composition orElse to combine p functions together into a composedFunction
  *
  PartialFunction is a subtype of Function
  *
  */

val divideOrHandle = dividePF2 orElse handleZeros
// use new composed function as argument for map
List(0,1,2,3,4,5).map (divideOrHandle)

/**
  * calling .collect allows us to call in a partial function to filter out possible cases that would not match and removes them in this case 0
  *
  * if we called the List().map(divide) it would throw an Arythmetic Exception
  */

List(0,1,2,3,4,5).collect(dividePF)



val isEven : PartialFunction[Int, String] = {
  case x : Int if x % 2 == 0 => s"$x is Even"
}

val isOdd : PartialFunction[Int, String] = {
  case x : Int if x % 2 == 1 => s"$x is Odd"
}

val isEvenOrOdd = isEven orElse isOdd

val numbers = 1 to 5
val evenNumbers = numbers collect isEven

/**
  * Composing anonymous functions with andTHen, compose, orElse
  */

val double = (n:Int) => n * 2
val addOne = (n:Int) => n + 1

val doublePlusOne = double andThen addOne

val nums = (1 to 20).toList
nums.map(doublePlusOne)
