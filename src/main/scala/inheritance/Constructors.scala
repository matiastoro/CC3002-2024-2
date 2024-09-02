package inheritance

@main def constructors = {
  val x = new C()
  println(s"el nombre de new C() es ${x.name}")

  def foo(x: Int) = {
    print(x)
  }
}

abstract class A(val name: String, var age: Int) {
  println(s"A.constructor name=${name}, y age=${age}")
  def getName() = name
}
class B(name: String) extends A(name.toUpperCase, 0) {
  println(s"B.constructor name=${name} vs name=${getName()}")
}
class C extends B("Foo") {
  println("C.constructor")
}
