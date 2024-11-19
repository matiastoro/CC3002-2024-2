package exercisesc2

object Ejercicio3 {
  sealed trait MyData:
    def visit(v: Visitor): Unit
  case class MyInt(value: Int) extends MyData:
    def visit(v: Visitor): Unit = v.visitMyInt(this)
  case class MyString(value: String) extends MyData:
    def visit(v: Visitor): Unit = v.visitMyString(this)
  case class MyBoolean(value: Boolean) extends MyData:
    def visit(v: Visitor): Unit = v.visitMyBoolean(this)
  case class MyList(values: List[MyData]) extends MyData:
    def visit(v: Visitor): Unit = v.visitMyList(this)

  def processData(d: MyData): Int = {
    val v = new ProcessDataVisitor()
    d.visit(v)
    v.getResult
  }

  trait Visitor:
    def visitMyInt(d: MyInt): Unit
    def visitMyString(d: MyString): Unit
    def visitMyBoolean(d: MyBoolean): Unit
    def visitMyList(d: MyList): Unit
    def getResult: Int

  class ProcessDataVisitor extends Visitor:
    private var result: Int = 0
    def getResult: Int = result
    def visitMyInt(d: MyInt) = result += 2 * d.value
    def visitMyString(d: MyString) = result += d.value.length
    def visitMyBoolean(d: MyBoolean) = result += { if (d.value) 1 else 0 }
    def visitMyList(d: MyList) = result += d.values
      .collect({
        case i: MyInt => i.value
        case l: MyList =>
          visitMyList(l)
          0
      })
      .sum

}
