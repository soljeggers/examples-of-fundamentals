//def find(list : List[Int], fn : Int => Boolean) : Option[Int] = {
//
//  list match {
//    case head :: _ if fn(head) => Some(head)
//    case Nil => None
//    case _ :: tail => find(tail, fn)
//  }
//
//}
//
//find(List(1,2,3), _ == 1)
//find(List(1,2,3), _ == 4)
//find(Nil, _ == 2)


// this example above is of an option that using recursion and pattern matching.
// def find takes in a list and a function - the function takes in an INT and returns a Boolean.

// the underscore in the case above _ acts as the anonymous function without hving to explicity typing it

/************************************************************************************/

def find [A](list : List[A], fn : A => Boolean) : Option[A] = {
  list match {
    case head :: _ if fn(head) => Some(head)
    case Nil => None
    case _ :: tail => find(tail, fn)
  }
}

find[Int](List(1,2,3), _ == 4)
find[Int](List(1,2,3), _ == 3)

find[String](List("Adam", "Chris"), _ == "Chris")

find[(Int, String)](List((1, "Adam"), (2, "Chris")), _._2 == "Chris")

find[Any](List(1,2,"Chris"), _ == 2)

// above shows us using generic to define a class type it asking for a type of [A]
// [A] is a placeholder we are saying that we don't want to tell you what type it is However we may want to later.

// so when we ask for the output as above we ask for find[Int] find[String] find[Int, String] the type after find is the type we are replacing A with.

