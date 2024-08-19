package testing1
import scala.collection.mutable.Map

class MoneyBag {
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

  /*def foo(): List[String] = {
    //En Python: map([1,2,3,4], lambda x: "Numero "+str(x))
    List(1, 2, 3, 4).map((x: Int) => s"Numero ${x}")
    //List("Numero 1", "Numero 2", ...)
  }*/
  def addMoney(m: Money): Unit = {
    // version 0.1 larga
    /*val before: Option[Money] = getMoney(m.getCurrency())
    val newMoney =
      if (before.isDefined)
        before.get.add(m)
      else m*/
    val newMoney =
      getMoney(m.getCurrency()).map(b => b.add(m)).getOrElse(m)
    // Si before era nulo, entonces ....

    moneys += (m.getCurrency() -> newMoney)
  }

  def getMoney(currency: String): Option[Money] = {
    moneys.get(currency)
  }
}
