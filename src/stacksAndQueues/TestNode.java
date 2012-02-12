package stacksAndQueues;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test the Node class.
 * @author David Lin
 */
public class TestNode {

  /**
   * JUnit test on the Node class.
   */
  @Test
  public void testNodeClass() {
    
    Node head;
    Node node;
    
    // Create linked list
    head = new Node("0");
    for (int i = 1; i < 5; i++) {
      head.insert(new Node(String.valueOf(i)));
    }

    // Test that 5 nodes have been added to the linked list
    node = head;
    for (int i = 0; i < 5; i++) {
      assertEquals("Error with node #" + i, node.getData(), String.valueOf(i));
      node = node.getNext();
    }
    
    // Delete the head and tail of the linked list
    head = head.delete(head, "0");
    head = head.delete(head, "4");
    
    // Test that the head and tail were deleted
    node = head;
    for (int i = 1; i < 4; i++) {
      assertEquals("Error with node #" + i, node.getData(), String.valueOf(i));
      node = node.getNext();
    }
    
    // Delete the node with value of 2
    head = head.delete(head, "2");
    
    // Test that the node with value 2 has been deleted
    node = head;
    assertEquals("Error deleting node with value 2", node.getNext().getData(), "3");
    
    // Test Node.setData
    node.setData("123");
    assertEquals("Set data did not work properly", node.getData(), "123");

  }

}