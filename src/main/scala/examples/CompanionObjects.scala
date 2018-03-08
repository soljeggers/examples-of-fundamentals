
class Cat private(val name: String)
object Cat{
  def apply() = new Cat("Cat 1")
}


trait Pet {
  val age: Int
}

case class Dog private(name: String, override val age: Int) extends Pet {
  def this () = this("Lassie")
}

object Dog {
  def fromName(n: String) = {
    val d = new Dog(n,0)
    d
  }

  def fromDog(d:Dog) = {
  new Dog(d.name,1)
  }
}

trait Loader {
  val path : String
}

object Loader extends Loader {
  override val path : String = "load from file"
}

object URLLoader extends Loader {
  override val path: String = "load from web"
}
