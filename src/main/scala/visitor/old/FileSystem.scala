package visitor.old

import scala.collection.mutable.ListBuffer

class FileSystem {
  val root = new Directory("root")
  def add(e: Item) = root.add(e)
  def getSize() = root.getSize()
  def getNumberOfFiles(): Int = root.getNumberOfFiles()
  def getNumberOfDirectory(): Int = root.getNumberOfDirectory()
  def listing(): String = root.listing()
}
