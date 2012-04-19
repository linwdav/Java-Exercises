package math;

/**
 * Determine how many rectangles can fit in an (m x n) board. A square is a special type of
 * rectangle.
 * @author David Lin
 */
public class NumberOfRectangles {

  /**
   * Find the number of different sized rectangles than can fit in a board.
   * @param x First dimension
   * @param y Second dimension
   * @return Number of rectangles
   */
  public static int findNumRectangles(int x, int y) {
    int height = Math.min(x, y);
    int base = Math.max(x, y);
    int sum = 0;

    for (int i = 1; i <= height; i++) {
      for (int j = i; j <= base; j++) {
        int rectangles = (base - (j - 1)) * (height - (i - 1));
        if (i != j) {
          // There are more possibilities for non-square rectangles
          int additional = (height - (j - 1)) * (base - (i - 1));
          if (additional < 0) {
            // Need to check if additional is negative because (height - (j - 1)) can be negative
            additional = 0;
          }
          rectangles += additional;
        }
        sum += rectangles;
        // System.out.println(i + "x" + j + ": " + rectangles + " rectangles");
      }
    }
    // System.out.println(sum + " rectangles can fit in a board of size " + x + "x" + y);
    return sum;
  }

}
