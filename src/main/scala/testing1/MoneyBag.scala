package testing1
import scala.collection.mutable.Map

class MoneyBag {
  val moneys: Map[String, Money] = Map()
  def this(m1: Money, m2: Money) = { // new MoneyBag(m1, m2)
    this()
    addMoney(m1)
    addMoney(m2)
  }
  def addMoney(m: Money): Unit = {
    val before: Option[Money] = moneys.get(m.getCurrency())
    // Si before no es nulo, entonces ....
    // Si before era nulo, entonces ....
    // moneys += (m.getCurrency() -> m.add(before))
    ???
  }
}
