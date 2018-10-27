import java.util.*;
class BinarySearchTree {
  /**
   * Class for node.
   */
  class Node {
    /**
     * key.
     */
    private Double key;
    /**
     * value.
     */
    private Student value;
    /**
     * left.
     */
    private Node left;
    /**
     * right.
     */
    private Node right;
    /**
     * size.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      k     key.
     * @param      v     value.
     */
    Node(final Double k, final Student v, final int size) {
      this.key = k;
      this.value = v;
      this.left = null;
      this.right = null;
      this.size = size;
    }
  }
  /**
   * root.
   */
  private Node root;
  /**
   * Constructs the object.
   */
  BinarySearchTree() {
    root = null;
  }
  /**
   * Determines if empty.
   *
   * @return     True if empty, False otherwise.
   */
  public boolean isEmpty() {
    return size() == 0;
  }
  /**
   * size of tree.
   *
   * @return     Size of the tree.
   */
  public int size() {
    return size(root);
  }
  /**
   * size of subtree.
   *
   * @param      x     node.
   *
   * @return     integer value.
   */
  private int size(Node x) {
    if (x == null) return 0;
    else return x.size;
  }
  /**
   * put.
   *
   * @param      key    The key
   * @param      value  The value
   */
  public void put(final Double key, final Student value) {
    root = put(root, key, value);
  }
  /**
   * put.
   *
   * @param      x      Node.
   * @param      key    The key
   * @param      value  The value
   *
   * @return     The node.
   */
  private Node put(final Node x, final Double key, final Student value) {
    if (x == null) {
      return new Node(key, value, 1);
    }
    //int cmp = key.compareTo(x.key);
    if (key < x.key) {
      x.left = put(x.left, key, value);
    } else if (key > x.key) {
      x.right = put(x.right, key, value);
    } else {
      x.value = value;
    }
    x.size = 1 + size(x.left) + size(x.right);
    return x;
  }
  /**
   * get.
   *
   * @param      key   The key
   *
   * @return     Gets the value.
   */
  public void get(final Double key1, final Double key2) {
    get(root, key1, key2);
    return;
  }
  /**
   * get.
   *
   * @param      x     Node.
   * @param      key   The key
   *
   * @return     Gets the value.
   */
  private void get(final Node x, final Double key1,final Double key2) {
    if (x == null) {
      return;
    }
    //int cmp = key.compareTo(x.key);
    if (x.key == key2) 
    	System.out.println(x.value.getname());
    if (x.key == key1) 
    	System.out.println(x.value.getname());
    if (x.key > key2) 
      get(x.left, key1, key2);
    if (x.key < key1) 
     get(x.right, key1, key2);
  	if (x.key >= key1 && x.key <= key2) {
  		System.out.println(x.value.getname());
  		get(x.left, key1, key2);
  		get(x.right, key1, key2);
  	}

    
    return;
  }

}


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
		BinarySearchTree bst = new BinarySearchTree();

		for (int i = 1; i <= ns; i++) {
        	String[] str = scan.nextLine().split(",");
        	Student s = new Student(Integer.parseInt(str[0]), str[1], Double.parseDouble(str[2]));
        	bst.put(Double.parseDouble(str[2]), s);

		}
		int nq = Integer.parseInt(scan.nextLine());
		for (int i = 1; i <= nq; i++) {
        	String[] str = scan.nextLine().split(" ");
        	if (str[0].equals("BE"))
        		bst.get(Double.parseDouble(str[1]), Double.parseDouble(str[2]));
        	else if (str[0].equals("LE"))
        		bst.get(0.0, Double.parseDouble(str[1]));
        	else
        		bst.get(Double.parseDouble(str[1]), 100.0);
        }

	}

}