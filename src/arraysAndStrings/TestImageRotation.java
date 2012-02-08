package arraysAndStrings;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test ImageRotation program.
 * @author David Lin
 */
public class TestImageRotation {

  /**
   * JUnit test on ImageRotation.
   */
  @Test
  public void testSpaceReplacement() {
    ImageRotation test = new ImageRotation();
    // Image sizes
    int sizeA = 1;
    int sizeB = 2;
    int sizeC = 3;
    // Used to track pixel as we loop through matrix
    int counterA = 1;
    int counterB = 1;
    int counterC = 1;
    // Rotated images
    int[][] a = test.rotateImage(createMatrix(sizeA), sizeA);
    int[][] b = test.rotateImage(createMatrix(sizeB), sizeB);
    int[][] c = test.rotateImage(createMatrix(sizeC), sizeC);

    // Test image a
    for (int i = 0; i < sizeA; i++) {
      for (int j = sizeA - 1; j > -1; j--) {
        // System.out.print(a[i][j]);
        assertEquals("Image a did not rotate properly", counterA, a[i][j]);
        counterA++;
      }
    }

    // Test image b
    for (int i = 0; i < sizeB; i++) {
      for (int j = sizeB - 1; j > -1; j--) {
        // System.out.print(b[i][j]);
        assertEquals("Image b did not rotate properly", counterB, b[i][j]);
        counterB++;
      }
    }

    // Test image c
    for (int i = 0; i < sizeC; i++) {
      for (int j = sizeC - 1; j > -1; j--) {
        //System.out.print(c[i][j]);
        assertEquals("Image c did not rotate properly", counterC, c[i][j]);
        counterC++;
      }
    }

  }

  /**
   * Create a 2D matrix of integers.
   * @param n Size of matrix
   * @return The matrix
   */
  public int[][] createMatrix(int n) {
    int[][] matrix = new int[n][n];
    int counter = 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        // Fill matrix with integers
        matrix[j][i] = counter;
        counter++;
      }
    }
    return matrix;
  }

}