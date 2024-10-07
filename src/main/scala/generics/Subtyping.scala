package generics

object Subtyping {
  trait A
  trait B extends A
  trait C extends B

  def foo(f: B => B): B = ???
  def bar01(x: B): C = ???
  /* foo(bar01)
  B => C <: B => B
   */
  def bar02(x: A): B = ???
  /* foo(bar02)
  A => B <: B => B si
  B <: A si
  B <: B si
   */
  def bar03(x: A): C = ???
  /* foo(bar03)
  A => C <: B => B si
  B <: A si
  C <: B si
   */
  def baz(f: (B => B) => B): Unit = ???
  baz(foo)
  def hof1(g: C => A): B = ???
  /* baz(hof1)
  hof1: (C => A) => B
  baz: ((B => B) => B) => Unit
  (C => A) => B <: (B => B) => B si
  (B => B) <: (C => A) si
  C <: B si
  B <: A si
  B <: B si
   */
}
