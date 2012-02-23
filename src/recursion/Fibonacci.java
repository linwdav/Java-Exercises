package recursion;

/**
 * Write a method to generate the nth Fibonacci number.
 * @author David Lin
 */
public class Fibonacci {

  /** Constructor. */
  public Fibonacci() {
    // Empty
  }

  /**
   * Finds the nth Fibonacci number.
   * @param n The nth number
   * @return The nth number
   * @throws RuntimeException invalid nth Fibonacci number below 0
   */
  public int fibonacci(int n) throws RuntimeException {
    int f0 = 0;
    int f1 = 1;

    if (n < 0) {
      throw new RuntimeException("n must be >= 0 to find Fibonacci number");
    }
    if (n == 0) {
      return f0;
    }
    else if (n == 1) {
      return f1;
    }

    int count = 1;
    return findFibonacci(n, f1, f0, count);
  }

  /**
   * Helper method for finding the Fibonacci number.
   * @param n The nth number
   * @param n1 (count-1)
   * @param n2 (count-2)
   * @param count The count-th Fibonacci number we are currently solving for
   * @return The nth number
   */
  private int findFibonacci(int n, int n1, int n2, int count) {
    int currentCount = count + 1;
    int newNum = n1 + n2;
    if (currentCount == n) {
      return newNum;
    }
    return findFibonacci(n, newNum, n1, currentCount);
  }

}