object Test extends App {
  @inline def m = 10

  def g = {
    val f = (x: Int) => x + m
    f(1)
  }

  println(g)
}
