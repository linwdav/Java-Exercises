package arraysAndStrings;

/**
 * Implement an algorithm to determine if a string has all unique characters. What if you can not
 * use additional data structures?
 * @author David Lin
 */
public class HasUniqueChars {

  /** Constructor. */
  public HasUniqueChars() {
    // Empty
  }

  /**
   * Determine if string has all unique characters.
   * @param string Input
   * @return True if unique, false if not unique
   */
  public boolean hasUniqueChars(String string) {
    for (int i = 0; i < string.length() - 1; i++) {
      for (int j = i + 1; j < string.length(); j++) {
        if (string.charAt(i) == string.charAt(j)) {
          return false;
        }
      }
    }
    return true;
  }

}