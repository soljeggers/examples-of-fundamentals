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

