package tamagotchi_callback

trait State:
  def error(): Unit
  def doSport(t: Tamagotchi): Unit
  def giveFood(t: Tamagotchi): Unit
  def sleep(t: Tamagotchi): Unit

  def isHappy(): Boolean
  def isHungry(): Boolean
  def isSleepy(): Boolean

abstract class AbstractState extends State:
  def error(): Unit = throw new Exception("Bad state")
  def doSport(t: Tamagotchi): Unit = error()
  def giveFood(t: Tamagotchi): Unit = error()
  def sleep(t: Tamagotchi): Unit = error()

  def isHappy(): Boolean = false
  def isHungry(): Boolean = false
  def isSleepy(): Boolean = false

class Happy extends AbstractState:
  override def doSport(t: Tamagotchi): Unit =
    t.changeState(new Hungry())
    t.notify((obj: Persona) => obj.updateHungry())
  override def isHappy(): Boolean = true

class Hungry extends AbstractState:
  override def giveFood(t: Tamagotchi): Unit =
    t.changeState(new Sleepy())
    t.notify((obj: Persona) => obj.updateSleepy())
  override def isHungry(): Boolean = true

class Sleepy extends AbstractState:
  override def sleep(t: Tamagotchi): Unit =
    t.changeState(new Happy())
    t.notify((obj: Persona) => obj.updateHappy())
  override def isSleepy(): Boolean = true