package arraysAndStrings;

/**
 * Design an algorithm and write code to remove the duplicate characters in a string without using
 * any additional buffer. NOTE: One or two additional variables are fine. An extra copy of the array
 * is not.
 * @author David Lin
 */
public class DuplicateCharRemoval {

  /** Constructor. */
  public DuplicateCharRemoval() {
    // Empty
  }

  /**
   * Remove duplicate characters in a string.
   * @param string Input
   * @return String without duplicate characters.
   */
  public String removeDuplicates(String string) {
    StringBuilder uniqueString = new StringBuilder(string);
    for (int i = 0; i < uniqueString.length() - 1; i++) {
      for (int j = i + 1; j < uniqueString.length(); j++) {
        if (uniqueString.charAt(i) == uniqueString.charAt(j)) {
          uniqueString.deleteCharAt(j);
          j--;
        }
      }
    }
    return uniqueString.toString();
  }

}