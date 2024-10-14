package designpatterns1

class Safe {
  private var state: State = new Opened()
  def setState(s: State) = {
    state = s
  }
  def close(): Unit = state.close(this)
  def open(): Unit = state.open(this)
  def lock(): Unit = state.lock(this)
  def enterCode(): Unit = state.enterCode(this)

  /* for testing purposes */
  def isOpened() = state.isOpened()
  def isClosed() = state.isClosed()
  def isLocked() = state.isLocked()
}
