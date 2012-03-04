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
   * JUnit test on ReverseLinkedList::ReverseByStack.
   */
  @Test
  public void testReverseByStack() {

    ReverseLinkedList test = new ReverseLinkedList();

    // Create a linked list
    Node head = new Node("0");
    Node next = head;
    for (int i = 1; i < 10; i++) {
      next.setNext(new Node(String.valueOf(i)));
      next = next.getNext();
    }

    head = test.reverseByStack(head);

    // Check for correct reversal from 0123456789 to 9876543210
    next = head;
    for (int i = 9; i > -1; i--) {
      assertEquals("Linked list reversal failed", String.valueOf(i), next.getData());
      next = next.getNext();
    }

    // Check for null return value in empty linked list
    next = null;
    next = test.reverseByStack(next);
    assertNull("Empty linked list should return null upon reversal", next);

    // Check for case where the only node is the head
    next = new Node("hi");
    next = test.reverseByStack(next);
    assertNull("Linked list reversal failed for 1 node", next.getNext());

  }

  /**
   * JUnit test on ReverseLinkedList::ReverseByPointers.
   */
  @Test
  public void testReverseByPointers() {

    ReverseLinkedList test = new ReverseLinkedList();

    // Create a linked list
    Node head = new Node("0");
    Node next = head;
    for (int i = 1; i < 10; i++) {
      next.setNext(new Node(String.valueOf(i)));
      next = next.getNext();
    }

    head = test.reverseByPointers(head);

    // Check for correct reversal from 0123456789 to 9876543210
    next = head;
    for (int i = 9; i > -1; i--) {
      assertEquals("Linked list reversal failed", String.valueOf(i), next.getData());
      next = next.getNext();
    }

    // Check for null return value in empty linked list
    next = null;
    next = test.reverseByPointers(next);
    assertNull("Empty linked list should return null upon reversal", next);

    // Check for case where the only node is the head
    next = new Node("hi");
    next = test.reverseByPointers(next);
    assertNull("Linked list reversal failed for 1 node", next.getNext());

  }

}