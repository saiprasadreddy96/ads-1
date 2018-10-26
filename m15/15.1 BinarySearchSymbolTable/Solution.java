import java.util.Scanner;

/**
 * Class for binary st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinaryST<Key extends Comparable<Key>, Value> {
  /**
   * Stores the keys.
   */
  private Key[] keys;
  /**
   * Stores the keys.
   */
  private Value[] values;
  /**
   * Size.
   */
  private int size;
  /**
   * Constructs the object.
   */
  BinaryST() {
    keys = (Key[]) new Comparable[2];
    values = (Value[]) new Object[2];
    size = 0;
  }
  /**
   * Resizes the array.
   * Complexity N.
   * @param      cap   The capability
   */
  private void resize(final int cap) {
    Key[]   tempk = (Key[])   new Comparable[cap];
    Value[] tempv = (Value[]) new Object[cap];
    for (int i = 0; i < size; i++) {
      tempk[i] = keys[i];
      tempv[i] = values[i];
    }
    values = tempv;
    keys = tempk;
  }
  /**
   * Adds the key and allots to the value.
   * Complexity N
   * @param      k     { parameter_description }
   * @param      v     { parameter_description }
   */
  public void put(final Key k, final Value v) {
    if (v == null) {
      delete(k);
      return;
    }
    int i = rank(k);
    if (i < size && keys[i].compareTo(k) == 0) {
      values[i] = v;
      return;
    }
    for (int j = size; j > i; j--)  {
      keys[j] = keys[j - 1];
      values[j] = values[j - 1];
    }
    keys[i] = k;
    values[i] = v;
    size++;
    if (size == keys.length) {
      resize(2 * size);
    }
  }
  /**
   * Finds the rank of the given key.
   * Complexity log N.
   * @param      key   The key
   *
   * @return     { description_of_the_return_value }
   */
  public int rank(final Key key) {
    int lo = 0, hi = size - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int comp = key.compareTo(keys[mid]);
      if (comp > 0) {
        lo = mid + 1;
      } else if (comp < 0) {
        hi = mid - 1;
      } else {
        return mid;
      }
    }
    return lo;
  }
  /**
   * Gets the value.
   *
   * @param      a     Key.
   *
   * @return     Value.
   */
  public Value get(final Key a) {
    if (isEmpty()) {
      return null;
    }
    int i = rank(a);
    if (i < size && keys[i].compareTo(a) == 0) {
      return values[i];
    }
    return null;
  }
  /**
   * Determines if empty.
   *
   * @return     True if empty, False otherwise.
   */
  public boolean isEmpty() {
    return size == 0;
  }
  /**
   * Checks whether the key is in the given array.
   *
   * @param      k     key
   *
   * @return     true/false
   */
  public boolean contains(final Key k) {
    return get(k) != null;
  }
  /**
   * Finds the floor of the entered key.
   *
   * @param      k     { parameter_description }
   *
   * @return     { description_of_the_return_value }
   */
  public Key floor(final Key k) {
    if (isEmpty()) {
      return null;
    }
    int i = rank(k);
    if (i == 0) {
      return null;
    }
    if (i < size && keys[i].compareTo(k) == 0) {
      return keys[i];
    }
    return keys[i - 1];
  }
  /**
   * Deletes a given key.
   * Complexity N
   * @param      delkey  The delkey
   */
  public void delete(final Key delkey) {
    final int four = 4;
    if (isEmpty()) {
      return;
    }
    int i = rank(delkey);
    if (i < size && keys[i].compareTo(delkey) != 0) {
      return;
    }
    for (int j = i; j < size - 1; j++)  {
      keys[j] = keys[j + 1];
      values[j] = values[j + 1];
    }
    size--;
    keys[size] = null;
    values[size] = null;
    if (size > 0 && size == keys.length / four) {
      resize(keys.length / 2);
    }
  }
  /**
   * deletes the minimum value.
   */
  public void deleteMin() {
    if (!(isEmpty())) {
      delete(keys[0]);
    }
  }
  /**
   * Returns a string representation of the object.
   * Complexity N.
   * @return     String representation of the object.
   */
  public String toString() {
    String s = "";
    if (!isEmpty()) {
      for (int i = 0; i < size; i++) {
        s += keys[i] + " " + values[i] + "\n";
      }
      return s.substring(0, s.length() - 1);
    }
    return s;
  }
  /**
   * Gets the maximum.
   *
   * @return     The maximum.
   */
  public Key max() {
    return keys[size - 1];
  }
}

/**
 * Class for solution.
 */
public final class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {

  }
  /**
   * Main function to handle inputs and deliver outputs.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner scan = new Scanner(System.in);
    String[] line = scan.nextLine().split(" ");
    BinaryST<String, Integer> b = new BinaryST<String, Integer>();
    for (int i = 0; i < line.length; i++) {
      b.put(line[i], i);
    }
    while (scan.hasNext()) {
      String[] s = scan.nextLine().split(" ");
      switch (s[0]) {
      case "max":
        System.out.println(b.max());
        break;
      case "floor":
        System.out.println(b.floor(s[1]));
        break;
      case "rank":
        System.out.println(b.rank(s[1]));
        break;
      case "deleteMin":
        b.deleteMin();
        break;
      case "contains":
        System.out.println(b.contains(s[1]));
        break;
      case "keys":
        System.out.println(b.toString());
        break;
      case "get":
        System.out.println(b.get(s[1]));
        break;
      default:
        break;
      }
    }
  }
}


