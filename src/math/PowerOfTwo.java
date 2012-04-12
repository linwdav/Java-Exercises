package math;

/**
 * Given a positive integer, write a method to determine if it is a power of 2.
 * @author David Lin
 */
public class PowerOfTwo {

  /** Constructor. */
  public PowerOfTwo() {
    // Empty
  }
  
  /**
   * Determine if n is a power of 2.
   * @param n input integer
   * @return true if n is a power of 2, otherwise false
   */
  public boolean isPowerOfTwo(int n) {
    int num = n;
    if (num <= 0) {
      // Negative numbers are invalid and 0 is not a power of 2
      return false;
    }
    while (num != 1) {
      if (num % 2 != 0) {
        // Odd numbers are not a power of 2
        return false;
      }
      num /= 2;
    }
    return true;
  }
  
}