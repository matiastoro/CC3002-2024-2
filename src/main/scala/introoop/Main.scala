package introoop
object Main {
  def moveDiagonally(m: Movable) = {
    m.move(10, 10)
  }
  def main(args: Array[String]): Unit = {
    val p0: Point = new Point(0, 0)
    println(p0)
    moveDiagonally(p0)
    println(p0)
    val r0: Rectangle = new Rectangle(p0, 100, 200)
    println(r0)
    println(s"el area es: ${r0.area()}")
    moveDiagonally(r0)
    println(r0)
  }
}

trait Movable {
  def move(dx: Int, dy: Int): Unit
}
class Point(private var x: Int, private var y: Int) extends Movable {
  def move(dx: Int, dy: Int): Unit = {
    x += dx
    y += dy
  }
  override def toString(): String = s"Point(${x}, ${y})"
}
class Rectangle(private val p: Point, width: Int, height: Int) extends Movable {
  def move(dx: Int, dy: Int): Unit = p.move(dx, dy)

  def area(): Int = width * height

  override def toString(): String = {
    s"Rectangle(${p}, ${width}, ${height})"
  }
}
