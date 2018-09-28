import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
class Dequeue<E> {
	E[] dequeue;
	int head, tail, capacity;
	public Dequeue() {
		dequeue = (E[])new Object[2000];
		capacity = 2000;
		head = 1000;
		tail = 1000;
	}
	public void pushright(E item) {
		if (tail < capacity) {
			dequeue[tail++] = item;
		}
	}
	public void popleft() {
		if (head < tail) {
			dequeue[head] = null;
			head++;
		}
	}
	public void pushleft(E item) {
		if (head > 0) {
			head--;
			dequeue[head] = item;
		}
	}
	public void popright() {
		if (tail > head) {
			tail--;
			dequeue[tail] = null;
		}
	}
	public int size() {
		if (head != tail)
			return tail - head;
		return 0;
	}
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public String print() {
		if (!isEmpty()) {
			String s = "[";
			int i = head;
			for (i = head; i < tail - 1; i++) {
				s += dequeue[i] + ", ";
			}
			s += dequeue[i] + "]";
			return s;
		} else {
			return "[]";
		}
		//return "something wrong";
	}
}
class Solution {
	public static void main(String[] args) {
		Dequeue<Integer> d = new Dequeue<Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] input;
		for (int i = 1; i <= n + 1; i++) {
			input = sc.nextLine().split(" ");
			switch (input[0]) {
				case "size":
					System.out.println(d.size());
					break;
				case "pushLeft":
					d.pushleft(Integer.parseInt(input[1]));
					System.out.println(d.print());
					break;
				case "pushRight":
					d.pushright(Integer.parseInt(input[1]));
					System.out.println(d.print());
					break;
				case "popLeft":
					d.popleft();
					if (!d.isEmpty()) {
						System.out.println(d.print());
					} else {
						System.out.println("Deck is empty");
					}
					break;
				case "popRight":
					d.popright();
					if (!d.isEmpty()) {
						System.out.println(d.print());
					} else {
						System.out.println("Deck is empty");
					}
					break;
				default:
					break;
			}

		}

	}

}