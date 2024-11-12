package functionprogramming

object Exercises {
  var x = 10
  val foo = () => println(x)

  val curriedSum = (x: Int) => { (y: Int) =>
    x + y
  }
  curriedSum(1) // (y: Int) => 1 + y

  def main(args: Array[String]): Unit = {
    foo()
    x = 12

    foo()

    val sentences = List("Hello world", "", "I love functional programming")

    def getWords(sentences: List[String]): List[String] = {
      sentences.flatMap(x => x.split(" ")).filter(x => x.size > 0)
    }
    println(getWords(sentences))

    List(1, 2, 3, 4, 5).zipWithIndex.foreach((x, i) => print(x, i))
  }
}
