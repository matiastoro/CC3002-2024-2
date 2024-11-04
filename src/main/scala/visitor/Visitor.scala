package visitor

trait Visitor {
  def visitDirectory(d: Directory): Unit
  def visitTextFile(t: TextFile): Unit
  def visitBinaryFile(b: BinaryFile): Unit
}
class DoNothingVisitor extends Visitor {
  def visitDirectory(d: Directory): Unit = {}
  def visitTextFile(t: TextFile): Unit = {}
  def visitBinaryFile(b: BinaryFile): Unit = {}
}
class NumberOfFilesVisitor extends DoNothingVisitor {
  private var acc = 0
  override def visitTextFile(t: TextFile): Unit = acc += 1
  override def visitBinaryFile(b: BinaryFile): Unit = acc += 1
  def result(): Int = acc
}

class NumberOfDirectoriesVisitor extends DoNothingVisitor {
  private var acc = 0
  override def visitDirectory(d: Directory): Unit = acc += 1
  def result(): Int = acc
}

class ListingVisitor extends Visitor {
  private var acc = ""
  def result(): String = acc
  def visitDirectory(d: Directory): Unit = acc += d.getName() + "\n"
  def visitTextFile(t: TextFile): Unit = acc += t.getName() + "\n"
  def visitBinaryFile(b: BinaryFile): Unit = acc += b.getName() + "\n"
}
