import scala.util.{Failure, Success, Try}

def parseInt(n:Any) = Try(n.toString.toInt)

/** Below is an example of the Method Try. Not try catch this is another way of controlling exceptions - It is Type safe it allows us to return the type being entered - Try's give back either a Success or a Failure. **/

/** we can use recover to take the exception and assign it a type **/
/** you can fold / map etc over Try method **/

/** Only non fatal exceptions will be caught by a Try **/

parseInt(2)
parseInt("2")
parseInt("two")

val two = parseInt("two")

two match {
  case Success (x) => x
  case Failure(e) => e
}

two.map {n => n} recover {
  case _ : Exception =>
    0
}

two.fold(_ => 0, _ + 2)

val age = for {
  a <- parseInt("5")
} yield s"You ar $a years old"