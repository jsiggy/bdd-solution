package training.tdd.mat.shapes;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CircleTest {
   @Test
   public void shouldReturnZeroForZeroRadius() {
      Shape shape = new Circle(0);

      double area = shape.area();

      assertEquals(0.0, area, 0.0001);
   }

   @Test(expected = IllegalArgumentException.class)
   public void shouldThrowExceptionForNegativeRadius() {
      new Circle(-1);
   }

   @Test
   public void shouldCalculateAreaForPositiveRadius() {
      Shape shape = new Circle(1);

      double area = shape.area();

      assertEquals(3.14, area, 0.01);
   }
}
