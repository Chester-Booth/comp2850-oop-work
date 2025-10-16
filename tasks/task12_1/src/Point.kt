import kotlin.math.hypot

class Point(var x: Double, var y: Double) {
    fun distance() = hypot(x, y)

    fun distanceTo(p: Point) = hypot((x - p.x), (y - p.y))
}

fun main() {
    println("enter x coord:")
    val inputX = readln().toDouble()
    println("enter y coord:")
    val inputY = readln().toDouble()
    val p = Point(inputX, inputY)
    println("Dist from  origin is ${p.distance()}")
    println("Dist from  4.5,7 is ${p.distanceTo(Point(4.5,7.0))}")
}
