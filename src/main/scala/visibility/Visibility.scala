package visibility

import scala.io.StdIn

trait PrivateICharacter {
  def getHp(): Int // getter
  def setHp(hp: Int): Unit // setter
}

trait PublicICharacter {
  def getHp(): Int // getter
}

class Character(private var hp: Int)
    extends PublicICharacter
    with PrivateICharacter {
  def getHp(): Int = hp
  def setHp(newHp: Int): Unit = {
    hp = newHp
  }
}
object GameController {
  val robot: Character = new Character(100)
  private def getCurrentCharacterPrivate(): PrivateICharacter = robot
  def getCurrentCharacterPublic(): PublicICharacter = robot
  def main(args: Array[String]): Unit = {
    println("Ingrese la fuerza del pape")
    val fuerza = StdIn.readLine().toInt
    val current = getCurrentCharacterPrivate()
    current.setHp(current.getHp() - fuerza)
    println(
      s"ouch! me pegaron y me queda ${current.getHp()} de vida... bip bop"
    )
  }
}

object UI {
  val char: PublicICharacter = GameController.getCurrentCharacterPublic()
  def main(args: Array[String]): Unit = {
    // char.setHp(100000)
  }
}
