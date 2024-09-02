package inheritance

import java.util.function.IntToDoubleFunction

object Comparable {
  trait Ordenable[T] {
    def compare(x: T): Int
  }

  class A(val n: Int) extends Ordenable[A] {
    def compare(x: A): Int =
      if (n > x.n) 1
      else if (n == x.n) 0
      else -1
    override def toString(): String = s"A(${n})"
  }

  class B(val b: Double) extends Ordenable[B] {
    def compare(x: B): Int = if (b > x.b) 1
    else if (b == x.b) 0
    else -1
  }

  def maximo[T <: Ordenable[T]](x1: T, x2: T) =
    if (x1.compare(x2) > 0) x1 else x2

  // val l = Array(new A(10), new A(20), new A(30))
  // scala.util.Sorting.quickSort(l)

  trait INode extends Ordenable[INode] {
    val value: Int
    def sum: Int
  }
  abstract class AbstractNode extends INode {
    def compare(x: INode) = sum.compareTo(x.sum)
  }
  class Node(val value: Int, left: INode, right: INode) extends AbstractNode {
    def sum: Int = value + left.sum + right.sum
    override def toString: String = s"Node(${value}, ${left}, ${right})"
  }
  class Leaf(val value: Int) extends AbstractNode {
    def sum: Int = value
    override def toString: String = s"Leaf(${value})"
  }

  class Person(val name: String, val age: Int, val weight: Double)
      extends Ordenable[Person] {
    def compare(other: Person) = {
      val r = name.compareTo(other.name)
      if (r == 0) age.compareTo(other.age) else -1 * r
    }
    override def toString: String = s"Person(${name}, ${age}, ${weight})"
  }

  def main(args: Array[String]): Unit = {
    println(maximo(new A(10), new A(20)))
    println(maximo(new B(34), new B(20)))

    val a1 = new Node(10, new Node(5, new Leaf(1), new Leaf(7)), new Leaf(8))
    val a2 = new Node(4, new Leaf(1), new Leaf(2000))
    println(maximo(a1, a2))

    val p1 = new Person("Alan Brito", 10, 10)
    val p2 = new Person("Who and it to", 20, 30)
    println(maximo(p1, p2))

  }

  class Animal {
    def foo(): Unit = {
      println("Animal.foo")
    }
  }
  class Cat extends Animal {
    def bar(): Unit = {}
    override def foo(): Unit = {
      println("Cat.foo")
    }
  }

  // val x: Animal = new Cat()
  // x.foo()
}
