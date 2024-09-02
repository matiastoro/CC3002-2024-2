package inheritance

object Inheritance {
  trait D {
    def d(): Int
  }

  trait A {
    def a(): Int

    def b(): Boolean
  }

  abstract class B extends A {
    def a(): Int = {
      if (b()) 1 else 2
    }

    def d(): Int = 1
  }

  class C extends B with D {
    def b(): Boolean = true
  }

  object Inheritance {
    new C().a()
  }
}
