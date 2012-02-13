package treesAndGraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Create binary search tree.
 * @author David Lin
 */
public class BinarySearchTree {

  /** Empty constructor. */
  public BinarySearchTree() {
    // Do nothing
  }

  /**
   * Add a new node to the tree.
   * @param root The root node.
   * @param data The data in the new node to add.
   */
  public void add(Node root, String data) {
    Node node = root;
    Node leaf = root;
    // Recurse down the tree until we reach the leaf node
    while (leaf != null) {
      node = leaf;
      if (data.compareTo(leaf.getData()) <= 0) {
        leaf = leaf.getLeft();
      }
      else {
        leaf = leaf.getRight();
      }
    }
    // Attach a new node with the data
    if (data.compareTo(node.getData()) <= 0) {
      node.setLeft(new Node(data));
    }
    else {
      node.setRight(new Node(data));
    }
  }

  /**
   * Remove a node from the tree with the matching data.
   * @param node The root node.
   * @param value The node with the matching value.
   */
  public void remove(Node node, String value) {
    // Empty tree
    if (node == null) {
      return;
    }
    Node x = node;
    Node y = node;
    boolean match = true;
    // Do binary search and look for a match
    while (value.compareTo(x.getData()) != 0 && match) {
      y = x;
      if (value.compareTo(x.getData()) < 0 && x.getLeft() != null) {
        x = x.getLeft();
      }
      else if (value.compareTo(x.getData()) > 0 && x.getRight() != null) {
        x = x.getRight();
      }
      else {
        // No match
        match = false;
      }
    }

    if (match) {
      // Case 0: Node to be removed is also the root
      if (node.getLeft() == null && node.getRight() == null) {
        return;
      }
      // Case 1: Node to be removed is a leaf but not a root
      else if (x.getLeft() == null && x.getRight() == null) {
        // Remove the leaf from the tree
        if (y.getLeft() == x) {
          y.setLeft(x.getLeft());
        }
        else if (y.getRight() == x) {
          y.setRight(x.getRight());
        }
      }
      // Case 2: Only right subtree exists
      else if (x.getLeft() == null && x.getRight() != null) {
        // Find leftmost child node in right subtree
        x.setData(findLeftmost(x).getData());
      }
      // Case 3: Only left subtree exists
      else if (x.getLeft() != null && x.getRight() == null) {
        // Find rightmost child node in left subtree
        x.setData(findRightmost(x).getData());
      }
      // Case 4: Both subtrees exist
      else {
        // Randomly go left or right
        Random gen = new Random();
        int num = gen.nextInt(2);
        if (num == 0) {
          // Find rightmost child node in left subtree
          x.setData(findRightmost(x).getData());
        }
        else {
          // Find leftmost child node in right subtree
          x.setData(findLeftmost(x).getData());
        }
      }
    }
    else {
      System.out.println("Unable to remove node because it does not exist.");
    }
  }

  /**
   * Remove a percentage of elements randomly from the tree.
   * @param tree The tree itself.
   * @param root The root of the tree.
   */
  public void removeRandom(BinarySearchTree tree, Node root) {
    // Get the elements from the tree in order
    List<Node> array = tree.getInorder(root);
    // Create a new random number generator
    Random random = new Random();
    // Get the number of elements to remove
    int numToRemove = random.nextInt(array.size() + 1);

    System.out.println("Removing " + numToRemove + " elements");

    for (int i = 0; i < numToRemove; i++) {
      // Remove a random element
      int elementPosition = random.nextInt(array.size());
      tree.remove(root, array.get(elementPosition).getData());
      // Update the array to reflect the removal
      array.remove(elementPosition);
    }
  }

  /**
   * Binary search for a node in the tree.
   * @param node The root of the tree.
   * @param value The value of the node to search for.
   * @return The node with the matching value.
   */
  public Node search(Node node, String value) {
    // Base case 1, empty tree or node not found
    if (node == null) {
      System.out.println("Unable to find node because it does not exist.");
    }
    // Base case 2, node found
    else if (value.compareTo(node.getData()) == 0) {
      return node;
    }
    // If value is less than current node, go left
    else if (value.compareTo(node.getData()) < 0) {
      return search(node.getLeft(), value);
    }
    // If value is greater than current node, go right
    else if (value.compareTo(node.getData()) > 0) {
      return search(node.getRight(), value);
    }
    return null;
  }

  /**
   * Replace the node to-be-deleted's value with the value of leftmost node in the right subtree.
   * Then delete this leftmost node.
   * @param node The node to-be-deleted.
   * @return The value of the leftmost node in the right subtree.
   */
  public Node findLeftmost(Node node) {
    Node x = node.getRight();
    Node y = node;
    Node leftmost = null;

    // Keep going left down the tree until we hit the leftmost node
    while (x.getLeft() != null) {
      y = x;
      x = x.getLeft();
    }
    // Save the leftmost node
    leftmost = x;

    // Case 0: The leftmost node is a leaf. Delete it.
    if (x.getRight() == null) {
      if (y.getRight() == x) {
        y.setRight(x.getRight());
      }
      else {
        y.setLeft(x.getLeft());
      }
    }
    // Case 1: The leftmost node has a right subtree. Delete it.
    // Note: It is not possible for the leftmost node to have a left subtree.
    else if (x.getRight() != null) {
      if (y.getRight() == x) {
        y.setRight(x.getRight());
      }
      else {
        y.setLeft(x.getRight());
      }
    }
    return leftmost;
  }

