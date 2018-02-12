package examples

object Options {

  // Option says you may or may not have a value.
  // Options provide you with the output of Some ("which could be type int, string, boolean") etc
  // and with this can also provide a None - The benefit of None is it can be easily controlled instead of throwing Exceptions.
  // great way of saying if you have a value or not without using Null like in Java.

  def markAnswer(a : String) : Option[Boolean] = {

    if (a.nonEmpty){
      Some(a.contains("dog"))
    }else{
      None
    }
  }
  //had to use Q's 1-3 to run code

  val scoreForQ1 : Option[Boolean] = markAnswer("dog")
  val scoreForQ2: Option[Boolean] = markAnswer("cat")
  val scoreForQ3 : Option[Boolean] = markAnswer("")

  if (scoreForQ1.isDefined){
    val score = scoreForQ1.getOrElse(false)
    println(score)
  }

  scoreForQ1.map(b => println(b))

  scoreForQ1.fold(false)(b => {
    println(b)
    b
  }
  )

  scoreForQ1 match {
    case None => ???
    case Some(x) => x
  }

}
