package arraysAndStrings;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a
 * method to rotate the image by 90 degrees. Can you do this in place?
 * @author David Lin
 */
public class ImageRotation {

  /** Constructor. */
  public ImageRotation() {
    // Empty
  }

  /**
   * Rotate image by 90 degrees counterclockwise.
   * @param image represented as a 2D integer array
   * @param n length and width
   * @return The rotated image
   */
  public int[][] rotateImage(int[][] image, int n) {
    // Start rotating from the outermost layer and go inwards
    for (int layer = 0; layer < n / 2; layer++) {
      // Boundaries of current layer
      int min = layer;
      int max = n - 1 - layer;
      // Loop through row/column pixels
      for (int pos = min; pos < max; pos++) {
        // Keep track of which pixel to rotate within the layer
        int offset = pos - min;
        // Save topmost pixel
        int top = image[min][pos];
        // Replace topmost pixel with rightmost pixel
        image[min][pos] = image[max - offset][min];
        // Replace rightmost pixel with bottommost pixel
        image[max - offset][min] = image[max][max - offset];
        // Replace bottommost pixel with leftmost pixel
        image[max][max - offset] = image[pos][max];
        // Replace leftmost pixel with topmost pixel
        image[pos][max] = top;
      }
    }
    return image;
  }

}