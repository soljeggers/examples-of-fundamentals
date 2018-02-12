val numbers = List(1,2,3,4,5)

def sumAndMultiply (list: List[Int], f: Int => Int) =
  numbers.map(n => f(n)).sum

val timesTwo = (n:Int) => n * 2
val timesThree = (n:Int) => n * 3
val timesForty = (n:Int) => n * 40

val timesTwoThenTimesThree = timesTwo andThen timesThree

sumAndMultiply(numbers, timesTwo)
sumAndMultiply(numbers, timesThree)
sumAndMultiply(numbers, timesTwoThenTimesThree)
sumAndMultiply(numbers, timesForty)


/** Higher Order function examples - functions which take in a function as  parameteres whos result is a function  **/

  
val values = List(2,4,6,8,10)

def totalValue(list:List[Int], f: Int => Int) =
  values.map(n => f(n))

val multiplyByFive = (n:Int) => n * 5

totalValue(values, timesForty)
totalValue(values, timesThree)
totalValue(numbers, timesForty)
