import java.util.Scanner;
/**
 * Class for Solution.
 */
public final class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {
    /**
     * Unused.
     */
  }
  /**
   * Main function.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    LinearProbingHashST<String, Integer> st =
     new LinearProbingHashST<String, Integer>();
    while (sc.hasNext()) {
      String[] tokens = sc.nextLine().split(" ");
      switch (tokens[0]) {
        case "put":
          st.put(tokens[1], Integer.parseInt(tokens[2]));
          break;
        case "get":
          System.out.println(st.get(tokens[1]));
          break;
        case "delete":
          st.delete(tokens[1]);
          break;
        case "display":
          System.out.println(st.toString());
          break;
        default:
          break;
      }
    }
  }

}