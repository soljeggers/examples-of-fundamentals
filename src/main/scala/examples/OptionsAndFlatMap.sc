abstract class User(val name : String,
                    val gender: Option[String] = None
               )

case class Person( override val name : String, override val gender: Option[String] = None) extends User(name, gender)

case class Employee (id : Int, override val name : String, override val gender: Option[String] = None) extends User(name, None)

object UserRepository {
  private val _people = List(
    Person("Adam", Some("Male")),
    Person("Toni", None),
    Employee(123, "Janice")
  )

  def findByName (name: String) : Option[User] ={
    _people.find(u => u.name == name)
  }

  def findEmployee() : List[Employee] = {
    _people.flatMap {
      case u @ Person(_, _) =>
        None
      case e @ Employee (_, _, _,) =>
        Some(e)
    }
  }
}

val filtered = UserRepository.findByName("Adam")
.flatMap(
  _.gender.map(
    _ == "Male"
  )
)

// val things = List(List(1,2,3), List(1,2,3))
// val x = things.flatMap (num => num)
// above is an example of flatMapping... The output for this would remove the substructure of a list of lists and pull out the ints...

// the output would be List(1,2,3,1,2,3)

val userString: Option[String] = for {
  user <- UserRepository.findByName("Adam")
} yield s"${user.name}"
userString