package arraysAndStrings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Test Anagrams program.
 * @author David Lin
 */
public class TestAnagrams {

  /**
   * JUnit test on Anagrams.
   */
  @Test
  public void testAnagram() {
    Anagrams test = new Anagrams();
    boolean a = test.isAnagram("Hello", "Holel");
    boolean b = test.isAnagram("World", "Worlds");
    boolean c = test.isAnagram("this is a test", "test a is this");
    assertTrue("'Hello' and 'Holel' should have returned true", a);
    assertFalse("'World' and 'Worlds' should have returned false", b);
    assertTrue("'this is a test' and 'test a is this' should have returned true", c);
  }

}