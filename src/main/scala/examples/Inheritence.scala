package examples

object myAnimal extends App {

  val jess: Animal = new Cat()
  val lassie: Animal = new Dog()
  val sirius: Dog = new Wolf()
  val lola: BorderTerrier = new BorderTerrier()
  val kimya: Cat = new PersianCat()
  val jesse: Meowth = new Meowth(10, true)
  val james: Meowth = new Meowth(1, false)
  val perry: Puma = new Puma(true)
  val jerry: Puma = new Puma(false)
  val terry: Jaguar = new Jaguar

  println(jess.speak())
  println(lassie.speak())
  println(sirius.speak())
  println(s"${lola.speak} ${lola.hunt}")
  println(kimya.speak())
  println(jesse.speak())
  println(james.speak())
  println(jerry.speak())
  println(perry.speak())
  println(terry.speak())
}

abstract class Animal {
  def speak(): String

}

class Dog extends Animal {
  override def speak(): String = "Woof"
}

class BorderTerrier extends Dog {

  def hunt(): String = "I Hunt Rats"
}

class Wolf extends Dog {
  override def speak(): String = "HOWL"
}

class Cat extends Animal {
  override def speak(): String = "Meow"
}

class PersianCat extends Cat

class Meowth(coins: Int, teamRocket: Boolean) extends Cat {
  override def speak(): String = s"That's Right! I have $coins $single. " + rocket

  private val rocket = if (teamRocket) "I'm an official member of TEAM ROCKET"
  else "I'm to cheap to be a member of team rocket :( !"

  private val single = if (coins < 2) "coin"
  else "coins"

}

class Puma(crayonMuncher: Boolean) extends Cat {
  override def speak(): String = crayon

  private val crayon = if (crayonMuncher) "I love to eat crayons of all colours"
  else "I'm only partial to green crayons like Connor Irvine"
}

class Jaguar extends Puma(crayonMuncher = true)
