package exercisesc2

object Ejercicio1 {
  def groupBy[V, K](s: Seq[V], f: V => K): Map[K, Seq[V]] = {
    s.foldLeft(Map[K, Seq[V]]())((acc, e) => {
      val key: K = f(e)
      val newValue: Seq[V] = acc.getOrElse(key, Seq()) :+ e
      acc + (key -> newValue)
    })
  }
  def mapWithFilter[A, B](s: Seq[Option[A]], f: A => B): Seq[Some[B]] = {
    // s.filter(_.isDefined).map(_.map(f))
    s.collect({ case Some(v) =>
      Some(f(v))
    })
  }

  def mapWithOrNone[A](s: Seq[A], f: (A, A) => Int): Option[A] = {
    s.foldLeft(Option.empty[A])((acc, e) =>
      acc match {
        case Some(v) => if (f(v, e) > 0) Some(v) else Some(e)
        case None    => Some(e)
      }
    )
  }
}
