package examples

object SecondaryConstructor {

  class Person(name : String, age: Int, private val bankAccount: Seq[accounts] = Nil) {

    // below we have added a list of names called excludedNames - any names in this list will not get a hello as per speak function //

    private val excludedNames : List[String] = List("Connor", "Michael", "Doug", "Matt", "Andy")

    private val setNames : Set[String] = Set("Pan", "Shannon", "Jack", "Jack")


    // Below is a secondary constructor - In person class we are saying that each person created has a name, age and now a new bank account.
    // The secondary constructor below creates a new savings account for each person we create.
    // problem with below example is that is that with each person created it creates them with the same acc number and balance.


    def this (name: String, age: Int) = this (
      name = name,
      age= age,
      bankAccount = List(new SavingsAccount("123", 100.00)))


    // The secondary constructor below takes in firstName and lastName and stores it as one parameter under "name" //

    def this (firstName : String, lastName : String) = this(name = s"$firstName $lastName", age = 0, bankAccount = List (new SavingsAccount("12345", 0.00)))


    // The below secondary constructor asks for just a name when creating person and automatically assigns the age, accnumber and balance ) //

    def this (name: String) = this (name: String, age = 0, bankAccount = List(new SavingsAccount("1234", 0)))



    private val years : String = {
      if(age == 1) "year" else "years"
    }


    // when using .map function (_.toLowercase) allows you to select all the items in the list and if they have//
    // capital letters forces them to lowercase - the _. selects all in the list //

    // iterable types .map .head .tail .filter //


    def speak() : String = {
      if (excludedNames.map(_.toLowerCase).contains(name.toLowerCase)) {
        "You don't get a hello."
      } else {
        s"Hello $name, you are $age $years old. \n $bankAccount"

      }
    }

  }

