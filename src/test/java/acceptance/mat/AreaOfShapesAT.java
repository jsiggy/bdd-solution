package acceptance.mat;

import acceptance.util.JBehaveStoryRunner;
import training.tdd.mat.Board;
import training.tdd.mat.shapes.Circle;
import training.tdd.mat.shapes.Shape;
import training.tdd.mat.shapes.Square;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static junit.framework.Assert.assertEquals;

public class AreaOfShapesAT extends JBehaveStoryRunner {

   private Board board;
   private Shape shapeToRemove;

   @Given("an empty board")
   public void emptyMat() {
      System.out.println("an empty board: ");
      board = new Board();
   }

   @Given("a board with a circle with radius $radius and two squares of length $square1 and $square2")
   public void emptyMat(int radius, int square1, int square2) {
      System.out.println("an empty board: ");
      shapeToRemove = new Circle(radius);
      board = new Board();
      board.add(shapeToRemove);
      board.add(new Square(square1));
      board.add(new Square(square2));
   }

   @When("no shapes are added")
   public void noShapesAreAdded() {
      System.out.println("no shapes are added: ");
   }

   @When("a square with a side of length $width is added")
   public void addSquareWithLength(int width) {
      System.out.println("a square with a width of length " + width + " is added: ");
      board.add(new Square(width));
   }

   @When("a circle with a radius of length $radius is added")
   public void addCircleWithRadius(int radius) {
      System.out.println("a circle with a side of length " + radius + " is added: ");
      board.add(new Circle(radius));
   }

   @When("the circle is removed")
   public void removeCircle() {
      System.out.println("removing circle");
      board.remove(shapeToRemove);
   }

   @Then("the area of shapes on the board is $total")
   public void assertAreaOfAllShapesOnMatIs(float total) {
      System.out.println("the area of shapes on the board is " + total);
      assertEquals(total, board.calculateCoveredArea(), 0.01);
   }
}
