package setsAndHashMaps;

/**
 * Hashtable implementation backed by AVL tree.
 * Runtime complexity: best case O(1) for all operations with no collisions, worst case O(log n)
 * Space complexity: O(n)
 * @author David Lin
 */
public class HashTable {
  
  private AvlTree[] table = null;
  
  public HashTable(int size) {
    table = new AvlTree[size];
  }
  
  public void insert(String key, Object value) {
    
  }
  
  public boolean delete(String key) {
    return false;
  }
  
  public Object get(String key) {
    return null;
  }
}

class AvlTree {
  
  private Node root;
  
  public AvlTree(Object rootData) {
    root = new Node(rootData);
  }
  
  public void insert(String key, Object value) {
    
  }
  
  public boolean delete(String key) {
    return false;
  }
  
  public Object get(String key) {
    return null;
  }
  
}

class Node {
  
  Node next = null;
  Object data = null;
  
  public Node(Object data) {
    this.data = data;
  }
  
}
