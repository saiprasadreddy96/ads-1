import java.util.Scanner;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Stack;
/**.
 * Class for add large numbers.
 */
class AddLargeNumbers {
    /**.
     * Constructs the object.
     */
    protected AddLargeNumbers() {
    }
    /**.
     * { function_description }
     *
     * @param      number  The number
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList<Integer> numberToDigits(final String number) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        for (int i = 0; i < number.length(); i++) {
            ll.addLast(Character.getNumericValue(number.charAt(i)));
        }
        return ll;
    }
    /**.
     * { function_description }
     *
     * @param      list  The list
     *
     * @return     { description_of_the_return_value }
     */
    public static String digitsToNumber(final LinkedList<Integer> list) {
        String str = "";
        Iterator it = list.listIterator(0);
        while (it.hasNext()) {
            str += it.next();
        }
        return str;
    }
    /**.
     * Adds large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList addLargeNumbers(final LinkedList<Integer> list1,
        final LinkedList<Integer> list2) {
        Stack<Integer> stack1 = converttostack(list1);
        Stack<Integer> stack2 = converttostack(list2);
        LinkedList<Integer> result1 = new LinkedList<Integer>();
        int carry = 0, a, b, c, d;
        final int ten = 10;
        while ((!stack1.isEmpty()) || (!stack2.isEmpty())) {
            if (stack1.isEmpty()) { 
                a = 0; 
            } else { 
                a = stack1.pop(); 
            }
            if (stack2.isEmpty()) { 
                b = 0; 
            } else { 
                b = stack2.pop(); 
            }
            d = a + b + carry;
            carry = (d) / ten;
            c = (d) % ten;
            result1.addFirst(c);
        }
        if (carry != 0) { result1.addFirst(carry); }
        return result1;
    }
    /**.
     * { function_description }
     *
     * @param      list  The list
     *
     * @return     { description_of_the_return_value }
     */
    public static Stack<Integer> converttostack(final
        LinkedList<Integer> list) {
        Stack<Integer> stack = new Stack<Integer>();
        Iterator<Integer> it = list.listIterator(0);
        while (it.hasNext()) {
            stack.push(it.next());
        }
        return stack;
    }
}
/**.
 * Class for solution.
 */
public class Solution {
    /**.
     * Constructs the object.
     */
    protected Solution() {
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input){
            case "numberToDigits":
                LinkedList<Integer> pDigits = 
                AddLargeNumbers.numberToDigits(p);
                LinkedList<Integer> qDigits = 
                AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;
            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = 
                AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
            default:
                break;
        }
    }
}



