package arraysAndStrings;

/**
 * Write a method to replace all spaces in a string with ‘%20’.
 * @author David Lin
 */
public class SpaceReplacement {

  /** Constructor. */
  public SpaceReplacement() {
    // Empty
  }

  /**
   * Replace all spaces in a string with '%20'.
   * @param string Input
   * @return String without spaces
   */
  public String replaceSpaces(String string) {
    return string.replaceAll(" ", "%20");
  }

}