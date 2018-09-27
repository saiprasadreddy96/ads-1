import java.util.Arrays;
/**
 * Class for sorted.
 */
class Sorted {
    /**
     * Constructs the object.
     */
    Sorted() {

    }
    /**
     * Concat function to concat 2 arrays.
     *
     * @param      arr1  The arr 1
     * @param      arr2  The arr 2
     *
     * @return     { description_of_the_return_value }
     */
    public String concat(int[] arr1, int[] arr2) {
        int i = 0,j = 0,k = 0;
        int[] res = new int[arr1.length + arr2.length];
        while (i < arr1.length + arr2.length) {
            if (j < arr1.length && k < arr2.length) {
                if (arr1[j] <= arr2[k]) {
                    res[i++] = arr1[j++];
                    // k++;
                    // j++;
                } else {
                    res[i++] = arr2[k++];
                    // i++;
                    // k++;
                }

            } else if (j < arr1.length) {
                res[i++] = arr1[j++];
                // i++;
                // j++;
            } else if (k < arr2.length) {
                res[i++] = arr2[k++];
            }
        }
        // while (i < arr1.length) {
        //     res[k++] = arr1[i++];
        // }
        // while (j < arr2.length) {
        //     res[k++] = arr2[j++];
        // }
        return Arrays.toString(res).replaceAll("[\\]\\[ ]", "");
    }
}