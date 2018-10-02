import java.util.Scanner;
import java.lang.Comparable;
import java.util.ArrayList;
class Team implements Comparable<Team>{
	private String name;
	private int w,l,d;
	Team (String name1, int w1, int l1, int d1) {
		name = name1;
		w = w1;
		l = l1;
		d = d1;
	}
	public int compareTo(Team other) {
		if (this.w < other.w) {
			return 1;
		} else if (this.w > other.w) {
			return 0;
		} else {
			if (this.l > other.l) {
				return 1;
			} else if (this.l < other.l) {
				return 0;
			} else {
				if (this.d < other.d) {
					return 1;
				} else {
					return 0;
				}
			}
		}

	}
	public String getname() {
		return this.name;
	}
}
class Solution {
	private Team[] teams;
	private int size;
	Solution() {
		teams = new Team[10];
		size = 0;
	}
	public int size() {
		return size;
	}
	public void add(Team t) {
		teams[size++] = t;
	}
	public void Selectionsort() {
		for (int i = 0; i < size() -1; i++) {
			int max = i;
			for (int j = i + 1; j < size(); j++) {
				if (teams[max].compareTo(teams[j]) == 1) {
					max = j;
				}
			}
			Team t = teams[i];
			teams[i] = teams[max];
			teams[max] = t;
		}
	}
	public void print() {
		String str = "";
		for (int i = 0; i < size(); i++) {
			str += teams[i].getname() + ",";
		}
		System.out.println(str.substring(0, str.length() - 1));
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] str = sc.nextLine().split(",");
			s.add(new Team(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3])));
		}
		s.Selectionsort();
		s.print();
		
	}
}