package doubledispatch

import scala.collection.mutable.Map

class MoneyBag extends IMoney {
  private val moneys: Map[String, Money] = Map()

  def this(l: List[Money]) = {
    this()
    // version long
    /*for (m <- l) {
      addMoney(m)
    }*/
    // version plus ultra
    l.foreach((m: Money) => addMoney(m))
  }
  def this(m1: Money, m2: Money) = { // new MoneyBag(m1, m2)
    this(List(m1, m2))
  }

  def add(other: IMoney): IMoney = {
    other.addMoneyBag(this)
  }

  def addMoney(other: Money): IMoney = {
    // val newMoney: Money =
    // getMoney(other.getCurrency()).map(b => b.addMoneySameCurrency(other)).getOrElse(other)
    val before: Option[Money] = getMoney(other.getCurrency())
    val newMoney: Money =
      if (before.isDefined)
        before.get.addMoneySameCurrency(other)
      else other
    // Si before era nulo, entonces ....

    moneys += (other.getCurrency() -> newMoney)
    this
  }

  def getMoney(currency: String): Option[Money] = {
    moneys.get(currency)
  }

  def addMoneyBag(other: MoneyBag): IMoney = {
    /*for (m <- other.moneys.values) {
      this.addMoney(m)
    }*/
    other.moneys.values.foreach(m => this.addMoney(m))
    this
  }

  override def equals(obj: Any): Boolean = {
    if (this.getClass.getName.equals(obj.getClass.getName)) {
      val other = obj.asInstanceOf[MoneyBag]
      this.moneys == other.moneys
    } else {
      false
    }
  }
}
