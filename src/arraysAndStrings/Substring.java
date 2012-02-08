package arraysAndStrings;

/**
 * Write a method to determine if a string contains another string.
 * @author David Lin
 */
public class Substring {

  /** Constructor. */
  public Substring() {
    // Empty
  }

  /**
   * Determine if a string contains another string.
   * @param stringA First string
   * @param stringB Second string
   * @return True if subset, false if not subset
   */
  public boolean isSubstring(String stringA, String stringB) {
    if (stringA.contains(stringB) || stringB.contains(stringA)) {
      return true;
    }
    return false;
  }

}