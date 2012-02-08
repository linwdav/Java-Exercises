package arraysAndStrings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Test UniqueChars program.
 * @author David Lin
 */
public class TestSubstring {

  /**
   * JUnit test on UniqueChars.
   */
  @Test
  public void testSubstring() {
    Substring test = new Substring();
    boolean a = test.isSubstring("Hello", "Helo");
    boolean b = test.isSubstring("Hello World", "Hello");
    boolean c = test.isSubstring("Hello", "HelloWorld");
    assertFalse("'Hello' and 'ello' should have returned false", a);
    assertTrue("'Hello World' and 'Hello' should have returned true", b);
    assertTrue("'Hello' and 'Helo' should have returned true", c);
  }

}