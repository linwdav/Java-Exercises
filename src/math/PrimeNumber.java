package math;

/**
 * Find the nth prime number.
 * @author David Lin
 */
public class PrimeNumber {

  /** Constructor. */
  public PrimeNumber() {
    // Empty
  }

  /**
   * Find the nth prime number.
   * @param n the nth prime number
   * @return nth prime number
   */
  public int findNthPrime(int n) {
    int count = 0;
    int i = 0;
    while (count < n) {
      if (isPrime(i)) {
        count++;
      }
      i++;
    }
    i--;
    return i;
  }

  /**
   * Test if a number is prime.
   * @param num Input
   * @return True if prime, false if not prime
   */
  public boolean isPrime(int num) {
    if (num < 2) {
      // Prime numbers cannot be less than 2
      return false;
    }
    if (num == 2) {
      // 2 is a prime number
      return true;
    }
    if (num % 2 == 0) {
      // Even numbers other than 2 are not prime
      return false;
    }

    // Get the square root
    int max = (int) Math.floor(Math.sqrt(num));

    for (int i = 3; i <= max; i = i + 2) {
      double val = (num * 1.0) / (i * 1.0);
      if (Math.abs(val - Math.floor((double) (num) / i)) == 0) {
        // If num divided by i is a whole number, it is not prime
        return false;
      }
    }

    return true;
  }
}