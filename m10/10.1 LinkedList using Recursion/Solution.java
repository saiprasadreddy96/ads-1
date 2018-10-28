import java.util.Scanner;
import java.util.Iterator;

/**
 * Linked Lists.
 *
 * @param      <E>   { parameter_description }
 */
class LinkedList<E> implements Iterable<E> {

  /**
   * Class for node.
   */
  private class Node {
    /**
     * Declaration.
     */
    private E data;
    /**
     * Declaration.
     */
    private Node next;
    /**
     * Constructs the object.
     *
     * @param      data1  The data 1
     * @param      next1  The next 1
     */
    Node(final E data1, final Node next1) {
      this.data = data1;
      this.next = next1;
    }
  }
  /**
   * Declaration.
   */
  private Node head;

  /**
   * Gets the head.
   *
   * @return     The head.
   */
  public Node getHead() {
    return head;
  }

  /**
   * This method inserts the element at the given index position.
   *
   * @param      index  The index
   * @param      ele    The ele
   */
  public void insertAt(final int index, final E ele)  {
    head = insertHelper(head, index, ele);
  }

  /**
   * This function is a helper function to above method.
   * Complexity : N
   *
   * @param      head1  The head
   * @param      cnt   The count
   * @param      ele   The ele
   *
   * @return     { description_of_the_return_value }
   */
  public Node insertHelper(final Node head1, final int cnt, final E ele) {
    if (cnt == 0) {
      return new Node(ele, head1);
    }
    head1.next  = insertHelper(head1.next, cnt - 1, ele);
    return head1;
  }

  /**
   * This method reverses the order of linkedlist we have.
   */
  public void reverse() {
    head = reverseHelper(head);
  }

  /**
   * This method is a helper function for above method.
   * Complexity : N
   * @param      head1  The head
   *
   * @return     { description_of_the_return_value }
   */
  public Node reverseHelper(final Node head1) {
    if (head1 == null || head1.next == null) {
      return head1;
    }
    Node nhead = reverseHelper(head1.next);
    head1.next.next = head1;
    head1.next = null;
    return nhead;
  }

  /**
   * Iterator Method.
   *
   * @return     { description_of_the_return_value }
   */
  public Iterator iterator() {
    return new MyIterator(head);
  }

  /**
   * Class for my iterator.
   */
  private class MyIterator implements Iterator {
    /**
     * Declaration.
     */
    private Node current;

    /**
     * Gets the current.
     *
     * @return     The current.
     */
    public Node getCurrent() {
      return current;
    }
    /**
     * Constructs the object.
     *
     * @param      first  The first
     */
    MyIterator(final Node first) {
      current = first;
    }

    /**
     * Determines if it has next.
     *
     * @return     True if has next, False otherwise.
     */
    public boolean hasNext() {
      return current !=  null;
    }

    /**
     * Default Remove method in Iterator Intreface.
     */
    public void remove() {
      /**
       * Unused.
       */
    }

    /**
     * Returns the data of the current element in the linkedlist.
     *
     * @return     { description_of_the_return_value }
     */
    public E next() {
      E data = current.data;
      current = current.next;
      return data;
    }
  }
}


/**
 * Class for Solution.
 */

public final class Solution {

  /**
   * Constructs the object.
   */
  private Solution() {
    /**
     * Unused.
     */
  }
  /**
   * Main Function.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);
    LinkedList<Integer> li = new LinkedList<>();
    while (sc.hasNext()) {
      String[] line = sc.nextLine().split(" ");
      String s = "";
      switch (line[0]) {
        case "insertAt":
          try {
            li.insertAt(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
            for (Integer e : li) {
              s += e + ", ";
            }
            System.out.println(s.substring(0, s.length() - 2));
          } catch (Exception e) {
              System.out.println("Can't insert at this position.");
          }
          break;
        case "reverse":
          try {
            li.reverse();
            for (Integer e : li) {
              s += e + ", ";
            }
            System.out.println(s.substring(0, s.length() - 2));
          } catch (Exception e) {
              System.out.println("No elements to reverse.");
          }
          break;
        default:
          break;
      }
    }
  }
}