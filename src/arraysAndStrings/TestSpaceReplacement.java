package arraysAndStrings;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test SpaceReplacement program.
 * @author David Lin
 */
public class TestSpaceReplacement {

  /**
   * JUnit test on SpaceReplacement.
   */
  @Test
  public void testSpaceReplacement() {
    SpaceReplacement test = new SpaceReplacement();
    String a = test.replaceSpaces(" HelloWorld");
    String b = test.replaceSpaces("HelloWorld ");
    String c = test.replaceSpaces("Hello World");
    assertEquals("' HelloWorld' should have returned '%20HelloWorld'", "%20HelloWorld", a);
    assertEquals("'HelloWorld ' should have returned 'HelloWorld%20'", "HelloWorld%20", b);
    assertEquals("'Hello World' should have returned 'Hello%20World'", "Hello%20World", c);
  }

}