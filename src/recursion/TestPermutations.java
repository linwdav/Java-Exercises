package recursion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Test Permutations program.
 * @author David Lin
 */
public class TestPermutations {

  /** Permutations of 'a'. */
  private enum A {
    a
  }

  /** Permutations of 'b'. */
  private enum AB {
    ab, ba
  }

  /** Permutations of 'c'. */
  private enum ABC {
    abc, acb, bac, bca, cab, cba
  }

  /** Permutations of 'd'. */
  private enum ABCD {
    abcd, abdc, acbd, acdb, adbc, adcb, bacd, badc, bcad, bcda, bdac, bdca, cabd, cadb, cbad,
    cbda, cdab, cdba, dabc, dacb, dbac, dbca, dcab, dcba
  }

  /**
   * JUnit test on Permutations.
   */
  @Test
  public void testFibonacci() {
    Permutations test = new Permutations();
    List<String> list = new ArrayList<String>();

    // Test "abcd"
    list = test.permutations("abcd");
    assertEquals("'abcd' should have returned 24 permutations", 24, list.size());
    for (String word : list) {
      try {
        ABCD.valueOf(word);
      }
      catch (IllegalArgumentException ex) {
        fail("The permutation " + word + " is not valid");
      }
    }

    // Test "abc"
    list = test.permutations("abc");
    assertEquals("'abc' should have returned 6 permutations", 6, list.size());
    for (String word : list) {
      try {
        ABC.valueOf(word);
      }
      catch (IllegalArgumentException ex) {
        fail("The permutation " + word + " is not valid");
      }
    }

    // Test "ab"
    list = test.permutations("ab");
    assertEquals("'ab' should have returned 2 permutations", 2, list.size());
    for (String word : list) {
      try {
        AB.valueOf(word);
      }
      catch (IllegalArgumentException ex) {
        fail("The permutation  " + word + "  is not valid");
      }
    }

    // Test "a"
    list = test.permutations("a");
    assertEquals("'a' should have returned 1 permutation", 1, list.size());
    for (String word : list) {
      try {
        A.valueOf(word);
      }
      catch (IllegalArgumentException ex) {
        fail("The permutation " + word + " is not valid");
      }
    }

    // Test ""
    list = test.permutations("");
    assertEquals("'' should have returned 0 permutations", 0, list.size());

    // Test for 362880 permutations of a string with length 9
    list = test.permutations("abcdefghi");
    assertEquals("'abcdefgh' should have returned 362880 permutations", 362880, list.size());
  }

}