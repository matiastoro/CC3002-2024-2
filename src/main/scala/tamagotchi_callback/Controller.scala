package tamagotchi_callback

class Persona extends Observer[(Persona) => Unit]:
  def update(f: (Persona) => Unit): Unit = f(this)
  def updateHappy() = println("le voy a hacer ejercicio")
  def updateHungry() = println("le voy a dar commida")
  def updateSleepy() = println("lo hago dormir")

object Controller:
  def main(args: Array[String]): Unit =
    val t = new Tamagotchi()
    val o = new Persona()
    t.registerObserver(o)

    t.doSport() // el observer acá debería imprimir "le voy a dar comida"
