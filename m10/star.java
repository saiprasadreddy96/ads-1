import java.util.Scanner;

public final class star {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(star(sc.next()));
	}
	
	private static String star(String s) {
		if (s.length() == 1) {
			return s;
		} 
		else if (s.charAt(s.length() - 1) == s.charAt(s.length() - 2)) {
			return star(s.substring(0, s.length() - 1)) + "*" + s.charAt(s.length() - 1);
		} else {
			return star(s.substring(0, s.length() - 1)) + s.charAt(s.length() - 1);
		}
	}
}