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
   * Node for use in a binary tree.
   */
  private static class Node {
    Node left = null;
    Node right = null;
    String data = "";

    /**
     * Default constructor.
     * @param data to store
     */
    public Node(String data) {
      this.data = data;
    }
  }

  /**
   * Main method to test the program.
   * @param args none
   */
  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
    // Create tree from an arbitrary array
    Node root = tree.makeTree(tree.getInitialData());

    // Remove an element
    tree.remove(root, "4");

    // Add an element
    tree.add(root, "4");

    /*
     * // Search for an element Node node = tree.search(root, "7"); if (node != null) {
     * System.out.println("Node with value " + node.data + ": Found\n"); } // Get tree depth int
     * depth = tree.getDepth(root); System.out.println("Tree depth: " + depth); // Print the tree
     * tree.printPreorder(tree, root); tree.printInorder(tree, root); tree.printPostorder(tree,
     * root); // Remove a random number of elements from the tree System.out.println();
     * tree.removeRandom(tree, root); System.out.println(); // Get tree depth depth =
     * tree.getDepth(root); System.out.println("Tree depth: " + depth);
     */

    // Print the tree
    tree.printPreorder(tree, root);
    tree.printInorder(tree, root);
    tree.printPostorder(tree, root);
  }

  /**
   * Preload elements in array with data.
   * @return Array of data
   */
  public String[] getInitialData() {
    int arraySize = 10;
    String[] array = new String[arraySize];
    for (int i = 0; i < arraySize; i++) {
      array[i] = String.valueOf(i);
    }
    return array;
  }

  /**
   * Create binary search tree.
   * @param array of elements
   * @return The root of the tree.
   */
  public Node makeTree(String[] array) {
    int low = 0;
    int high = array.length - 1;
    return makeTree(low, high, array);
  }

  /**
   * Create binary search tree.
   * @param low The lowest array position.
   * @param high The highest array position.
   * @param array of elements
   * @return The root of the tree.
   */
  private Node makeTree(int low, int high, String[] array) {
    if (low > high) {
      return null;
    }
    else {
      // Same as (low + high) / 2
      int mid = (low + high) >>> 1;
      Node node = new Node(array[mid]);
      node.left = makeTree(low, (mid - 1), array);
      node.right = makeTree((mid + 1), high, array);
      return node;
    }
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
      if (data.compareTo(leaf.data) <= 0) {
        leaf = leaf.left;
      }
      else {
        leaf = leaf.right;
      }
    }
    // Attach a new node with the data
    if (data.compareTo(node.data) <= 0) {
      node.left = new Node(data);
    }
    else {
      node.right = new Node(data);
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
    while (value.compareTo(x.data) != 0 && match) {
      y = x;
      if (value.compareTo(x.data) < 0 && x.left != null) {
        x = x.left;
      }
      else if (value.compareTo(x.data) > 0 && x.right != null) {
        x = x.right;
      }
      else {
        // No match
        match = false;
      }
    }

    if (match) {
      // Case 0: Node to be removed is also the root
      if (node.left == null && node.right == null) {
        return;
      }
      // Case 1: Node to be removed is a leaf but not a root
      else if (x.left == null && x.right == null) {
        // Remove the leaf from the tree
        if (y.left == x) {
          y.left = x.left;
        }
        else if (y.right == x) {
          y.right = x.right;
        }
      }
      // Case 2: Only right subtree exists
      else if (x.left == null && x.right != null) {
        // Find leftmost child node in right subtree
        x.data = findLeftmost(x).data;
      }
      // Case 3: Only left subtree exists
      else if (x.left != null && x.right == null) {
        // Find rightmost child node in left subtree
        x.data = findRightmost(x).data;
      }
      // Case 4: Both subtrees exist
      else {
        // Randomly go left or right
        Random gen = new Random();
        int num = gen.nextInt(2);
        if (num == 0) {
          // Find rightmost child node in left subtree
          x.data = findRightmost(x).data;
        }
        else {
          // Find leftmost child node in right subtree
          x.data = findLeftmost(x).data;
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
      tree.remove(root, array.get(elementPosition).data);
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
    else if (value.compareTo(node.data) == 0) {
      return node;
    }
    // If value is less than current node, go left
    else if (value.compareTo(node.data) < 0) {
      return search(node.left, value);
    }
    // If value is greater than current node, go right
    else if (value.compareTo(node.data) > 0) {
      return search(node.right, value);
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
    Node x = node.right;
    Node y = node;
    Node leftmost = null;

    // Keep going left down the tree until we hit the leftmost node
    while (x.left != null) {
      y = x;
      x = x.left;
    }
    // Save the leftmost node
    leftmost = x;

    // Case 0: The leftmost node is a leaf. Delete it.
    if (x.right == null) {
      if (y.right == x) {
        y.right = x.right;
      }
      else {
        y.left = x.left;
      }
    }
    // Case 1: The leftmost node has a right subtree. Delete it.
    // Note: It is not possible for the leftmost node to have a left subtree.
    else if (x.right != null) {
      if (y.right == x) {
        y.right = x.right;
      }
      else {
        y.left = x.right;
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
    Node x = node.left;
    Node y = node;
    Node rightmost = null;

    // Keep going right down the tree until we hit the rightmost node
    while (x.right != null) {
      y = x;
      x = x.right;
    }
    // Save the rightmost node
    rightmost = x;

    // Case 0: The rightmost node is a leaf. Delete it.
    if (x.left == null) {
      if (y.left == x) {
        y.left = x.left;
      }
      else {
        y.right = x.right;
      }
    }
    // Case 1: The rightmost node has a left subtree. Delete it.
    // Note: It is not possible for the rightmost node to have a right subtree.
    else if (x.left != null) {
      if (y.left == x) {
        y.left = x.left;
      }
      else {
        y.right = x.left;
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
      getPreorder(node.left, array);
      getPreorder(node.right, array);
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
    if (node.left != null) {
      getInorder(node.left, array);
    }
    array.add(node);
    if (node.right != null) {
      getInorder(node.right, array);
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
    if (node.left != null) {
      getPostorder(node.left, array);
    }
    if (node.right != null) {
      getPostorder(node.right, array);
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
    level += Math.max(getDepth(node.left), getDepth(node.right));
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
      System.out.print(preorder.get(i).data + " ");
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
      System.out.print(inorder.get(i).data + " ");
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
      System.out.print(postorder.get(i).data + " ");
    }
    System.out.println();
  }
}