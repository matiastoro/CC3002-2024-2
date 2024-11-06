package expressionproblem

import visitor.{Directory, Item}

class FileSystemFP {
  val root = new Directory("root")
  def add(e: Item) = root.add(e)
  def getSize() = root.getSize()
  def getNumberOfFilesRec(item: Item): Int = {
    item match {
      case d: Directory =>
        d.getElements().map(getNumberOfFilesRec).sum
      // case s: SymbolicLink => ...
      case _ => 1
    }
  }
  def getNumberOfFiles(): Int = getNumberOfFilesRec(root)

  def getNumberOfDirectoriesRec(item: Item): Int = {
    item match {
      case d: Directory =>
        d.getElements().map(getNumberOfFilesRec).sum + 1
      case _ => 0
    }
  }
  def getNumberOfDirectories(): Int = getNumberOfDirectoriesRec(root)

  def listingRec(item: Item): String = {
    item match {
      case d: Directory =>
        d.getName() + "\n" +
          d.getElements().foldLeft("")((acc, i) => acc + listingRec(i) + "\n")
      case _ => item.getName() + "\n"
    }
  }
  def listing(): String = listingRec(root)

  def sizeOfRec(item: Item): Int = {
    item match {
      case d: Directory =>
        d.getElements().map(sizeOfRec).sum
      case _ => item.getSize()
    }
  }
  def sizeOf(): Int = sizeOfRec(
    root
  ) // supongamos que no tenemos getSize() de directorio
}
