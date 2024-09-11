package visibility
import scala.collection.mutable.{ListBuffer => List}
class Picture

trait Satelite {
  def doCommand(c: Command): Unit
  def setAngle(angle: Double): Unit
  def getPictures(): List[Picture]
  def setPictures(pictures: List[Picture]): Unit
  def getAngle(): Double
  def getNumberPictures(): Int
}
class Suchai(private var angle: Double) extends Satelite {
  private var pictures: List[Picture] = List[Picture]()
  def setAngle(angle: Double): Unit = {
    this.angle = angle
  }
  def getPictures() = pictures
  def setPictures(pictures: List[Picture]): Unit = {
    this.pictures = pictures
  }

  def getAngle(): Double = angle

  def getNumberPictures(): Int = pictures.size

  def doCommand(c: Command): Unit = {
    c.doAction(this)
  }
}

trait Command {
  def doAction(s: Satelite): Unit
}
class TakePicture extends Command {
  def doAction(s: Satelite): Unit = {
    s.setPictures(s.getPictures().append(new Picture))
  }
}

class Rotate(angle: Double) extends Command {
  def doAction(s: Satelite): Unit = {
    s.setAngle(s.getAngle() + angle)
  }
}

class CleanCache extends Command {
  def doAction(s: Satelite): Unit = {
    s.setPictures(List[Picture]())
  }
}
