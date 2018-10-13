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
	private static String[] minkeys = new String[100];
	private static String[] maxkeys = new String[100];
	private int minsize, maxsize;
	private static int size1 = 0, size2 = 0;
	private static float[] minvalues = new float[100];
	private static float[] maxvalues = new float[100];
	Solution(int n) {
		minstocks = new Stock[n + 1];
		maxstocks = new Stock[n + 1];
		minsize = 0;
		maxsize = 0;
		//minkeys = new String[100];
		//minvalues = new float[100];
		//minsize1 = 0;

	}
	void mininsert(Stock s) {
		int k;
		minstocks[++minsize] = s;
		k = minsize;
		while(k > 1 && minstocks[k].getpercentagechange() <= minstocks[k / 2].getpercentagechange()) {
			if (minstocks[k].getpercentagechange() == minstocks[k / 2].getpercentagechange()) {
				if (minstocks[k].getname().compareTo(minstocks[k / 2].getname()) < 0) {
					Stock temps = minstocks[k];
					minstocks[k] = minstocks[k / 2];
					minstocks[k / 2] = temps;
					//k = k / 2;

				}
			} else {
				Stock temps = minstocks[k];
				minstocks[k] = minstocks[k / 2];
				minstocks[k / 2] = temps;
				//k = k / 2;
			}
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
			if (minstocks[k].getpercentagechange() >= minstocks[k + 1].getpercentagechange()) 
				k = k + 1;
			if (minstocks[k].getpercentagechange() >= minstocks[j].getpercentagechange())
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
			if (search(temps.getname()) == -1) {
				minkeys[size1] = temps.getname();
				minvalues[size1] = 1;
				size1 = size1 + 1;
				int z = size1 - 1;
				while (z > 0 && minkeys[z - 1].compareTo(minkeys[z]) > 0) {
					String s = minkeys[z-1];
					minkeys[z-1] = minkeys[z];
					minkeys[z] = s;
					float f = minvalues[z - 1];
					minvalues[z - 1] = minvalues[z];
					minvalues[z] = f;
					z = z - 1;
				}

			} else {
				int p = search(temps.getname());
				minvalues[p] = minvalues[p] + 1;

			}
			System.out.println(temps.getname() + " " + temps.getpercentagechange());
		}
		System.out.println();
	}
	public void printmax() {
		for (int i = 1; i <= 5; i++) {
			Stock temps = maxdelete();
			if (search1(temps.getname()) == -1) {
				maxkeys[size2] = temps.getname();
				maxvalues[size2] = 1;
				size2 = size2 + 1;
				int z = size2 - 1;
				while (z > 0 && maxkeys[z - 1].compareTo(maxkeys[z]) > 0) {
					String s = maxkeys[z-1];
					maxkeys[z-1] = maxkeys[z];
					maxkeys[z] = s;
					float f = maxvalues[z - 1];
					maxvalues[z - 1] = maxvalues[z];
					maxvalues[z] = f;
					z = z - 1;
				}

			} else {
				int p = search1(temps.getname());
				maxvalues[p] = maxvalues[p] + 1;

			}
			System.out.println(temps.getname() + " " + temps.getpercentagechange());
		}
		System.out.println();
	}
	static int search(String str) {
		int l = 0, h = size1 - 1;
		while (l <= h) {
			int m = (l + h) / 2;
			if (minkeys[m].compareTo(str) < 0) 
				l = m + 1;
			else if (minkeys[m].compareTo(str) > 0)
				h = m - 1;
			else 
				return m;
		}
		return -1;
	}
	static int search1(String str) {
		int l = 0, h = size2 - 1;
		while (l <= h) {
			int m = (l + h) / 2;
			if (maxkeys[m].compareTo(str) < 0) 
				l = m + 1;
			else if (maxkeys[m].compareTo(str) > 0)
				h = m - 1;
			else 
				return m;
		}
		return -1;
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
		int n1 = Integer.parseInt(sc.nextLine());
		
		
		// for (int i = 0; i < size2 ;i++) {
		// 	System.out.println(maxkeys[i] + " " + maxvalues[i]);
			
		// }
		// System.out.println();
		// System.out.println();
		// for (int i = 0; i < size1; i++) {
		// 	System.out.println(minkeys[i] + " " + minvalues[i]);
		// 	//System.out.println(maxkeys[i] + " " + maxvalues[i]);
		// }
		while (n1 > 0) {
			String[] string1 = sc.nextLine().split(",");
			if (string1[1].equals("minST")) {
				int index = search(string1[2]);
				if (index != -1)
					System.out.println(Math.round(minvalues[index]));
				else
					System.out.println("0");
				
					


			}
			 if (string1[1].equals("maxST")){
				int index = search1(string1[2]);
				if (index != -1)
					System.out.println(Math.round(maxvalues[index]));
				else
					System.out.println("0");
				
			}
			n1 = n1 - 1;
		}

		
	}
}