package designpatterns1
class WrongStateException extends Exception
class State {
  def error() = throw new WrongStateException()
  def close(safe: Safe): Unit = error()
  def open(safe: Safe): Unit = error()
  def lock(safe: Safe): Unit = error()
  def enterCode(safe: Safe): Unit = error()

  def isOpened() = false
  def isClosed() = false
  def isLocked() = false
}

class Opened extends State {
  override def close(safe: Safe) = safe.setState(new Closed())
  override def isOpened() = true
}
class Closed extends State {
  override def open(safe: Safe) = safe.setState(new Opened())
  override def lock(safe: Safe) = safe.setState(new Locked())
  override def isClosed() = true
}
class Locked extends State {
  override def enterCode(safe: Safe): Unit = safe.setState(new Closed())
  override def isLocked() = true
}
