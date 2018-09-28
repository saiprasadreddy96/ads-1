import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Solution {
	public void find(int np, int pos) {
		int[] persons = new int[np];
		for (int i = 0; i < np; i++) {
			persons[i] = i;
		}
		int count = np, i = 1, index = 0;
		String s = "";
		while (count != 0) {
			
			if (persons[index % np] != -999) {
				if (i == pos) {
					//System.out.print(persons[index % np]);
					s += persons[index % np] + " ";
					persons[index % np] = -999;
					count--;
					i = 1;
					index++;
				} else {
					index++;
					i++;
				}
			} else {
				index++;
			}

		}
		System.out.println(s.trim());

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution s = new Solution();
		int n = sc.nextInt();
		int np, p;
		for (int i = 0; i < n; i++) {
			np = sc.nextInt();
			p = sc.nextInt();
			//System.out.println(np,p);
			s.find(np, p);

		}
	}
}