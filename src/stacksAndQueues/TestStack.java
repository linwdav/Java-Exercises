package stacksAndQueues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Test the Stack class.
 * @author David Lin
 */
public class TestStack {

  /**
   * JUnit test on the Stack class.
   */
  @Test
  public void testStackClass() {

    Stack stack = new Stack();
    stack.push("a");
    assertFalse("Stack should not be empty", stack.isEmpty());
    assertEquals("Stack size should be one", stack.size(), 1);
    assertEquals("Wrong value for top stack element", stack.peek().getData(), "a");
    assertEquals("Wrong value for top stack element", stack.pop().getData(), "a");
    assertTrue("Stack should be empty", stack.isEmpty());
    assertEquals("Stack size should be zero", stack.size(), 0);

    for (int i = 0; i < 10; i++) {
      stack.push(String.valueOf(i));
    }
    assertEquals("Stack size should be ten", stack.size(), 10);

    for (int i = 9; i < -1; i--) {
      assertEquals("Wrong value for top stack element", stack.pop().getData(), String.valueOf(i));
    }
  }

}