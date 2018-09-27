import java.io.*;
import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		int count = 0;
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(sc.nextLine());
		}
		Arrays.sort(arr);
		for (int k = 0; k < arr.length; k++) {
        int i = 0;
        int j = arr.length - 1;
		while (j != k && i != k && i < j) {
            if (arr[i] + arr[j] == -arr[k]) {
                count++;
                i++;
            } else if (arr[i] + arr[j] > -arr[k]) {
                j--;
            } else {
                i++;
            }
            }
        }
		System.out.println(count);
	}
}