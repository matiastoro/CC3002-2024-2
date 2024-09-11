package visibility

class SuchaiTest extends munit.FunSuite {

  test("rotate") {
    val suchai = new Suchai(45.0)
    suchai.doCommand(new Rotate(20.0))
    assertEquals(suchai.getAngle(), 65.0)
  }
  test("take picture") {
    val suchai = new Suchai(0.0)
    suchai.doCommand(new TakePicture())
    suchai.doCommand(new TakePicture())
    suchai.doCommand(new TakePicture())
    assertEquals(suchai.getNumberPictures(), 3)
  }
  test("clean cache") {
    val suchai = new Suchai(0.0)
    suchai.doCommand(new TakePicture())
    suchai.doCommand(new TakePicture())
    suchai.doCommand(new TakePicture())
    assertEquals(suchai.getNumberPictures(), 3)
    suchai.doCommand(new CleanCache())
    assertEquals(suchai.getNumberPictures(), 0)

  }
}
