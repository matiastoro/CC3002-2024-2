package doubledispatch

class CachipunTest extends munit.FunSuite {
  test("scissor play stone = -1") {
    val scissor = new Scissor()
    val stone = new Stone()
    assertEquals(scissor.play(stone), -1)
  }
}
