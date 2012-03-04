package linkedLists;

import java.util.Stack;

/**
 * Write a method to reverse a linked list.
 * @author David Lin
 */
public class ReverseLinkedList {

  /** Constructor. */
  public ReverseLinkedList() {
    // Empty
  }

  /**
   * Reverse a linked list using a stack.
   * @param head of linked list
   * @return head of reversed linked list
   */
  public Node reverseByStack(Node head) {

    // Empty linked list
    if (head == null) {
      return null;
    }

    Stack<String> s = new Stack<String>();
    Node temp = head;

    // Push all item data into a stack in reverse order
    while (temp != null) {
      s.push(temp.getData());
      temp = temp.getNext();
    }

    // Reverse by popping from stack
    Node node = new Node(s.pop());
    temp = node;
    while (!s.isEmpty()) {
      temp.setNext(new Node(s.pop()));
      temp = temp.getNext();
    }

    return node;
  }

  /**
   * Reverse a linked list using two pointers.
   * @param head of linked list
   * @return head of reversed linked list
   */
  public Node reverseByPointers(Node head) {

    // Empty linked list
    if (head == null) {
      return null;
    }

    // Variables
    int highcount = 1;
    int lowcount = 0;
    Node low = head;
    Node high = head;

    // Get length of linked list by traversing it and set high to last Node
    while (high.getNext() != null) {
      high = high.getNext();
      highcount++;
    }

    while (lowcount < highcount) {
      high = head;
      // Move high pointer to the correct Node
      for (int i = 1; i < highcount; i++) {
        high = high.getNext();
      }
      // Reverse by data
      String temp = low.getData();
      low.setData(high.getData());
      high.setData(temp);
      // Increment low and decrement high
      low = low.getNext();
      lowcount++;
      highcount--;
    }

    return head;
  }

}