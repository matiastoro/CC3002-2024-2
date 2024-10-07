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


object Main {
  def main(args: Array[String]): Unit = {

    val x: MyOption[String] = MyNone
    println(x.getOrElse("hola"))
  }
}
