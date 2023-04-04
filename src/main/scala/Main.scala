import java.util.Scanner;
import scala.math._;

object Main extends App {
  var scnr = new Scanner(System.in);

  var circle: Circle = null;
  var rect: Rectangle = null;

  println("Choose a circle and a rectangle, and see if they overlap in 2d space!");

  println("What are the attributes of the circle? {x} {y} {radius}")
  val circleX = scnr.nextInt();
  val circleY = scnr.nextInt();
  val circleRadius = scnr.nextInt();
  circle = new Circle(circleX, circleY, circleRadius);

  // Shape 2

  println("What are the attributes of the rectangle? {x} {y} {width} {height}")

  val rectangleX = scnr.nextInt();
  val rectangleY = scnr.nextInt();
  val rectangleWidth = scnr.nextInt();
  val rectangleHeight = scnr.nextInt();
  rect = new Rectangle(rectangleX, rectangleY, rectangleWidth, rectangleHeight);

  val doIntersect: Boolean = intersects(circle, rect);

  if(doIntersect)
  println("Yes, they do intersect.")
  else
  println("No they do not intersect.")
  

  // Credit: https://stackoverflow.com/questions/401847/circle-rectangle-collision-detection-intersection
  def intersects(circle: Circle, rect: Rectangle): Boolean = {
    val circleDistanceX = (circle.x_val - rect.x_val).abs;
    val circleDistanceY = (circle.y_val - rect.y_val).abs;

    if (circleDistanceX > (rect.width/2 + circle.radius)) { return false; }
    if (circleDistanceY > (rect.height/2 + circle.radius)) { return false; }

    if (circleDistanceX <= (rect.width/2)) { return true; } 
    if (circleDistanceY <= (rect.height/2)) { return true; }

    val cornerDistance_sq = pow((circleDistanceX - rect.width/2), 2) + pow((circleDistanceY - rect.height/2), 2);

    return (cornerDistance_sq <= pow(circle.radius, 2));
  }
  
}




class Shape(var x: Int, var y: Int) {
}

class Circle(var x_val: Int, var y_val: Int, var radius: Int) extends Shape(x_val, y_val) {
}

class Rectangle(var x_val: Int, var y_val: Int, var width: Int, var height: Int) extends Shape(x_val, y_val) {

}