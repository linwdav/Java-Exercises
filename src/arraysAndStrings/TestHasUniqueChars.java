package arraysAndStrings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Test UniqueChars program.
 * @author David Lin
 */
public class TestHasUniqueChars {

  /**
   * JUnit test on UniqueChars.
   */
  @Test
  public void testUniqueChars() {
    HasUniqueChars test = new HasUniqueChars();
    boolean a = test.hasUniqueChars("Hello");
    boolean b = test.hasUniqueChars("World");
    boolean c = test.hasUniqueChars("Lol");
    assertFalse("'Hello' should have returned false", a);
    assertTrue("'World' should have returned true", b);
    assertTrue("'Lol' should have returned true", c);
  }

}