package arraysAndStrings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Test UniqueChars program.
 * @author David Lin
 */
public class TestUniqueChars {

  /**
   * JUnit test on UniqueChars.
   */
  @Test
  public void testUniqueChars() {
    UniqueChars test = new UniqueChars();
    boolean a = test.hasUniqueChars("Hello");
    boolean b = test.hasUniqueChars("World");
    boolean c = test.hasUniqueChars("Lol");
    assertFalse("'Hello' should have returned false", a);
    assertTrue("'World' should have returned true", b);
    assertTrue("'Lol' should have returned true", c);
  }

}