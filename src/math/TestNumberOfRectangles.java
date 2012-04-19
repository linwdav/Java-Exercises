package math;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test NumberOfRectangles program.
 * @author David Lin
 */
public class TestNumberOfRectangles {

  /**
   * JUnit test on NumberOfRectangles.
   */
  @Test
  public void testNumberOfRectangles() {
    assertEquals("A board of size 4x3 can have 60 rectangles", 60,
        NumberOfRectangles.findNumRectangles(4, 3));
    assertEquals("A board of size 8x8 can have 1296 rectangles", 1296,
        NumberOfRectangles.findNumRectangles(8, 8));
    assertEquals("A board of size 0x1 can have 0 rectangles", 0,
        NumberOfRectangles.findNumRectangles(0, 1));
    assertEquals("A board of size -1x-1 can have 0 rectangles", 0,
        NumberOfRectangles.findNumRectangles(-1, -1));
    assertEquals("A board of size 1x1 can have 1 rectangle", 1,
        NumberOfRectangles.findNumRectangles(1, 1));
    assertEquals("A board of size 1x5 can have 15 rectangles", 15,
        NumberOfRectangles.findNumRectangles(1, 5));
  }
}
