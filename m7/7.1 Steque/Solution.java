import java.util.Scanner;
class LinkedList<E> {
	private Node head, tail;
	class Node {
		private E data;
		private Node next;
		public Node(E item) {
			this.data = item;
			this.next = null;
		}
	}
	public LinkedList() {
		head = null;
		tail = null;
	}
	public void push(E item) {
		Node newnode = new Node(item);
		if (head == null) {
			tail = newnode;
		}
		newnode.next = head;
		head = newnode;
	}
	public void pop() {
		if (head == null) {
			System.out.println("Steque is empty.");
			return;
		}
		head = head.next;
		if (head == null) 
			tail = head;
	}
	public void enqueue(E item) {
		if (head == null) {
			push(item);
			return;
		}
		Node newnode = new Node(item);
		tail.next = newnode;
		newnode.next = null;
		tail = newnode;
	}
	public void print() {
		Node temp = head;
		String str = "";
		if (head == null) return;
		while(temp.next != null) {
			str += temp.data + ", ";
			temp = temp.next;
			
		}
		str += temp.data;
		System.out.println(str);
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			LinkedList<Integer> ll = new LinkedList<Integer>();
			String str = sc.nextLine();
			while(str != "\n") {
				String[] str1 = str.split(" ");
				switch (str1[0]) {
					case "push":
						ll.push(Integer.parseInt(str1[1]));
						break;
					case "pop":
						ll.pop();
						break;
					case "enqueue":
						ll.enqueue(Integer.parseInt(str1[1]));
						break;
					default:
						break;
				}
				ll.print();
				str = sc.nextLine();
			}
			System.out.println();
		}
		
	}
}