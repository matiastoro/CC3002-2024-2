package designpatterns1

import munit.FunSuite

class SafeTest extends FunSuite {
  test("inital state must be open") {
    val safe: Safe = new Safe()
    assert(safe.isOpened())
    assert(!safe.isClosed())
    assert(!safe.isLocked())
  }
  test("OPENED -> CLOSED") {
    val safe: Safe = new Safe()
    safe.close()
    assert(!safe.isOpened())
    assert(safe.isClosed())
    assert(!safe.isLocked())
  }
  test("CLOSE -close-> error") {
    val safe: Safe = new Safe()
    safe.close()
    try {
      safe.close()
      throw new Exception("El test no paso")
    } catch {
      case _: WrongStateException => assert(true)
      case e                      => assert(false)
    }
  }

  test("OPENED -> CLOSED -> LOCKED") {
    val safe: Safe = new Safe()
    safe.close()
    safe.lock()
    assert(!safe.isOpened())
    assert(!safe.isClosed())
    assert(safe.isLocked())
  }
  test("OPENED -> CLOSED -> LOCKED -> CLOSED -> OPENED") {
    val safe: Safe = new Safe()
    safe.close()
    safe.lock()
    safe.enterCode()
    safe.open()
    assert(safe.isOpened())
    assert(!safe.isClosed())
    assert(!safe.isLocked())
  }
}
