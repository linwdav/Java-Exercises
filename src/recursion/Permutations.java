package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a method to compute all permutations of a string.
 * @author David Lin
 */
public class Permutations {

  /** Constructor. */
  public Permutations() {
    // Empty
  }

  /**
   * Finds all permutations of a string.
   * @param s String
   * @return List of all permutations
   */
  public List<String> permutations(String s) {
    List<String> list = new ArrayList<String>(0);
    if (s.length() < 1) {
      return list;
    }

    // Base case
    if (s.length() == 1) {
      list.add(s);
      return list;
    }

    // Loops through every letter in the string
    for (int i = 0; i < s.length(); i++) {
      // StringBuilder remainder = new StringBuilder(s);
      // remainder.deleteCharAt(i);
      for (String word : permutations(s.substring(0, i) + s.substring(i + 1))) {
        list.add(s.charAt(i) + word);
      }
    }
    return list;
  }
}