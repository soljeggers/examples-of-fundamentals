import scala.annotation.tailrec

def sum (nums : List[Int]) : Int = {
  nums match {
    case Nil => 0
    case h :: tail => h + sum(tail)
  }
}

val oneto200 = List.range(0,20)
sum(oneto200)



/** EXAMPLE ABOVE IS RECURSIVE  - this will take each number from the accumalator store it in a stack until it reaches the end of the list which is NIL it will then run back down the stack and calculate the sum... problem with this is that it can only hold so much of the stack in memory before throwing stackoverflow Error **/

def sumTailRecursive (nums : List[Int]) : Int = {

  @tailrec
  def sumHelper(tail: List[Int], accum: Int): Int = {


    tail match {
      case Nil => accum
      case h :: tail => sumHelper(tail, accum + h)
    }
  }
  sumHelper(nums, 0)
}

/** EXAMPLE ABOVE IS TAIL RECURSIVE **/





/** BELOW IS AN EXAMPLE OF TAIL RECURSION TAKING A LIST OF PEOPLE AND RETURNING A NEW LIST OF PEOPLE THAT MEET A CERTAIN CONDITION

  * If head name is equal to  "michael" Filter through the list of people (tail) and add Michael to new list (accumulator).

  **/


//case class Person(name: String)
//
//def filterNameMichael (People : List[Person] ) : List[Person] = {
//
//  @tailrec
//  def filterListPeople (listToCheck: List[Person], acc : List[Person] ) : List[Person] = {
//    listToCheck match {
//      case Nil => acc
//      case head :: tail =>
//        if (head.name == "Michael") {
//          filterListPeople(tail, head :: acc)
//        } else {
//          filterListPeople(tail, acc)
//        }
//    }
//  }
//  filterListPeople(People, Nil)
//}
//
//val people = List(Person("Michael"),Person("Doug"),Person("Connor"),Person("Michael"),Person("Michael"),Person("Pan"))
//
//filterNameMichael(people)


/** BELOW IS THE SAME EXAMPLE AS ABOVE WHICH IS AN EXAMPLE OF TAIL RECURSION TAKING A LIST OF PEOPLE AND RETURNING A NEW LIST OF PEOPLE THAT MEET A CERTAIN CONDITION ----- MODIFIED TO TAKE IN A HIGHER ORDER FUNCTION WHICH ALLOWS US TO INPUT ANY NAME WE WANT ------
  *
  *
  * Below we have added higher order function into the filter name func then called filter name at the end x is the value or person so person => person.name is equal too "Michael" or whatever name we put in


  **/

case class Person(name: String)

def filterName (People : List[Person], f: Person => Boolean ) : List[Person] = {

  @tailrec
  def filterListPeople (listToCheck: List[Person], acc : List[Person] ) : List[Person] = {
    listToCheck match {
      case Nil => acc
      case head :: tail =>
        if (f(head)) {
          filterListPeople(tail, head :: acc)
        } else {
          filterListPeople(tail, acc)
        }
    }
  }
  filterListPeople(People, Nil)
}

val people = List(Person("Michael"),Person("Doug"),Person("Connor"),Person("Michael"),Person("Michael"),Person("Pan"))


filterName(people, x => x.name == "Michael")