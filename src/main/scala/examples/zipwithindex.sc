val x = List(2,4,7,9,10)

val y = x.zipWithIndex.tail

val z = y.filter(x => x._1 % x._2 == 0)

z.map(x => x._1)
