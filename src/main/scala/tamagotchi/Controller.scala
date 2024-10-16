package tamagotchi

class Persona extends Observer[Visitor]:
  def update(obj: Visitor): Unit = obj.visit(this)
  def updateHappy() = println("le voy a hacer ejercicio")
  def updateHungry() = println("le voy a dar commida")
  def updateSleepy() = println("lo hago dormir")

object Controller:
  def main(args: Array[String]): Unit =
    val t = new Tamagotchi()
    val o: Observer[Visitor] = new Persona()
    t.registerObserver(o)

    t.doSport() // el observer acá debería imprimir "le voy a dar comida"
