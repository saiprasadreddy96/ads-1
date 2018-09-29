import java.util.Scanner;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Stack;
/**.
 * Class for add large numbers.
 */
class AddLargeNumbers {
	public static LinkedList<Integer> numberToDigits(String number) {
    	LinkedList<Integer> ll = new LinkedList<Integer>();
    	for (int i = 0; i < number.length(); i++) {
    		ll.addLast(Character.getNumericValue(number.charAt(i)));
    	}
    	return ll;

    }

    public static String digitsToNumber(LinkedList<Integer> list) {
    	String str = "";
    	Iterator it = list.listIterator(0);
    	while (it.hasNext()) {
    		str += it.next();
    	}
    	return str;

    }

    public static LinkedList addLargeNumbers(LinkedList<Integer> list1, LinkedList<Integer> list2) {
    	Stack<Integer> stack1 = converttostack(list1);
    	Stack<Integer> stack2 = converttostack(list2);
    	LinkedList<Integer> result1 = new LinkedList<Integer>();
    	int carry = 0, a, b, c, d;
    	while ((!stack1.isEmpty()) || (!stack2.isEmpty())) {
    		if (stack1.isEmpty()) { a = 0; } else { a = stack1.pop(); }
    		if (stack2.isEmpty()) { b = 0; } else { b = stack2.pop(); }
    		d = a + b + carry;
    		carry = (d) / 10;
    		c = (d) % 10;
    		result1.addFirst(c);

    	}
    	if (carry != 0) result1.addFirst(carry);
    	return result1;

    }
    public static Stack<Integer> converttostack(LinkedList<Integer> list) {
    	Stack<Integer> stack = new Stack<Integer>();
    	Iterator<Integer> it = list.listIterator(0);
    	while (it.hasNext()) {
    		stack.push(it.next());
    	}
    	return stack;

    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList<Integer> pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList<Integer> qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
