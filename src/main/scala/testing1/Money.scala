package testing1

class Money(value: Int, currency: String) {
  def getValue(): Int = value
  def getCurrency(): String = currency

  def add(other: Money): Money = {
    // if(currency == other.getCurrency()){
    new Money(value + other.getValue(), currency)
    // }
  }

  override def equals(other: Any): Boolean = {
    other match {
      case m: Money => value == m.getValue() && currency == m.getCurrency()
      case _        => false
    }
  }
}
