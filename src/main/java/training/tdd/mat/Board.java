package training.tdd.mat;

import training.tdd.mat.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class Board {
   private List<Shape> shapes = new ArrayList<Shape>();

   public double calculateCoveredArea() {
      double totalArea = 0.0;
      for (Shape shape : shapes) {
         totalArea += shape.area();
      }
      return totalArea;
   }

   public void add(Shape shape) {
      shapes.add(shape);
   }

   public void remove(Shape shape) {
      shapes.remove(shape);
   }

   public int size() {
      return shapes.size();
   }
}
