package tamagotchi

class Tamagotchi extends Subject[Visitor]:
  private var state: State = new Happy()
  def changeState(newState: State): Unit =
    state = newState

  def doSport(): Unit = state.doSport(this)
  def giveFood(): Unit = state.giveFood(this)
  def sleep(): Unit = state.sleep(this)

  def isHappy(): Boolean = state.isHappy()
  def isHungry(): Boolean = state.isHungry()
  def isSleepy(): Boolean = state.isSleepy()
