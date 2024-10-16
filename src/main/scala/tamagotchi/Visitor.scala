package tamagotchi

trait Visitor:
  def visit(o: Persona): Unit

class HappyVisitor extends Visitor:
  def visit(o: Persona) = o.updateHappy()

class HungryVisitor extends Visitor:
  def visit(o: Persona) = o.updateHungry()

class SleepyVisitor extends Visitor:
  def visit(o: Persona) = o.updateSleepy()
