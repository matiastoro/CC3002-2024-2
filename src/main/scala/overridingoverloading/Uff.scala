package overridingoverloading

object Uff {
  class A {
    def foo(): Unit = println("A.foo")
    def bar(): Unit = {
      println("B.bar")
      this.waza()
    }
    def baz(a: B): Unit = println("A.baz")
    def waza(): Unit = println("A.waza")
  }
  class B extends A {
    def baz(b: C): Unit = println("B.baz")

    override def waza(): Unit = {
      println("C.waza")
      this.baz(this)
    }
  }
  class C extends B {
    def baz(b: A): Unit = println("C.baz")
    override def foo(): Unit = {
      super.bar()
      println("C.foo")
    }

  }

  new C().foo()
  // B.bar

}
