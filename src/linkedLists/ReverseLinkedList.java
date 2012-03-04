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
  public Node reverse(Node head) {
    
    Stack<String> s = new Stack<String>();
    Node temp = head;
    
    // Empty linked list
    if (head == null) {
      return null;
    }
    
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

}