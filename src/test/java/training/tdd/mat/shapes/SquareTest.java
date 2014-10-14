package training.tdd.mat.shapes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquareTest {
   @Test
   public void shouldCalculateArea() {

      assertEquals(16, new Square(4).area(), .001);
   }
}
