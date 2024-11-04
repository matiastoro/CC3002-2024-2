package visitor.old

import scala.collection.mutable.ListBuffer

trait Item {
  def getName(): String
  def getSize(): Int
  def getNumberOfFiles(): Int
  def getNumberOfDirectory(): Int
  def listing(): String
}
class Directory(private val name: String) extends Item {
  val elements: ListBuffer[Item] = ListBuffer()
  def getName(): String = name
  def getSize() = {
    elements.foldLeft(0)((acc, e) => acc + e.getSize())
  }
  def add(e: Item) = elements += e

  def getNumberOfFiles(): Int = {
    elements.foldLeft(0)((acc, e) => acc + e.getNumberOfFiles())
  }
  def getNumberOfDirectory(): Int = {
    elements.foldLeft(1)((acc, e) => acc + e.getNumberOfDirectory())
  }
  def listing(): String = {
    elements.foldLeft(name + "\n")((acc, e) => acc + e.listing())
  }
}
abstract class AbstractFile(private val name: String) extends Item {
  def getName(): String = name

  def getNumberOfFiles(): Int = 1
  def getNumberOfDirectory(): Int = 0

  def listing(): String = name + "\n"
}
class TextFile(private val name: String, private val content: String)
    extends AbstractFile(name) {
  def getSize(): Int = content.length
}

class BinaryFile(private val name: String, private val content: Array[Byte])
    extends AbstractFile(name) {
  def getSize(): Int = content.length
}
