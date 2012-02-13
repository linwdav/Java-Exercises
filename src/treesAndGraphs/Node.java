package treesAndGraphs;

/**
 * Node for use in a binary tree.
 * @author David Lin
 */
public class Node {

  private Node left;
  private Node right;
  private String data;

  /**
   * Default constructor.
   * @param data to store
   */
  public Node(String data) {
    this.left = null;
    this.right = null;
    this.data = data;
  }

  /**
   * Get left child node.
   * @return left child node
   */
  public Node getLeft() {
    return left;
  }

  /**
   * Get right child node.
   * @return right child node
   */
  public Node getRight() {
    return right;
  }

  /**
   * Get data from node.
   * @return data from node
   */
  public String getData() {
    return data;
  }

  /**
   * Set left child node.
   * @param left child node
   */
  public void setLeft(Node left) {
    this.left = left;
  }

  /**
   * Set right child node.
   * @param right child node
   */
  public void setRight(Node right) {
    this.right = right;
  }

  /**
   * Set data in node.
   * @param data to set
   */
  public void setData(String data) {
    this.data = data;
  }
}
