package math;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test PrimeNumber program.
 * @author David Lin
 */
public class TestPrimeNumber {

  /**
   * JUnit test on PrimeNumber.
   */
  @Test
  public void testPrimeNumber() {
    PrimeNumber test = new PrimeNumber();
    int a = test.findNthPrime(1);
    int b = test.findNthPrime(2);
    int c = test.findNthPrime(3);
    int d = test.findNthPrime(10);
    int e = test.findNthPrime(100);
    int f = test.findNthPrime(168);

    assertEquals("Incorrect prime ", 2, a);
    assertEquals("Incorrect prime ", 3, b);
    assertEquals("Incorrect prime ", 5, c);
    assertEquals("Incorrect prime", 29, d);
    assertEquals("Incorrect prime", 541, e);
    assertEquals("Incorrect prime", 997, f);
  }

}