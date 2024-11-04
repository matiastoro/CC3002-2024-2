package visitor

import scala.collection.mutable.ListBuffer

class FileSystem {
  val root = new Directory("root")
  def add(e: Item) = root.add(e)
  def getSize() = root.getSize()
  def getNumberOfFiles(): Int = {
    val v = new NumberOfFilesVisitor()
    root.accept(v)
    v.result()
  }

  def getNumberOfDirectories(): Int = {
    val v = new NumberOfDirectoriesVisitor()
    root.accept(v)
    v.result()
  }

  def listing(): String = {
    val v = new ListingVisitor()
    root.accept(v)
    v.result()
  }
}
