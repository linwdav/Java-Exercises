package recursion;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test Fibonacci program.
 * @author David Lin
 */
public class TestFibonacci {

  /**
   * JUnit test on Fibonacci.
   */
  @Test
  public void testFibonacci() {
    Fibonacci test = new Fibonacci();
    int a = test.fibonacci(0);
    int b = test.fibonacci(1);
    int c = test.fibonacci(2);
    int d = test.fibonacci(3);
    int e = test.fibonacci(4);
    int f = test.fibonacci(6);
    int g = test.fibonacci(12);

    assertEquals("Fibonacci failed on n=0", 0, a);
    assertEquals("Fibonacci failed on n=1", 1, b);
    assertEquals("Fibonacci failed on n=2", 1, c);
    assertEquals("Fibonacci failed on n=3", 2, d);
    assertEquals("Fibonacci failed on n=4", 3, e);
    assertEquals("Fibonacci failed on n=6", 8, f);
    assertEquals("Fibonacci failed on n=12", 144, g);
  }

}