package treesAndGraphs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Test the BinarySearchTree class.
 * @author David Lin
 */
public class TestBinarySearchTree {

  private int numElements = 10;

  /**
   * JUnit test on BinarySearchTree class.
   */
  @Test
  public void testStackClass() {
    BinarySearchTree tree = new BinarySearchTree();
    List<Node> elementArray = new ArrayList<Node>();

    // Create tree from an arbitrary array of integers 0 to 9
    Node root = makeTree(getInitialData());

    // Test inorder traversal
    elementArray = tree.getInorder(root);
    for (int i = 0; i < numElements; i++) {
      assertEquals("Inorder traversal should have returned " + numElements + " items",
          numElements, elementArray.size());
      assertEquals("Inorder not working right", elementArray.get(i).getData(), String.valueOf(i));
      assertEquals("Tree depth should be 4", 4, tree.getDepth(root));
    }

    // Test preorder traversal
    elementArray = tree.getPreorder(root);
    int[] preorderResults = { 4, 1, 0, 2, 3, 7, 5, 6, 8, 9 };
    for (int i = 0; i < numElements; i++) {
      assertEquals("Preorder traversal should have returned " + numElements + " items",
          numElements, elementArray.size());
      assertEquals("Preorder not working right", elementArray.get(i).getData(),
          String.valueOf(preorderResults[i]));
      assertEquals("Tree depth should be 4", 4, tree.getDepth(root));
    }

    // Test postorder traversal
    elementArray = tree.getPostorder(root);
    int[] postorderResults = { 0, 3, 2, 1, 6, 5, 9, 8, 7, 4 };
    for (int i = 0; i < numElements; i++) {
      assertEquals("Postorder traversal should have returned " + numElements + " items",
          numElements, elementArray.size());
      assertEquals("Postorder not working right", elementArray.get(i).getData(),
          String.valueOf(postorderResults[i]));
      assertEquals("Tree depth should be 4", 4, tree.getDepth(root));
    }

    // Make sure the root node has value 4
    assertSame("Root node should have value 4", root.getData().compareTo("4"), 0);

    // Test remove and search function
    tree.remove(root, "4");
    assertNotSame("Node with value 4 should no longer be root", root.getData().compareTo("4"), 0);
    assertNull("Node with value 4 should not have been found in tree", tree.search(root, "4"));
    assertTrue("New root should have value 3 or 5", root.getData().compareTo("3") == 0
        || root.getData().compareTo("5") == 0);

    // Test add and search function
    tree.add(root, "4");
    assertNotNull("Node with value 4 should have been found in tree", tree.search(root, "4"));

    // Test depth function
    for (int i = 0; i < numElements; i++) {
      tree.remove(root, String.valueOf(i));
    }
    assertSame("Tree depth should be 1 after removing all nodes", tree.getDepth(root), 1);

    // Test remove random function
    root = makeTree(getInitialData());
    tree.removeRandom(tree, root);
    assertTrue("Remove random function not working", tree.getInorder(root).size() <= numElements);

    // Test print functions
    tree.printPreorder(tree, root);
    tree.printInorder(tree, root);
    tree.printPostorder(tree, root);
  }

  /**
   * Preload elements in array with data.
   * @return Array of data
   */
  public String[] getInitialData() {
    int arraySize = numElements;
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
      node.setLeft(makeTree(low, (mid - 1), array));
      node.setRight(makeTree((mid + 1), high, array));
      return node;
    }
  }

}