import java.util.Scanner;

/**
 * Class for cube sum.
 */
class CubeSum implements Comparable<CubeSum> {
  /**
   * To calculate the sum of two cubes.
   */
  private int sum;
  /**
   * First integer variable.
   */
  private int i;
  /**
   * Second integer variable.
   */
  private int j;
  /**
   * Constructs the object.
   *
   * @param      i1     Integer Variable
   * @param      j1     Integer Variable
   */
  CubeSum(final int i1, final int j1) {
    this.sum = i1 * i1 * i1 + j1 * j1 * j1;
    this.i = i1;
    this.j = j1;
  }
  /**
   * Compares to function for comparable objects.
   *
   * @param      that  The that
   *
   * @return     int
   */
  public int compareTo(final CubeSum that) {
    if (this.sum < that.sum) {
      return -1;
    }
    if (this.sum > that.sum) {
      return +1;
    }
    return 0;
  }
  /**
   * Gets i.
   *
   * @return     I.
   */
  public int getI() {
    return i;
  }
  /**
   * Gets the j.
   *
   * @return     The j.
   */
  public int getJ() {
    return j;
  }
  /**
   * Gets the sum.
   *
   * @return     The sum.
   */
  public int getSum() {
    return sum;
  }
  /**
   * Returns a string representation of the object.
   *
   * @return     String representation of the object.
   */
  public String toString() {
    return sum + " = " + i + "^3" + " + " + j + "^3";
  }
}

/**
 * Class for Solution.
 */
public final class Solution {
  /**
   * TO remove magic number error.
   */
  private static final int N = 522;
  /**
   * Constructs the object.
   */
  private Solution() {
    /**
     * Unused.
     */
  }
  /**
   * Main Function.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
    for (int i = 1; i <= N; i++) {
      pq.insert(new CubeSum(i, i));
    }
    // int i = 0;
    CubeSum prev = new CubeSum(0, 0);
    int sum = 0;
    int p = 1;
    int k = 0;
    while (!pq.isEmpty()) {
      CubeSum c = pq.delMin();
      if (prev.getSum() == c.getSum()) {
        p++;
        if (p == m) {
          sum = c.getSum();

          if (++k == n) {
            break;
          }
        }
      } else {
        p = 1;
      }
      prev = c;
    if (c.getJ() < N) {
      pq.insert(new CubeSum(c.getI(), c.getJ() + 1));
    }
  }
    System.out.println(sum);

  }
}