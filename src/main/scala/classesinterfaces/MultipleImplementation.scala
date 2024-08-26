package classesinterfaces

object MultipleImplementation {

  trait A:
    def a(): Int
  trait B extends A:
    def b(): String
  trait C extends A:
    def c(): Unit
  trait G extends A:
    def g(): Unit
  trait D extends B with C with G:
    def d(): Unit
  // provider
  class E extends D:
    def a(): Int = 1
    def b(): String = "hola"
    def c(): Unit = {}
    def g(): Unit = {}
    def d(): Unit = {}
  // client
  def foo(x: G) = {
    x.g()
    x.a()
  }
  foo(new E())
  val x1: A = new E()
  val x2: B = new E()
  val x3: C = new E()
  val x5: G = new E()
  val x4: D = new E()
}
