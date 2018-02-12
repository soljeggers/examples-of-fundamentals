val num : Int = 2

def timesFive (int : Int) = int * 5

num match {
  case 1 => {
    timesFive(num)
  }
  case 2 => "two"
  case 3 => "three"
  case _ => "Something else"
}


val pickles = (1,2)
pickles match {
  case (1,2) => {
    timesFive(pickles._1)
  }
  case (2,_) => "two"
  case _ => timesFive(pickles._1 * 2)
}

// example above is pattern matching with int's and then tuples


def isListEmpty (list : List[Int]) = list match{
  case Nil => true
  case List() => false
  case h :: tail if h == 2 =>
    false
  case _ => false
}

val numbers = List(1,2,3,4,5)
isListEmpty(numbers)

// example above is pattern matching with Lists


sealed trait Pet {
  val name : String
  val age: Int
}

case class Dog (name: String, age:Int)
  extends Pet{
  def speak = "hello!"
}

case class Cat (name: String, age: Int)
  extends Pet

def isDog(pet : Pet) : String = pet match{
  case d: Dog => s"${d.name} I am a Dog!"
  case c: Cat => s"$c I am a cat!"
  case _ => "Something else"
}
isDog(Dog("Jessie!", 10))
isDog(Cat("Jaffacakes!", 8))

// above example is example of pattern matching within a sealed trait using strings and case classes


def determineAge (pet : Pet) = pet match {
  case Dog(name, age) if name == "Roxy" =>
    s"$name is ${age*7} years old"
  case Cat(name, age) =>
    s"$name is $age years old"
  case Dog(name, _) =>
    s"I've got a runt $name"
}

determineAge(Dog("Roxy", 6))
determineAge(Cat("Anna", 8))
determineAge(Dog ("Storm", 12))