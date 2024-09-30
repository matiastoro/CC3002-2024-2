package exceptions

object Exceptions {
  def foo = {
    println("hola")
    10
  }
  def main(args: Array[String]): Unit = {
    println(foo)

    println({
      println("hola")
      10
    })
  }

}
