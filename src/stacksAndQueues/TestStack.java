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
    assertEquals("Stack size should be one", 1, stack.size());
    assertEquals("Wrong value for top stack element", "a", stack.peek().getData());
    assertEquals("Wrong value for top stack element", "a", stack.pop().getData());
    assertTrue("Stack should be empty", stack.isEmpty());
    assertEquals("Stack size should be zero", 0, stack.size());

    for (int i = 0; i < 10; i++) {
      stack.push(String.valueOf(i));
    }
    assertEquals("Stack size should be ten", 10, stack.size());

    for (int i = 9; i < -1; i--) {
      assertEquals("Wrong value for top stack element", String.valueOf(i), stack.pop().getData());
    }
  }

}