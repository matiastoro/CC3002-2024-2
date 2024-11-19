package forcomprehension

import scala.concurrent.Future
import scala.util.Success
//add implicit context
import scala.concurrent.ExecutionContext.Implicits.global
object ForComp {
  val l1 = List(1, 2, 3, 4)
  val l2 = List("hola", "como", "estas")

  def slowProcess(id: Int) = {
    Future {
      // sleep for 10 seconds
      println(s"Empezando el proceso lento ${id}")
      Thread.sleep(3000)
      println(s"Toy listeilor ${id}")
      id
    }
  }

  def main(args: Array[String]): Unit = {

    val f1 = slowProcess(1)
    val f2 = slowProcess(2)

    f1.onComplete { case Success(x) =>
      println(s"Este es el callback del proceso ${x}")
    }
    f2.onComplete { x =>
      println("Este es el callback del proceso 2")
    }
    println("Esto ocurre antes de que termine el proceso lento")
    while (true) {
      Thread.sleep(1000)
    }
  }

}
