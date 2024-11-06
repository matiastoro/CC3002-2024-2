package visitor

import scala.collection.mutable.ListBuffer

trait Item {
  def getName(): String
  def getSize(): Int
  def accept(v: Visitor): Unit
}
class Directory(private val name: String) extends Item {
  val elements: ListBuffer[Item] = ListBuffer()
  def getElements() = elements
  def getName(): String = name
  def getSize() = {
    elements.foldLeft(0)((acc, e) => acc + e.getSize())
  }
  def add(e: Item) = elements += e
  def accept(v: Visitor): Unit = {
    v.visitDirectory(this)
    elements.foreach(e => e.accept(v))
  }
}
abstract class AbstractFile(private val name: String) extends Item {
  def getName(): String = name

}
class TextFile(private val name: String, private val content: String)
    extends AbstractFile(name) {
  def getSize(): Int = content.length
  def accept(v: Visitor): Unit = v.visitTextFile(this)
}

class BinaryFile(private val name: String, private val content: Array[Byte])
    extends AbstractFile(name) {
  def getSize(): Int = content.length
  def accept(v: Visitor): Unit = v.visitBinaryFile(this)
}
