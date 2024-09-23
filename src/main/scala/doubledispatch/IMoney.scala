package doubledispatch

trait IMoney {
  def add(other: IMoney): IMoney
  def addMoney(other: Money): IMoney
  def addMoneyBag(other: MoneyBag): IMoney
}
