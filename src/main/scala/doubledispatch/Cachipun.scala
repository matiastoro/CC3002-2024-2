package doubledispatch

trait Hand {
  // 1 win, 0 draw, -1 loose
  def play(v: Hand): Int
  def playWithStone(stone: Stone): Int
  def playWithPaper(paper: Paper): Int
  def playWithScissor(scissor: Scissor): Int
}
class Stone extends Hand {
  def play(v: Hand): Int = v.playWithStone(this)
  def playWithStone(stone: Stone): Int = 0
  def playWithPaper(paper: Paper): Int = 1
  def playWithScissor(scissor: Scissor): Int = -1
}
class Paper extends Hand {
  def play(v: Hand): Int = v.playWithPaper(this)
  def playWithStone(stone: Stone): Int = -1
  def playWithPaper(paper: Paper): Int = 0
  def playWithScissor(scissor: Scissor): Int = 1
}
class Scissor extends Hand {
  def play(v: Hand): Int = v.playWithScissor(this)
  def playWithStone(stone: Stone): Int = 1
  def playWithPaper(paper: Paper): Int = -1
  def playWithScissor(scissor: Scissor): Int = 0
}
