package classesinterfaces

class BinaryTreeTest extends munit.FunSuite {
  val ne1: Nodo = new NodoExterno(10)
  val ni1: Nodo =
    new NodoInterno(15, ne1, new NodoExterno(20))
  test("equals Nodo externo") {
    val ne2: Nodo = new NodoExterno(10) // Nodo externo
    assertEquals(ne1, ne2)
  }
  test("equals Nodo interno") {
    val ni2: Nodo =
      new NodoInterno(15, ne1, new NodoExterno(20)) // Nodo interno
    assertEquals(ni1, ni2)
  }
  test("suma") {
    assertEquals(ni1.sum(), 45)
  }
  test("min") {
    assertEquals(ni1.min(), 10)
  }
  test("max") {
    assertEquals(ni1.max(), 20)
  }

  test("sum arbol desbalanceado") {
    val n = new NodoInterno(10, new NodoExterno(8), new NodoVacio)
    assertEquals(n.sum(), 18)
  }

}
