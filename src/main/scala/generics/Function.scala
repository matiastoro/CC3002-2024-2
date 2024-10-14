package generics

trait Function[-D, +C] {
  def apply(x: D): C
}

class PlusOne extends Function[Int, Int] {
  def apply(x: Int): Int = x + 1
}
class Double extends Function[Int, Int] {
  def apply(x: Int): Int = x * 2
}
class SizeOfString extends Function[String, Int] {
  def apply(x: String): Int = x.length
}

class Booo extends Function[Animal, Tuxedo] {
  def apply(x: Animal) = {
    x.talk()
    new Tuxedo()
  }
}

@main
def functionMain = {
  val f = new SizeOfString()
  println(f("hola"))

  def bar(f: Function[Cat, Cat]) = {
    f(new Cat())
  }

  val f1: Function[Animal, Tuxedo] = new Booo()
  bar(f1)

  val l = new MyList[Cat]()
  val a: Animal = new Animal()
  l.prepend(a)

}


class MyList[+A]{
  def prepend[B>:A](x: B) = ???
}


