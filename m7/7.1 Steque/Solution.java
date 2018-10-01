import java.util.Scanner;
/**.
 * List of linkeds.
 *
 * @param      <E>   { parameter_description }
 */
class LinkedList<E> {
    /**.
    * { item_description }
    */
    private Node head, tail;
    /**.
    * Class for node.
    */
	class Node {
		/**.
		 * { var_description }
		 */
		private E data;
		/**.
		 * { var_description }
		 */
		private Node next;
		/**.
		 * Constructs the object.
		 *
		 * @param      item  The item
		 */
		protected Node(final E item) {
			this.data = item;
			this.next = null;
		}
	}
	/**.
	 * Constructs the object.
	 */
	protected LinkedList() {
		head = null;
		tail = null;
	}
	/**.
	 * { function_description }
	 *
	 * @param      item  The item
	 */
	public void push(final E item) {
		Node newnode = new Node(item);
		if (head == null) {
			tail = newnode;
		}
		newnode.next = head;
		head = newnode;
	}
	/**.
	 * { function_description }
	 */
	public void pop() {
		if (head == null) {
			//System.out.println("Steque is empty.");
			return;
		}
		head = head.next;
		if (head == null) {
			tail = head;
		}
	}
	/**.
	 * { function_description }
	 *
	 * @param      item  The item
	 */
	public void enqueue(final E item) {
		if (head == null) {
			push(item);
			return;
		}
		Node newnode = new Node(item);
		tail.next = newnode;
		newnode.next = null;
		tail = newnode;
	}
	/**.
	 * { function_description }
	 */
	public void print() {
		Node temp = head;
		String str = "";
		if (head == null) {
			System.out.println("Steque is empty.");
			return;
		}
		while (temp.next != null) {
			str += temp.data + ", ";
			temp = temp.next;
		}
		str += temp.data;
		System.out.println(str);
	}
}
/**.
 * Class for solution.
 */
final class Solution {
	/**.
	 * Constructs the object.
	 */
	private Solution() {
	}
	/**.
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			LinkedList<Integer> ll
			= new LinkedList<Integer>();
			//String str = sc.nextLine();
			while (sc.hasNext()) {
				String str = sc.nextLine();
				if (str.isEmpty()) {
					break;
				}
				String[] str1 = str.split(" ");
				switch (str1[0]) {
					case "push":
						ll.push(Integer.parseInt(
							str1[1]));
						break;
					case "pop":
						ll.pop();
						break;
					case "enqueue":
						ll.enqueue(Integer.parseInt(
							str1[1]));
						break;
					default:
						break;
				}
				ll.print();
			}
			System.out.println();
		}
	}
}


