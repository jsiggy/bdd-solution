package training.tdd.mat;

import training.tdd.mat.shapes.Circle;
import training.tdd.mat.shapes.Square;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BoardTest {

   @Test
   public void shouldInitializeWithoutAnyItemsOnMat() {
      Board board = new Board();

      int shapes = board.size();

      assertEquals(0, shapes);
   }

   @Test
   public void shouldInsertAnItemAddedOnTheMat() {
      Board mat = new Board();
      mat.add(new Circle(0));

      int shapes = mat.size();

      assertEquals(1, shapes);
   }

   @Test
   public void shouldInsertMultipleItemsOnTheMat() {
      Board mat = new Board();
      mat.add(new Circle(0));
      mat.add(new Circle(2));

      int shapes = mat.size();

      assertEquals(2, shapes);
   }

   @Test
   public void shouldRemoveAGivenItemFromTheMat() {
      Board mat = new Board();
      Circle circleToRemove = new Circle(0);
      mat.add(circleToRemove);

      mat.remove(circleToRemove);

      int shapes = mat.size();
      assertEquals(0, shapes);
   }

   @Test
   public void shouldFailSilentlyWhenAskedToRemoveAnItemThatDoesNotExist() {
      Board mat = new Board();
      mat.add(new Square(1));
      mat.remove(new Circle(10));

      int shapes = mat.size();

      assertEquals(1, shapes);
   }

   @Test
   public void shouldReturnZeroAreaWhenThereAreNoObjectsOnTheMat() {
      Board mat = new Board();

      double coveredArea = mat.calculateCoveredArea();

      assertEquals(0.0, coveredArea, 0.1);
   }

   @Test
   public void shouldReturnTheAreaOfAnObjectWhenThatObjectIsTheOnlyShapeOnMat() {
      Circle circle = new Circle(4);
      Board mat = new Board();
      mat.add(circle);

      double coveredArea = mat.calculateCoveredArea();

      assertEquals(circle.area(), coveredArea, 0.01);
   }

   @Test
   public void shouldReturnTheSumOfTheAreasOfAllObjectsThatAreOnTheMat() {
      Circle circle1 = new Circle(4);
      Circle circle2 = new Circle(1);
      Square square = new Square(5);
      Board mat = new Board();
      mat.add(circle1);
      mat.add(circle2);
      mat.add(square);

      double coveredArea = mat.calculateCoveredArea();

      assertEquals(circle1.area() + circle2.area() + square.area(), coveredArea, 0.01);
   }
}
