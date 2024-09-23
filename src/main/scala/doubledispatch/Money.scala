package doubledispatch

class Money(value: Int, currency: String) extends IMoney {
  def getValue(): Int = value

  def getCurrency(): String = currency

  def addMoneySameCurrency(other: Money): Money = {
    new Money(value + other.getValue(), currency)
  }
  // a + b ---> b +A a
  def add(other: IMoney): IMoney = {
    // Si other es un money, entonces hacer "addMoneyOld",
    // si other es un moneybag, entonces hacer otra cosa
    other.addMoney(this)
  }

  override def equals(other: Any): Boolean = {
    other match {
      case m: Money => value == m.getValue() && currency == m.getCurrency()
      case _        => false
    }
  }

  def addMoney(other: Money): IMoney = {
    if (this.getCurrency() == other.getCurrency())
      this.addMoneySameCurrency(other)
    else
      new MoneyBag(this, other)
  }

  def addMoneyBag(other: MoneyBag): IMoney = {
    other.addMoney(this)
  }
}
