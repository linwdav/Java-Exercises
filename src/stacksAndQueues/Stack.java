package stacksAndQueues;

/**
 * Stack implemented with linked list.
 * @author David Lin
 */
public class Stack {

  private int size;
  private Node top;

  /** Constructor. */
  public Stack() {
    this.size = 0;
    top = null;
  }

  /**
   * Add item to top of stack.
   * @param item Data
   */
  public void push(String item) {
    Node oldTop = top;
    top = new Node(item);
    top.setNext(oldTop);
    size++;
  }

  /**
   * Remove item from top of stack.
   * @return Popped item
   * @throws RuntimeException when popping from empty stack
   */
  public Node pop() throws RuntimeException {
    if (this.isEmpty()) {
      throw new RuntimeException("Cannot pop from empty stack");
    }
    Node oldTop = top;
    top = top.getNext();
    size--;
    return oldTop;
  }

  /**
   * Return item from top of stack without removing it.
   * @return Item at top of stack
   * @throws RuntimeException when peeking from empty stack
   */
  public Node peek() throws RuntimeException {
    if (this.isEmpty()) {
      throw new RuntimeException("Cannot pop from empty stack");
    }
    return top;
  }

  /**
   * Get size of stack.
   * @return Size of stack
   */
  public int size() {
    return size;
  }

  /**
   * Check if stack is empty.
   * @return True if empty, false if not empty
   */
  public boolean isEmpty() {
    return (top == null);
  }

}
