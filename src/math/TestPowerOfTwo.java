package math;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Test PowerOfTwo program.
 * @author David Lin
 */
public class TestPowerOfTwo {

  /**
   * JUnit test on PowerOfTwo.
   */
  @Test
  public void testPowerOfTwo() {
    PowerOfTwo test = new PowerOfTwo();
    assertFalse("0 is not a power of 2", test.isPowerOfTwo(0));
    assertTrue("1 is a power of 2", test.isPowerOfTwo(1));
    assertTrue("2 is a power of 2", test.isPowerOfTwo(2));
    assertFalse("3 is not a power of 2", test.isPowerOfTwo(3));
    assertTrue("4 is a power of 2", test.isPowerOfTwo(4));
    assertTrue("8 is a power of 2", test.isPowerOfTwo(8));
    assertFalse("14 is not a power of 2", test.isPowerOfTwo(14));
    assertFalse("1073741820 is not a power of 2", test.isPowerOfTwo(1073741820));
    assertTrue("1073741824 is a power of 2", test.isPowerOfTwo(1073741824));
  }

}