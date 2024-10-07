package generics

trait Comparable[T] {
  def compareTo(other: T): Int
}
trait Tree[T <: Comparable[T]] {
  def find(x: T): Boolean
  def max(): T
}
class Node[T <: Comparable[T]](val value: T, left: Tree[T], right: Tree[T])
    extends Tree[T] {
  def find(x: T): Boolean = {
    x.compareTo(value) == 0 || left.find(x) || right.find(x)
  }
  def max(): T = {
    val maxLeft = left.max()
    val maxRight = right.max()
    if (value.compareTo(maxLeft) >= 0 && value.compareTo(maxRight) >= 0) {
      value
    } else if (value.compareTo(maxLeft) >= 0)
      maxRight
    else
      maxLeft
  }
}

class Leaf[T <: Comparable[T]](val value: T) extends Tree[T] {
  def find(x: T): Boolean = x.compareTo(value) == 0
  def max(): T = value
}
class Person(val name: String, val age: Int) extends Comparable[Person] {
  def compareTo(other: Person): Int = {
    if (age > other.age) 1
    else if (age < other.age) -1
    else {
      name.compareTo(other.name)
    }
  }
  override def toString(): String = s"Person(${name}, ${age})"
}

object TreeMain {
  def main(args: Array[String]): Unit = {
    val p1 = new Person("Pedro", 21)
    val l1 = new Leaf[Person](new Person("Maria", 21))
    val l2 = new Leaf[Person](new Person("Juan", 22))

    val t = new Node[Person](p1, l1, l2)
    println("Unknown(22)?: " + t.find(new Person("Unknown", 22)))
    println("Juan(22)?: " + t.find(new Person("Juan", 22)))
    println(t.max())
  }
}
