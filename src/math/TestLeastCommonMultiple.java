package math;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test LeastCommonMultiple program.
 * @author David Lin
 */
public class TestLeastCommonMultiple {

  /**
   * JUnit test on LeastCommonMultiple.
   */
  @Test
  public void testLeastCommonMultiple() {
    LeastCommonMultiple test = new LeastCommonMultiple();
    int a = test.findLCM(2, 10);
    int b = test.findLCM(3, 7);
    int c = test.findLCM(9, 9);
    int d = test.findLCM(0, 5);
    int e = test.findLCM(78, 80);

    assertEquals("Failure", 10, a);
    assertEquals("Failure", 21, b);
    assertEquals("Failure", 9, c);
    assertEquals("Failure ", 0, d);
    assertEquals("Failure ", 3120, e);
  }

}