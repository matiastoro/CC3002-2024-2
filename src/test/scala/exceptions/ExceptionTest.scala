package exceptions

import munit.FunSuite

class ExceptionTest extends FunSuite {
  def assertException[T <: Exception](body: => Unit) = {
    try {
      body
      assert(false)
    } catch {
      case e: T => assert(true)
    }
  }

  class ErrorFoo extends Exception
  test("division by zero") {
    assertException[java.lang.ArithmeticException](10 / 0)
  }

  def complexFunction(x: Int) = {
    if (x > 0)
      throw new ErrorFoo()
  }
  test("check ErroFoo") {
    assertException[ErrorFoo](complexFunction(10))
    // assertException[ErrorFoo](complexFunction(0))

  }
}
