package expressionproblem

object ExpressionProblem {
  trait Exp {
    def eval(): Int
  }
  trait Lit extends Exp {
    val x: Int
    def eval(): Int = x
  }
  trait Add extends Exp {
    val e1, e2: Exp
    def eval(): Int = e1.eval() + e2.eval()
  }

  /** Extension 1: vamos a extender nuestro programa con una nueva operacio
    * `print`. De aqui para arriba: NO SE TOCA *
    */
  trait ExpWithPrint extends Exp {
    def print(): String
  }
  trait LitWithPrint extends ExpWithPrint with Lit {
    def print(): String = x.toString
  }
  trait AddWithPrint extends ExpWithPrint with Add {
    val e1, e2: ExpWithPrint
    def print(): String = "(" + e1.print() + "+" + e2.print() + ")"
  }

  /** Extension 2: un nuevo variante. De aqui para arriba NO SE TOCA
    */
  trait Subst extends Exp {
    val e1, e2: Exp
    def eval(): Int = e1.eval() - e2.eval()
  }

  /** Extension 3: vamos a extender de dos extensiones independientes. De aqui
    * para arriba NO SE TOCA
    */

  trait SubstWithPrint extends ExpWithPrint with Subst {
    val e1, e2: ExpWithPrint
    def print(): String = "(" + e1.print() + "-" + e2.print() + ")"
  }

  /** Extension 4: vamos a extender Exp con collect (devuelve una lista de
    * constantes de mi expresion)
    */
  trait ExpWithCollect extends Exp {
    def collect(): List[Int]
  }
  trait LitWithCollect extends ExpWithCollect with Lit {
    def collect(): List[Int] = List(x)
  }
  trait AddWithCollect extends ExpWithCollect with Add {
    val e1, e2: ExpWithCollect
    def collect(): List[Int] = e1.collect() ++ e2.collect()
  }

  /** Extension 5: combinar extensiones independientes de print y collect. de
    * aqui arriba no se toca
    */
  trait ExpWithPC extends ExpWithPrint with ExpWithCollect
  trait LitWithPC extends ExpWithPC with LitWithPrint with LitWithCollect
  trait AddWithPC extends ExpWithPC with AddWithPrint with AddWithCollect {
    val e1, e2: ExpWithPC
  }
  trait SubstWithPC extends ExpWithPC with SubstWithPrint {
    val e1, e2: ExpWithPC
    def collect(): List[Int] = e1.collect() ++ e2.collect()
  }

  def main(args: Array[String]): Unit = {
    val l1 = new LitWithPC { val x = 10 }
    val l2 = new LitWithPC { val x = 20 }
    val _e1 = new AddWithPC { val e1 = l1; val e2 = l2 }
    val _e2 = new SubstWithPC { val e1 = l1; val e2 = l2 }
    val e = new AddWithPC { val e1 = _e1; val e2 = _e2 }
    println(e.eval())
    println(e.print())
    println(e.collect())

  }

}
