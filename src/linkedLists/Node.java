package linkedLists;

/**
 * Node that can be used in linked list.
 * @author David Lin
 */
public class Node {

  private String data;
  private Node next;

  /**
   * Constructor.
   * @param data Data in node
   */
  public Node(String data) {
    this.data = data;
    next = null;
  }

  /**
   * Insert node to end of linked list.
   * @param endNode Node to be added
   */
  public void insert(Node endNode) {
    Node node = this;
    while (node.next != null) {
      node = node.next;
    }
    node.next = endNode;
  }

  /**
   * Delete node from linked list.
   * @param head Head of linked list
   * @param data Delete node with matching data
   * @return Node Head of linked list
   */
  public Node delete(Node head, String data) {
    Node node = head;
    if (node.data.compareTo(data) == 0) {
      return head.next;
    }
    while (node.next != null) {
      if (node.next.data.compareTo(data) == 0) {
        node.next = node.next.next;
        return head;
      }
      node = node.next;
    }
    return null;
  }

  /**
   * Get the node's data.
   * @return Node's data
   */
  public String getData() {
    return data;
  }

  /**
   * Set the node's data.
   * @param data The data to set
   */
  public void setData(String data) {
    this.data = data;
  }

  /**
   * Get the next node.
   * @return Next node.
   */
  public Node getNext() {
    return next;
  }

  /**
   * Set the next node.
   * @param next The next node
   */
  public void setNext(Node next) {
    this.next = next;
  }

}
