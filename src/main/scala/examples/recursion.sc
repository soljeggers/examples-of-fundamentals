def intMap(list: List[Int], f: Int => Int): List[Int] = {
  if (list != Nil) {
    f(list.head) :: intMap(list.tail, f)
  } else {
    list
    // List()
    // Nil
  }
}

intMap(List(1,2,3), x => x + 2)

intMap(List(1,2,3), x => x * 5)

// recursion needs a default return type


/*****************************************************/

//// make below example generic
//
//def intMap[B](list: List[Int], f: Int => Int): List[Int] = {
//  list match {
//    case Nil => list
//    case head :: tail => f(head) :: intMap(tail, f)
//  }
//
//}






