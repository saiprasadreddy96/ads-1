import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Solution<E> {
	private E[] stack;
	private int size, resize;
	private Solution() {
		stack = (E[])new Object[20];
		size = 0;
		resize = 40;
	}
	public void push(E item) {
		if (size == resize) {
			resize(2 * size);
		}
		stack[size++] = item;
	}
	public E pop() {
		if (size == resize / 4) {
			resize(size);
		}
		size--;
		return stack[size];

	}
	public void resize(int resize) {
		E[] stack1 = (E[])new Object[resize];
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
	public static void main(String[] args) {
		Solution<Integer> pl = new Solution<Integer>();
		Scanner sc = new Scanner(System.in);
		String temp;
		int a,b;
		while (sc.hasNext()) {
			temp = sc.next();
			if (temp.equals("*") || temp.equals("-") || temp.equals("*") || temp.equals("/")) {
				a = pl.pop();
				b = pl.pop();
				switch (temp) {
					case "+":
						pl.push(a + b);
						break;
					case "-":
						pl.push(a - b);
						break;
					case "*":
						pl.push(a * b);
						break;
					case "/":
						pl.push(a / b);
						break;
					default :
						break;
				}
			} else {
				pl.push(Integer.parseInt(temp));
			}
		}
		System.out.println(pl.pop());
		
	}
}