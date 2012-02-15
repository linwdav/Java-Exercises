package setsAndHashMaps;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implement a Set.
 * @author David Lin
 */
public class HashSet {

  private Map<String, Integer> map;

  /** Default constructor. */
  public HashSet() {
    map = new HashMap<String, Integer>();
  }

  /**
   * Add a key-value pair if it does exist in Set.
   * @param key The key
   * @param value The value
   */
  public void add(String key, int value) {
    if (map.containsKey(key)) {
      return;
    }
    map.put(key, value);
  }

  /**
   * Remove a key-value pair from the Set.
   * @param key The key
   * @return The key's value or null if key is not mapped
   */
  public Integer remove(String key) {
    return map.remove(key);
  }

  /**
   * Get a key's value.
   * @param key The key
   * @return The value of the key or null if key is not mapped
   */
  public Integer get(String key) {
    return map.get(key);
  }

  /**
   * Check if a key exists in Set.
   * @param key The key
   * @return True if key exists, false otherwise
   */
  public boolean contains(String key) {
    return map.containsKey(key);
  }

  /**
   * Get a list of all key-value pairs in the Set.
   * @return ArrayList containing all key-value pairs
   */
  public List<AbstractMap.SimpleEntry<String, Integer>> getAll() {
    List<AbstractMap.SimpleEntry<String, Integer>> array =
        new ArrayList<AbstractMap.SimpleEntry<String, Integer>>();
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      array.add(new SimpleEntry<String, Integer>(entry.getKey(), entry.getValue()));
    }
    return array;
  }

}
