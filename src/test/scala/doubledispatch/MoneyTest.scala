package doubledispatch

class MoneyTest extends munit.FunSuite {
  val mclp10 = new Money(10, "CLP")
  val mclp42 = new Money(42, "CLP")
  val musd12 = new Money(12, "USD")
  val musd14 = new Money(14, "USD")
  var mb1 = new MoneyBag(mclp10, musd12)
  var mb2 = new MoneyBag(mclp42, musd14)

  override def beforeEach(context: BeforeEach): Unit = {
    mb1 = new MoneyBag(mclp10, musd12)
    mb2 = new MoneyBag(mclp42, musd14)
  }

  test("helloworld") {
    assertEquals("HelloWorld", "HelloWorld")
  }
  test("new money") {
    assertEquals(mclp10.getValue(), 10)
    assertEquals(mclp10.getCurrency(), "CLP")
  }
  test("equals") {
    assertEquals(mclp10, mclp10)
  }
  test("equals v2") {
    val money1: Money = new Money(10, "CLP")
    assertEquals(money1, mclp10)
    val money2: Money = new Money(11, "CLP")
    assertNotEquals(money2, mclp10)
  }
  test("add") {
    val expected: IMoney = new Money(52, "CLP")
    val actual: IMoney = mclp10.add(mclp42)
    assertEquals(actual, expected)
  }
  test("bag equals") {
    assertEquals(mb1, mb1)
    assert(!mb1.equals(mclp10))
    assert(!mclp10.equals(mb1))
    assert(!mb1.equals(mb2))
  }
  test("constructor lista") {
    val mb = new MoneyBag(List(mclp10, musd14, new Money(30, "Foo")))
    assertEquals(mb.getMoney("CLP"), Some(mclp10))
    assertEquals(mb.getMoney("USD"), Some(musd14))
    assertEquals(mb.getMoney("EUR"), None)
  }

  test("add heterogeneous") {
    val expected: IMoney = mb1
    val actual: IMoney = mclp10.add(musd12)
    assertEquals(actual, expected)
  }
  test("add money + moneybag") {
    val expected: IMoney = new MoneyBag(new Money(20, "CLP"), musd12)
    assertEquals(mclp10.add(mb1), expected)
  }
  test("add moneybag + moneybag") {
    /* val mb1 = new MoneyBag(mclp10, musd12)
     val mb2 = new MoneyBag(mclp42, musd14)*/
    val expected: IMoney =
      new MoneyBag(new Money(52, "CLP"), new Money(26, "USD"))
    assertEquals(mb1.add(mb2), expected)
  }
  test("add moneybag + money") {
    val expected: IMoney = new MoneyBag(new Money(20, "CLP"), musd12)
    assertEquals(mb1.add(mclp10), expected)
  }
}
