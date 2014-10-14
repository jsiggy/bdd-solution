package training.tdd.mat.shapes;

public class Circle implements Shape {

   private final int radius;

   public Circle(int radius) {
      if (radius < 0) throw new IllegalArgumentException("Circle radius cannot be negative");
      this.radius = radius;
   }

   @Override public double area() {
      return Math.PI * radius * radius;
   }
}
