package classesinterfaces

trait Nodo {
  def sum(): Int
  def min(): Int
  def max(): Int
}

class NodoInterno(val value: Int, val izq: Nodo, val der: Nodo) extends Nodo {
  def sum(): Int = value + izq.sum() + der.sum()
  def min(): Int = Math.min(value, Math.min(izq.min(), der.min()))
  def max(): Int = Math.max(value, Math.max(izq.max(), der.max()))
  override def equals(x: Any): Boolean = x match {
    case x: NodoInterno =>
      value == x.value && izq.equals(x.izq) && der.equals(x.der)
    case _ => false
  }
}

class NodoExterno(val value: Int) extends Nodo {
  def sum(): Int = value
  def min(): Int = value
  def max(): Int = value
  override def equals(x: Any): Boolean = x match {
    case x: NodoExterno =>
      value == x.value
    case _ => false
  }
}

class NodoVacio extends Nodo {
  def sum(): Int = 0
  def min(): Int = Integer.MAX_VALUE
  def max(): Int = Integer.MIN_VALUE
}
