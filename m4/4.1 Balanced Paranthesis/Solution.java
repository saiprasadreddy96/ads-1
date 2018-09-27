import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
class Stack {
	private String[] stack;
	private int size, resize;
	public Stack() {
		stack = new String[400];
		size = 0;
		resize = 800;
	}
	public void push(String item) {
		if (size == resize) {
			resize(2 * size);
		}
		stack[size++] = item;
	}
	public String pop() {
		if (size == resize / 4) {
			resize(size);
		}
		size--;
		return stack[size];

	}
	public void resize(int resize) {
		String[] stack1 = new String[resize];
		for (int i = 0; i < size; i++) {
			stack1[i] = stack[i];
		}
		stack = stack1;
	}
	public boolean isEmpty() {
		return (size == 0);
	}
	public void printstack() {
		for (int i = 0; i < size; i++) {
			System.out.println(stack[i] + " ");
		}
	}
	public boolean balanced(String[] paren) {
		String p;
		String[] open = {"(", "[", "{"};
		String[] close = {")", "]", "}"};
		for (int i = 0; i < paren.length; i++) {
			p = paren[i];
			if (p.equals("(") || p.equals("[") || p.equals("{")) {
	 
				push(p);
			}
			if (p.equals(")") || p.equals("]") || p.equals("}")) {
				if (size == 0) return false;

				if (getindex(p, close) != getindex(pop(), open)) {
					return false;
				}
			}
		}
		if (size == 0)
			return true;
		return false;
	}
	public static int getindex(String s1,String[] s2) {
		for (int i = 0; i < s2.length; i++) {
			if (s2[i].equals(s1))
				return i;
		}
		return -1;
	}
	
}

public class Solution {
	public static String[] convert(String s) {
		String[] s1 = new String[s.length()];
		for (int i =0; i < s.length(); i++) {
			String s3 = s.charAt(i) + " ";
			s1[i] = s3.substring(0, 1);
		}
		return s1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String s;
		for (int i = 0; i < n; i++) {
			s = sc.nextLine();
			Stack pl = new Stack();
			String[] s2 = convert(s);
			if (pl.balanced(s2)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			
		}



	}

}