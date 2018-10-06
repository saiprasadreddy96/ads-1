import java.util.Scanner;
class Solution {
	private Student[] students;
	private Student[] rstudents;
	private int size;
	private int nstudents, nseats, nunreverseds, nbcs, nscs, nsts, rsize;
	Solution(int nstudents, int nseats, int nunreverseds, int nbcs, int nscs, int nsts) {
		students = new Student[nstudents];
		rstudents = new Student[100];
		size = 0;
		rsize = 0;
		this.nstudents = nstudents;
		this.nseats = nseats;
		this.nunreverseds = nunreverseds;
		this.nbcs = nbcs;
		this.nscs = nscs;
		this.nsts = nsts;
	}
	public int getsize() {
		return size;
	}
	public int getrsize() {
		return rsize;
	}
	public void add(Student s) {
		students[size++] = s;
	}
	public void radd(Student s) {
		rstudents[rsize++] = s;
	}
	public void meritsort(Student[] studentstemp, int sizetemp) {
		int i, j;
		for (i = 1; i < sizetemp; i++) {
			j = i;
			while (j > 0) {
				if (compare(studentstemp[j - 1], studentstemp[j]) == 1) {
					Student s = studentstemp[j - 1];
					studentstemp[j - 1] = studentstemp[j];
					studentstemp[j] = s;
					j = j - 1;

				} else {
					break;
				}
			}
		}
	
	//public void print() {
		for (int k = 0; k < sizetemp; k++) {
			System.out.println(studentstemp[k]);
		}
	}
	public void reservationsort() {
		for (int i = 0; i < size; i++) {
			//System.out.println(students[i]);
			if (nunreverseds >= 1) {
				//System.out.println(students[i]);
				radd(students[i]);
				nunreverseds = nunreverseds - 1;

			} else {
				String c = students[i].getcategory();
				if (nbcs > 0 || nscs > 0 || nsts > 0) {
					if (c.equals("BC") && nbcs > 0) {
						//System.out.println(students[i]);
						radd(students[i]);
						nbcs = nbcs - 1;
					}
					if (c.equals("SC") && nscs > 0) {
						//System.out.println(students[i]);
						radd(students[i]);
						nscs = nscs - 1;
					}
					if (c.equals("ST") && nsts > 0) {
						//System.out.println(students[i]);
						radd(students[i]);
						nsts = nsts - 1;
					}

				} else {
					break;
				}

			}
		}
	}
	public int contains(Student s) {
		int f = 0;
		for (int i = 0; i < rsize; i++) {
			if (s.getname().equals(rstudents[i].getname())) {
				f = 1;
				break;
			}
		}
		return f;
		

	}
	public void rprint() {
		int t = nbcs + nscs + nsts;
		
			for (int i = 0; i < size; i++) {
				if (t <= 0) {
					break;
				}
				if (contains(students[i]) == 0) {
					radd(students[i]);
					t = t - 1;
				}
			}
		// for (int i = 0; i < rsize; i++) {
		// 	System.out.println(rstudents[i]);
		// }


	}
	public int compare(Student s1, Student s2) {
		if (s1.gettm() < s2.gettm()) return 1;
		if (s1.gettm() > s2.gettm()) return 0;
		if (s1.getm3() < s2.getm3()) return 1;
		if (s1.getm3() > s2.getm3()) return 0;
		if (s1.getm2() < s2.getm2()) return 1;
		if (s1.getm2() > s2.getm2()) return 0;
		String[] str1 = s1.getdob().split("-");
		String[] str2 = s2.getdob().split("-");
		if (Integer.parseInt(str1[2]) < Integer.parseInt(str2[2])) return 1;
		if (Integer.parseInt(str1[2]) > Integer.parseInt(str2[2])) return 0;
		if (Integer.parseInt(str1[1]) < Integer.parseInt(str2[1])) return 1;
		if (Integer.parseInt(str1[1]) > Integer.parseInt(str2[1])) return 0;
		if (Integer.parseInt(str1[0]) < Integer.parseInt(str2[0])) return 1;
		if (Integer.parseInt(str1[0]) > Integer.parseInt(str2[0])) return 0;
		return 0;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int nstudents = Integer.parseInt(sc.nextLine());
		int nseats = Integer.parseInt(sc.nextLine());
		int nunreverseds = Integer.parseInt(sc.nextLine());
		int nbcs = Integer.parseInt(sc.nextLine());
		int nscs = Integer.parseInt(sc.nextLine());
		int nsts = Integer.parseInt(sc.nextLine());
		Solution s = new Solution(nstudents, nseats, nunreverseds, nbcs, nscs, nsts);
		while (nstudents > 0) {
			String[] str = sc.nextLine().split(",");
			s.add(new Student(str[0], str[1], Integer.parseInt(str[2]), Integer.parseInt(str[3]), Integer.parseInt(str[4]), Integer.parseInt(str[5]), str[6]));
			nstudents = nstudents - 1;
		}
		s.meritsort(s.students, s.getsize());
		//s.print();
		System.out.println();
		s.reservationsort();
		s.rprint();
		s.meritsort(s.rstudents, s.getrsize());
		
	}
}