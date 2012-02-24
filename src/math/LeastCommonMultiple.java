package math;

/**
 * Given two numbers m and n, write a method to return the first number r that is divisible by both.
 * @author David Lin
 */
public class LeastCommonMultiple {

  /** Constructor. */
  public LeastCommonMultiple() {
    // Empty
  }

  /**
   * Find the least common multiple of two numbers.
   * @param m First number
   * @param n Second number
   * @return Least common multiple
   */
  public int findLCM(int m, int n) {
    if (m == 0 || n == 0) {
      return 0;
    }
    if (m % n == 0) {
      return m;
    }
    if (n % m == 0) {
      return n;
    }
    
    int a = m;
    int b = n;
    while (a != b) {
      if (a < b) {
        a = a + m;
      }
      else if (a > b) {
        b = b + n;
      }
    }
    return a;
  }

}