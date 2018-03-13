import scala.concurrent.Future
import scala.util.control.NonFatal

def getTweets() : Future[String] = Future.apply {
  """
    |{
    |"name" : "Adam"
    |"tweets" : [
    |   {
    |     "tweet" : "What's people having for lunch?,"
    |     "timestamp" : 2004210012
    |   },
    |      {
    |     "tweet" : "What's a giraffe?,"
    |     "timestamp" : 2004232012
    |   },
    |      {
    |     "tweet" : "Your Dad sells Avon?,"
    |     "timestamp" : 2001210012
    |   },
    |      {
    |     "tweet" : "Your Dads a dinner lady?,"
    |     "timestamp" : 2004220012
    |   },
  """.stripMargin
}

getTweets() map {
  t => t
  // save to database
  //redirect to next page
}recover {
  case NonFatal(e) =>
    e.getLocalizedMessage
}

for {
  tweets <- getTweets()
} yield s"Tweets : $tweets"

