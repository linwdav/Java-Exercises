package arraysAndStrings;

import java.util.Arrays;

/**
 * Write a method to decide if two strings are anagrams or not.
 * @author David Lin
 */
public class Anagrams {

  /** Constructor. */
  public Anagrams() {
    // Empty
  }

  /**
   * Determine if two strings are anagrams.
   * @param stringA First string
   * @param stringB Second string
   * @return True if anagram, false if not anagram
   */
  public boolean isAnagram(String stringA, String stringB) {
    if (stringA.length() != stringB.length()) {
      return false;
    }
    char[] a = stringA.toCharArray();
    char[] b = stringB.toCharArray();
    Arrays.sort(a);
    Arrays.sort(b);
    if (String.valueOf(a).compareTo(String.valueOf(b)) == 0) {
      return true;
    }
    return false;
  }

}