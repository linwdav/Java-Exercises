package linkedLists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 * Test RemoveDuplicates program.
 * @author David Lin
 */
public class TestRemoveDuplicates {

  /**
   * JUnit test on RemoveDuplicates.
   */
  @Test
  public void testRemoveDuplicates() {

    RemoveDuplicates test = new RemoveDuplicates();
    Node head;
    Node node;
    int counter;

    // Create linked list that looks like 00000
    head = new Node("0");
    for (int i = 1; i < 5; i++) {
      head.insert(new Node("0"));
    }

    // Test that duplicates have been removed and linked list looks like 0
    test.removeDuplicates(head);
    assertNull("Head.next should be null", head.getNext());

    // Add a bunch of 'noise' and make linked list look like 0012301230123
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 4; j++) {
        head.insert(new Node(String.valueOf(j)));
      }
    }

    // Test that duplicates have been removed and linked list looks like 0123
    test.removeDuplicates(head);
    node = head;
    counter = 0;
    while (node != null) {
      assertEquals("Node " + counter + " should not be there", String.valueOf(counter),
          node.getData());
      node = node.getNext();
      counter++;
    }

    // Test that no nodes have been removed because there are no duplicates
    node = head;
    counter = 0;
    while (node != null) {
      assertEquals("Node " + counter + " should not be there", String.valueOf(counter),
          node.getData());
      node = node.getNext();
      counter++;
    }

  }

}