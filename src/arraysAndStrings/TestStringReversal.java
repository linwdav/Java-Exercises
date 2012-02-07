package arraysAndStrings;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test StringReversal program.
 * @author David Lin
 */
public class TestStringReversal {

  /**
   * JUnit test on StringReversal.
   */
  @Test
  public void testStringReversal() {
    StringReversal test = new StringReversal();
    String a = test.reverseString("Hello");
    String b = test.reverseString("World");
    String c = test.reverseString("Lol");
    assertEquals("'Hello' should have returned 'olleH'", a, "olleH");
    assertEquals("'World' should have returned 'dlroW'", b, "dlroW");
    assertEquals("'Lol' should have returned 'loL'", c, "loL");
  }

}
