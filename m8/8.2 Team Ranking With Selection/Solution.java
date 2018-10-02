import java.util.Scanner;
import java.lang.Comparable;
class Team implements Comparable<Team>{
	private String name;
	private int w, l, d;
	public Team(String name1, int w1, int l1, int d1) {
		name = name1;
		w = w1;
		l = l1;
		d = d1;
	}
	public String getname() {
		return name;
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
				if (this.d > other.d) {
					return 1;
				} else {
					return 0;
				}
			}
		}

	}
}
final class Solution {
	private Team[] teams;
	private int size;
	Solution() {
		teams = new Team[10];
		size = 0;
	}
	public void add(Team other) {
		teams[size++] = other;
	}
	public void Insertionsort() {
		for (int i = 1; i < size; i++) {
			int j = i;
			while (teams[j - 1].compareTo(teams[j]) == 1 && j > 0) {
				Team t = teams[j - 1];
				teams[j - 1] = teams[j];
				teams[j] = t;
			}
		}

	}
	public void print() {
		String str = "";
		for (int i = 0; i < size; i++) {
			str += teams[i].getname() + ",";
		}
		System.out.println(str.substring(0, str.length() - 1));

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution s = new Solution();
		String[] str;
		while (sc.hasNext()) {
			str = sc.nextLine().split(",");
			s.add(new Team(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3])));
		}
		s.Insertionsort();
		s.print();

	}
}