  /**
   * Replace the node to-be-deleted's value with the value of rightmost node in the left subtree.
   * Then delete this rightmost node.
   * @param node The node to-be-deleted.
   * @return The value of the rightmost node in the left subtree.
   */
  public Node findRightmost(Node node) {
    Node x = node.getLeft();
    Node y = node;
    Node rightmost = null;

    // Keep going right down the tree until we hit the rightmost node
    while (x.getRight() != null) {
      y = x;
      x = x.getRight();
    }
    // Save the rightmost node
    rightmost = x;

    // Case 0: The rightmost node is a leaf. Delete it.
    if (x.getLeft() == null) {
      if (y.getLeft() == x) {
        y.setLeft(x.getLeft());
      }
      else {
        y.setRight(x.getRight());
      }
    }
    // Case 1: The rightmost node has a left subtree. Delete it.
    // Note: It is not possible for the rightmost node to have a right subtree.
    else if (x.getLeft() != null) {
      if (y.getLeft() == x) {
        y.setLeft(x.getLeft());
      }
      else {
        y.setRight(x.getLeft());
      }
    }
    return rightmost;
  }

  /**
   * Traverse the tree in preorder.
   * @param node The root of the tree.
   * @return List containing the elements in preorder.
   */
  public List<Node> getPreorder(Node node) {
    return getPreorder(node, new ArrayList<Node>(0));
  }

  /**
   * Traverse the tree in preorder.
   * @param node The root of the tree.
   * @param array Storage for elements.
   * @return List containing the elements in preorder.
   */
  private List<Node> getPreorder(Node node, List<Node> array) {
    if (node != null) {
      array.add(node);
      getPreorder(node.getLeft(), array);
      getPreorder(node.getRight(), array);
    }
    return array;
  }

  /**
   * Traverse the tree in order.
   * @param node The root of the tree.
   * @return List containing the elements in order.
   */
  public List<Node> getInorder(Node node) {
    return getInorder(node, new ArrayList<Node>(0));
  }

  /**
   * Traverse the tree in order.
   * @param node The root of the tree.
   * @param array Storage for elements.
   * @return List containing the elements in order.
   */
  private List<Node> getInorder(Node node, List<Node> array) {
    if (node == null) {
      return array;
    }
    if (node.getLeft() != null) {
      getInorder(node.getLeft(), array);
    }
    array.add(node);
    if (node.getRight() != null) {
      getInorder(node.getRight(), array);
    }
    return array;
  }

  /**
   * Traverse the tree in postorder.
   * @param node The root of the tree.
   * @return List containing the elements in postorder.
   */
  public List<Node> getPostorder(Node node) {
    return getPostorder(node, new ArrayList<Node>(0));
  }

  /**
   * Traverse the tree in postorder.
   * @param node The root of the tree.
   * @param array Storage for elements.
   * @return List containing the elements in postorder.
   */
  private List<Node> getPostorder(Node node, List<Node> array) {
    if (node == null) {
      return array;
    }
    if (node.getLeft() != null) {
      getPostorder(node.getLeft(), array);
    }
    if (node.getRight() != null) {
      getPostorder(node.getRight(), array);
    }
    array.add(node);
    return array;
  }

  /**
   * Get the tree depth.
   * @param node The root of the tree.
   * @return The number of levels in the tree.
   */
  public int getDepth(Node node) {
    if (node == null) {
      return 0;
    }
    int level = 1;
    level += Math.max(getDepth(node.getLeft()), getDepth(node.getRight()));
    return level;
  }

  /**
   * Print the value of the elements in the tree using preorder traversal.
   * @param tree The tree itself.
   * @param root The root of the tree.
   */
  public void printPreorder(BinarySearchTree tree, Node root) {
    // Get and print tree elements in preorder
    List<Node> preorder = tree.getPreorder(root);
    System.out.print("Preorder:\t");
    for (int i = 0; i < preorder.size(); i++) {
      System.out.print(preorder.get(i).getData() + " ");
    }
    System.out.println();
  }

  /**
   * Print the value of the elements in the tree using inorder traversal.
   * @param tree The tree itself.
   * @param root The root of the tree.
   */
  public void printInorder(BinarySearchTree tree, Node root) {
    // Get and print tree elements in order
    List<Node> inorder = tree.getInorder(root);
    System.out.print("Inorder:\t");
    for (int i = 0; i < inorder.size(); i++) {
      System.out.print(inorder.get(i).getData() + " ");
    }
    System.out.println();
  }

  /**
   * Print the value of the elements in the tree using postorder traversal.
   * @param tree The tree itself.
   * @param root The root of the tree.
   */
  public void printPostorder(BinarySearchTree tree, Node root) {
    // Get and print tree elements in postorder
    List<Node> postorder = tree.getPostorder(root);
    System.out.print("Postorder:\t");
    for (int i = 0; i < postorder.size(); i++) {
      System.out.print(postorder.get(i).getData() + " ");
    }
    System.out.println();
  }
}