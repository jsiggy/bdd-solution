package training.tdd.mat.shapes;

public class Square implements Shape {
   private final int side;

   public Square(int side) {
      this.side = side;
   }

   @Override public double area() {
      return side * side;
   }
}
