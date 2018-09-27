import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Problem1<E> {
	private E[] stack;
	private int size, resize;
	private Problem1() {
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
	public void pop() {
		if (size == resize / 4) {
			resize(size);
		}
		size--;
		stack[size] = null;

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
		Problem1<String> pl = new Problem1<String>();
		Scanner sc = new Scanner(System.in);
		String[] temp = sc.nextLine().split(" ");
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].equals("-")) {
				pl.pop();
			} else {
				pl.push(temp[i]);
			}
		}
		pl.printstack();
		
	}
}