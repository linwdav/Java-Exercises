package arraysAndStrings;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test DuplicateCharRemoval program.
 * @author David Lin
 */
public class TestDuplicateCharRemoval {

  /**
   * JUnit test on DuplicateCharRemoval.
   */
  @Test
  public void testDuplicateCharRemoval() {
    DuplicateCharRemoval test = new DuplicateCharRemoval();
    String a = test.removeDuplicates("Hello");
    String b = test.removeDuplicates("World");
    String c = test.removeDuplicates("abcabcdefg");
    assertEquals("'Hello' should have returned 'Helo'", "Helo", a);
    assertEquals("'World' should have returned 'World'", "World", b);
    assertEquals("'abcabcdefgc' should have returned 'abcdefg'", "abcdefg", c);
  }

}