package tamagotchi_callback

import scala.collection.mutable.ListBuffer

class Subject[T] {
  var observers: ListBuffer[Observer[T]] = ListBuffer()
  def registerObserver(o: Observer[T]) = observers += o
  def notify(obj: T) = {
    for { o <- observers } {
      o.update(obj)
    }
  }
}

trait Observer[T] {
  def update(obj: T): Unit
}
