import kotlin.math.PI

// Task 12.4.1: Circle class
class Circle(val centre: Point, val radius: Double) {
    init {
        require(radius > 0) { "Radius must be greater than 0" }
    }

    fun area() = radius * PI * PI

    fun circumference() = 2 * PI * radius

    infix fun contains(point: Point) = if(centre.distanceTo(point) <= radius) true else false
}
