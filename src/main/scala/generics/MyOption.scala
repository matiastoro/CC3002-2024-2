package generics

trait MyOption[+T] {
  def get: T
  def isEmpty: Boolean
  def getOrElse[S >: T](default: S): S
}

class MySome[T](v: T) extends MyOption[T] {
  def get: T = v
  def isEmpty: Boolean = false
  def getOrElse[S >: T](default: S): S = v
}

object MyNone extends MyOption[Nothing] {
  def get: Nothing = throw new Exception("No puedes hacer get de un None")
  def isEmpty: Boolean = true
  def getOrElse[S](default: S): S = default
}
class Animal {
  def talk() = println("hola")
}
class Cat extends Animal {
  def meow() = println("miau")
}
class Tuxedo extends Cat

object Main {
  def foo(x: MyOption[Animal]) = {
    if (!x.isEmpty)
      x.get.talk()
  }
  def main(args: Array[String]): Unit = {

    val x: MyOption[String] = MyNone
    println(x.getOrElse("hola"))

    val y: MyOption[Cat] = new MySome[Cat](new Cat())
    foo(y)
  }
}
