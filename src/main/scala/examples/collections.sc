val numbers = Range(1,11).toList

// filter - keeps items that satisfy a boolean expression
val evenNumbers: List[Int] = numbers.filter(x => x % 2 == 0)
// Result: List(2, 4, 6, 8, 10)
// How could you change this to filter for odd numbers?
// How could you change this to filter for multiples of 3?
// How could you change this to filter for numbers greater than 5?

// map - creates a new collection by applying a function to each element
val doubleNumbers: List[Int] = numbers.map(x => x * 2)
// Result: List (2, 4, 6, 8, 10, 12, 14, 16, 18, 20)
// How could you change this to add one to each number?

// Operators may be chained in a sequence
val doubleEvenNumbers: List[Int] = numbers.filter(x => x % 2 == 0).map(x => x * 2)
// Result: List(4, 8, 12, 16, 20)
// How could you chain functions to double numbers then only keep multiples of 8?

// forEach - evaluates an expression for each element but does not return a value
val printNumbers: Unit = numbers.foreach(x => println(x))
// Result: (prints numbers 1 to 10 with newlines between each)

// mkString - creates a string by calling toString on each element, separated by the string provided
val commaSeparated = numbers.mkString(",").indexWhere
// Result: 1,2,3,4,5,6,7,8,9,10