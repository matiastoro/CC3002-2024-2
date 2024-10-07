package generics

trait Ordenable[T] {
  def menorQue(otro: T): Int
}

/** Ordenable[Foo] =(mas o menos)= trait Ordenable{ def menorQue(otro: Foo): Int
  * }
  */
class Foo(val n: Int) extends Ordenable[Foo] {
  def menorQue(otro: Foo) = if (n > otro.n) 1 else if (n < otro.n) -1 else 0
}
