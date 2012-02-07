package arraysAndStrings;

/**
 * Write code to reverse a String.
 * @author David Lin
 */
public class StringReversal {

  /** Constructor. */
  public StringReversal() {
    // Empty
  }

  /**
   * Reverse a string.
   * @param string Input
   * @return Reversed string
   */
  public String reverseString(String string) {
    char[] charArray = string.toCharArray();
    int low = 0;
    int high = charArray.length - 1;
    while (low <= high) {
      char temp = charArray[low];
      charArray[low] = charArray[high];
      charArray[high] = temp;
      low++;
      high--;
    }
    return String.valueOf(charArray);
  }

}
