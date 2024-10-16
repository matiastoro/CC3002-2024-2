package tamagotchi

import munit.FunSuite

class TamagotchiTest extends FunSuite {
  test("crear un tamagotchi") {
    val t = new Tamagotchi()
    assert(t.isHappy())
    assert(!t.isSleepy())
    assert(!t.isHungry())
  }
  test("hacer ejercicio") {
    val t = new Tamagotchi()
    t.doSport()
    assert(!t.isHappy())
    assert(!t.isSleepy())
    assert(t.isHungry())
  }
}
