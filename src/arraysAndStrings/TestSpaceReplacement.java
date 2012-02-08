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
    assertEquals("' HelloWorld' should have returned '%20HelloWorld'", a, "%20HelloWorld");
    assertEquals("'HelloWorld ' should have returned 'HelloWorld%20'", b, "HelloWorld%20");
    assertEquals("'Hello World' should have returned 'Hello%20World'", c, "Hello%20World");
  }

}