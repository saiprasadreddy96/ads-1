import java.util.*;
class Student {
	private int roll;
	private String name;
	private double marks;
	Student(int sroll, String sname, double smarks) {
		roll = sroll;
		name = sname;
		marks = smarks;
	} 
	String getname() {
		return name;
	}
	Double getmarks() {
		return marks;
	}
}
class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int ns = Integer.parseInt(scan.nextLine());
        SeparateChainingHashST<Integer, Student> hash
        = new SeparateChainingHashST(ns);
        for (int i = 1; i <= ns; i++) {
        	String[] str = scan.nextLine().split(",");
        	Student s = new Student(Integer.parseInt(str[0]), str[1], Double.parseDouble(str[2]));
        	hash.put(Integer.parseInt(str[0]), s);
        }
        int nq = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= nq; i++) {
        	String[] str = scan.nextLine().split(" ");
        	Student st = hash.get(Integer.parseInt(str[1]));
        	if (st == null) 
        		System.out.println("Student doesn't exists...");
        	if (Integer.parseInt(str[2]) == 1) {
        		System.out.println(st.getname());
        	} else if (Integer.parseInt(str[2]) == 2){
        		System.out.println(st.getmarks());
        	}

        }

		
	}
}