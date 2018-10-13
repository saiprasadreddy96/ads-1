import java.util.Scanner;
class Stock {
	private String name;
	private float percentagechange;
	Stock(String name1, float percentagechange1) {
		name = name1;
		percentagechange = percentagechange1;
	}
	float getpercentagechange() {
		return percentagechange;
	}
	String getname() {
		return name;
	}
}
public class Solution {
	private Stock[] minstocks;
	private Stock[] maxstocks;
	private int minsize, maxsize;
	Solution(int n) {
		minstocks = new Stock[n + 1];
		maxstocks = new Stock[n + 1];
		minsize = 0;
		maxsize = 0;
	}
	void mininsert(Stock s) {
		int k;
		minstocks[++minsize] = s;
		k = minsize;
		while(k > 1 && minstocks[k].getpercentagechange() < minstocks[k / 2].getpercentagechange()) {
			Stock temps = minstocks[k];
			minstocks[k] = minstocks[k / 2];
			minstocks[k / 2] = temps;
			k = k / 2;
		}
	}
	void maxinsert(Stock s) {
		int k;
		maxstocks[++maxsize] = s;
		k = maxsize;
		while(k > 1 && maxstocks[k].getpercentagechange() > maxstocks[k / 2].getpercentagechange()) {
			Stock temps = maxstocks[k];
			maxstocks[k] = maxstocks[k / 2];
			maxstocks[k / 2] = temps;
			k = k / 2;
		}
	}

	Stock mindelete() {
		int j, k;
		Stock temps = minstocks[1];
		minstocks[1] = minstocks[minsize];
		j = 1;
		minsize = minsize - 1;
		while (j * 2 < minsize) {
			k = 2 * j;
			if (minstocks[k].getpercentagechange() > minstocks[k + 1].getpercentagechange()) 
				k = k + 1;
			if (minstocks[k].getpercentagechange() > minstocks[j].getpercentagechange())
				break;
			Stock temps1 = minstocks[k];
			minstocks[k] = minstocks[j];
			minstocks[j] = temps1;
			j = k;

		}
		return temps;
	}
	Stock maxdelete() {
		int j, k;
		Stock temps = maxstocks[1];
		maxstocks[1] = maxstocks[maxsize];
		j = 1;
		maxsize = maxsize - 1;
		while (j * 2 < maxsize) {
			k = 2 * j;
			if (maxstocks[k].getpercentagechange() < maxstocks[k + 1].getpercentagechange()) 
				k = k + 1;
			if (maxstocks[k].getpercentagechange() < maxstocks[j].getpercentagechange())
				break;
			Stock temps1 = maxstocks[k];
			maxstocks[k] = maxstocks[j];
			maxstocks[j] = temps1;
			j = k;

		}
		return temps;
	}
	public void printmin() {
		
		for (int i = 1; i <= 5; i++) {
			Stock temps = mindelete();
			System.out.println(temps.getname() + " " + temps.getpercentagechange());
		}
		System.out.println();
	}
	public void printmax() {
		for (int i = 1; i <= 5; i++) {
			Stock temps = maxdelete();
			System.out.println(temps.getname() + " " + temps.getpercentagechange());
		}
		System.out.println();
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		//Solution s = new Solution(n);
		for (int i = 1; i <= 6; i++) {
			Solution s = new Solution(n);
			for (int j = 1; j <= n; j++) {
				String[] str = sc.nextLine().split(",");
				s.mininsert(new Stock(str[0], Float.parseFloat(str[1])));
				s.maxinsert(new Stock(str[0], Float.parseFloat(str[1])));

			}
			
			s.printmax();
			s.printmin();
		}


		
	}
}