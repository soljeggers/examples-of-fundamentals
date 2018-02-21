package examples

object trycatchexceptions extends App  {

  def prompt() : (String,Int) = {
    val name: String = Prompt.ask("What is your name? ")

    def getAge() : Int = {

      import scala.util.control.Exception._
      val a : Option[Int] = nonFatalCatch.opt(Prompt.ask("How old are you?").toInt)
      a.fold(getAge())(a => a)

      /** above is an example of how to write a short hand try catch exception using nonFatalCatch instead of typing out
      the try catch exam.ple below. The above code does exactly what the code below does
       **/
    }
//      try {
//        val age = Prompt.ask("How old are you?").toInt
//        age
//      } catch {
//        case _: NumberFormatException =>
//          getAge()
//      }
//    }
    (name, getAge())
  }
}


