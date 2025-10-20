// Task 12.4.1: main program

fun main() {
    val c = Circle(Point(0.0, 0.0), 5.0)
    val point = Point(4.9, 0.0)
    if (c contains point) {
        println("point in c")
    }

    println("area: ${c.area()}   circumference: ${c.circumference()}")
}
