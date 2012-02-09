package linkedLists;

/**
 * Write code to remove duplicates from an unsorted linked list. How would you solve this problem if
 * a temporary buffer is not allowed?
 * @author David Lin
 */
public class RemoveDuplicates {

  /** Constructor. */
  public RemoveDuplicates() {
    // Empty
  }

  /**
   * Remove duplicate nodes from a linked list.
   * @param head Head of linked list
   */
  public void removeDuplicates(Node head) {
    Node nodePos = head;
    // First while loop iterates through each unique node in linked list
    while (nodePos.getNext() != null) {
      Node node = nodePos;
      String data = node.getData();
      // Second while loop compares every other node with nodePos
      while (node.getNext() != null) {
        if (node.getNext().getData().compareTo(data) == 0) {
          node.setNext(node.getNext().getNext());
          // Do not advance the node so we can keep comparing
          continue;
        }
        node = node.getNext();
      }
      // Cover the case where the head node is the only one remaining
      if (nodePos.getNext() != null) {
        nodePos = nodePos.getNext();
      }
    }
  }

}