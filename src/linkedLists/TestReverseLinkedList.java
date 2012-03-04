package linkedLists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 * Test ReverseLinkedList program.
 * @author David Lin
 */
public class TestReverseLinkedList {

  /**
   * JUnit test on ReverseLinkedList.
   */
  @Test
  public void testReverseLinkedList() {
    
    ReverseLinkedList test = new ReverseLinkedList();
    
    // Create a linked list
    Node head = new Node("0");
    Node next = head;
    for (int i = 1; i < 10; i++) {
      next.setNext(new Node(String.valueOf(i)));
      next = next.getNext();
    }
    
    head = test.reverse(head);
    
    // Check for correct reversal from 0123456789 to 9876543210
    next = head;
    for (int i = 9; i > -1; i--) {
      assertEquals("Linked list reversal failed", String.valueOf(i), next.getData());
      next = next.getNext();
    }
    
    // Check for null return value in empty linked list
    next = null;
    next = test.reverse(next);
    assertNull("Empty linked list should return null upon reversal", next);
    
    // Check for case where the only node is the head
    next = new Node("hi");
    next = test.reverse(next);
    assertNull("Linked list reversal failed for 1 node", next.getNext());
    
  }

}