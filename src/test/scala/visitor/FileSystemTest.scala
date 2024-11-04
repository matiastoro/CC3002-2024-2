package visitor

import munit.FunSuite

class FileSystemTest extends FunSuite {
  private var emptyFs: FileSystem = null
  private var fs: FileSystem = null
  private var d1: Directory = null
  private var d2: Directory = null

  override def beforeEach(context: BeforeEach): Unit = {
    emptyFs = new FileSystem()
    d1 = new Directory("d1")
    d2 = new Directory("d2")
    d1.add(d2)
    d1.add(new TextFile("file.txt", "hello world!"))
    val c = Array[Byte]('1', 'c')
    d1.add(new BinaryFile("file.bin", c))
    fs = new FileSystem()
    fs.add(d1)
  }

  test("testGetSize") {
    assertEquals(0, emptyFs.getSize())
    assertEquals(14, fs.getSize())
  }

  test("testGetNumberOfFile") {
    assertEquals(0, emptyFs.getNumberOfFiles())
    assertEquals(2, fs.getNumberOfFiles())
    val aFile = new TextFile("tmp.txt", "a file system example")
    val d = new Directory("another directory")
    d.add(aFile)
    fs.add(d)
    assertEquals(3, fs.getNumberOfFiles())
  }

  test("testGetNumberOfDirectory") {
    assertEquals(1, emptyFs.getNumberOfDirectories())
    assertEquals(3, fs.getNumberOfDirectories())
    val aFile = new TextFile("tmp.txt", "a file system example")
    val d = new Directory("another directory")
    d.add(aFile)
    fs.add(d)
    assertEquals(4, fs.getNumberOfDirectories())
  }

  test("testListing") {
    var result = "root\n"
    assertEquals(emptyFs.listing(), result)
    result = "root\nd1\nd2\nfile.txt\nfile.bin\n"
    print(fs.listing())
    assertEquals(fs.listing(), result)
  }

}
