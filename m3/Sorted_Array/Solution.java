import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * Main function to take inputs and print outputs.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int p = Integer.parseInt(scan.nextLine());
        int q = Integer.parseInt(scan.nextLine());
        String[] list1 = scan.nextLine().split(",");
        String[] list2 = scan.nextLine().split(",");
        int[] arr1 = new int[p];
        int[] arr2 = new int[q];
        if (p != 0) {
            for (int i = 0; i < list1.length; i++) {
                arr1[i] = Integer.parseInt(list1[i]);
            }
        }
        if (q != 0) {
            for (int i = 0; i < list2.length; i++) {
                arr2[i] = Integer.parseInt(list2[i]);
            }
        }
        Sorted sortedarray = new Sorted();
        System.out.println(sortedarray.concat(arr1, arr2));
    }
}