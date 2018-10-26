import java.util.Scanner;
/**
 * Class for minheap.
 */
class Minheap {
  /**
   * Determines if heap.
   *  Best case: O(1)
   *  worst case :O(n)
   *  Average case: O(n)
   *
   * @param      a     Input array.
   *
   * @return     True if heap, False otherwise.
   */
  public boolean isHeap(final Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      if (2 * i + 1 < a.length && 2 * i + 2 < a.length) {
        if (a[i].compareTo(a[2 * i + 1]) > 0
            || a[i].compareTo(a[2 * i + 2]) > 0) {
          return false;
        }
      }

    }
    return true;
  }
}
/**
 * Class for solution.
 */
final class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {

  }
  /**
   * main function - takes inputs and prints outputs to the console.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    int size;
    Scanner scan = new Scanner(System.in);
    String type = scan.nextLine();
    int testcases = scan.nextInt();
    Minheap m = new Minheap();
    scan.nextLine();
    for (int i = 0; i < testcases; i++) {
      String line = scan.nextLine();
      if (line.length() == 0) {
        System.out.println("false");
      } else {
        String[] input = line.split(",");
        switch (type) {
        case "String":
          size  = 0;
          String[] stringheap = new String[input.length];
          for (int j = 0; j < input.length; j++) {
            stringheap[size++] = input[j];
          }
          System.out.println(m.isHeap(stringheap));
          break;
        case "Integer":
          size = 0;
          Integer[] intheap = new Integer[input.length];
          for (int j = 0; j < input.length; j++) {
            intheap[size++] = Integer.parseInt(input[j]);
          }
          System.out.println(m.isHeap(intheap));
          break;
        case "Float":
          size = 0;
          Float[] floatheap = new Float[input.length];
          for (int j = 0; j < input.length; j++) {
            floatheap[size++] = Float.parseFloat(input[j]);
          }
          System.out.println(m.isHeap(floatheap));
          break;
        case "Double":
          size = 0;
          Double[] doubleheap = new Double[input.length];
          for (int j = 0; j < input.length; j++) {
            doubleheap[size++] = Double.parseDouble(input[j]);
          }
          System.out.println(m.isHeap(doubleheap));
          break;
        default:
          break;
        }
      }
    }
  }
}