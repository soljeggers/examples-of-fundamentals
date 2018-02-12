package examples

import scala.io.Source

object traits extends App {
  // below is an example of logging trait //
  // if we want multiple bank accounts but dont want to lock parameters into needed to do logs constantly like when
  // using constructors in our class
  // traits can be implemented to get certain accounts to use trait logging as below
  // val acc = new SAccount() with Logging to File
  trait Logging {
    def log: Boolean
  }
  trait LoggingToFile extends Logging {
    override def log: Boolean = {
      val file = Source.fromFile("").getLines()
      file.nonEmpty
    }
  }

  abstract class Bank
  class SAccount extends Bank
  val acc = new SAccount() with LoggingToFile
  trait LoggingToFileEncrypted extends LoggingToFile {
    override def log = ???

  }
  val richardBrandson = new SAccount() with LoggingToFileEncrypted
  val billGates = new SAccount() with LoggingToFileEncrypted {
    // override def log : Boolean = true
    // - You can assign new behaviours for different acc's in line by removing
    // the method from the trait and putting it within the instanciated class as above for bill gates
  }
}
//  abstract class Animal {
//    def speak
//  }
//
//  trait WaggingTail {
//    def startTail
//
//    def stopTail
//  }
//
//  trait FourLeggedAnimal {
//    def walk
//
//    def run
//  }
//
//  abstract class Dog extends Animal with WaggingTail with FourLeggedAnimal {
//    // implementation code here ...