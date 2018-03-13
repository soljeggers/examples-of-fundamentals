import java.util.Date

def doingSomething(): Int = {
  println(s"Doing something...")
  return 1
}

def callByValue(x: Int) = {
  println(s"x1 $x")
  println(s"x2 $x")
}

def callByName(x: => Int) = {
  println(s"x1 $x")
  println(s"x2 $x")
}

callByValue(doingSomething())

callByName(doingSomething())

def future(body: => Int) = {
  body
  println("do something else 1")
  body
  println("do something else 2")
  body
  println("do something else 3")
  body
  println("do something else 4")
}

var age = 0

def calcAge = {
  val name = "adam"
  age = age + 1 // 1,2,3
  println(s"$name $age")
  age
}

future(calcAge)

def codeTimer[T](code : => T) = {
  val start = new Date().getTime

  code

  val end = new Date().getTime - start
  println(s"code took $end seconds to run")
  code
}


val code = codeTimer[Unit]({
  "Jeff You Fatty"
  println(codeTimer(7890 * 1789))
})