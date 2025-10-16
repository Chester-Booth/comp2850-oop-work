from math import hypot  

class Point: pass # avoid error on line 13

class Point:
    def __init__(self, x: float, y: float):
        self.x = x
        self.y = y

    def distance(self) -> float:
        return hypot(self.x, self.y)

    def distanceTo(self, p: Point) -> float:
        return hypot((self.x - p.x), (self.y - p.y))



def main(): 
    print("enter x coord:")
    inputX = float(input())
    print("enter y coord:")
    inputY = float(input())
    p = Point(inputX, inputY)
    print(f"Dist from  origin is {p.distance()}")
    print(f"Dist from  4.5,7 is {p.distanceTo(Point(4.5,7.0))}")



if __name__ == "__main__":
    main()
    