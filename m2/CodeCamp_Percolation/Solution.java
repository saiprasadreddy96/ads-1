// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem
// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }
// You can implement the above API to solve the problem
import java.util.Scanner;
class Percolation {
	private boolean grid[][];
	private final int size;
	private WeightedQuickUnionUF wqu;
	Percolation(int size1) {
		this.size = size1;
		grid = new boolean[size][size];
		wqu = new WeightedQuickUnionUF(size * size + 2);
		//size = 0;
	}
	// public Percolation(int n) {
	// 	//int[][] grid = new int[n];
	// 	grid = new boolean[n][n];
	// 	for (int i = 1; i <= n; i++) {
	// 		for (int j = 1; j <= n; j++) {
	// 			grid[i][j] = false;
	// 		}
	// 	}
	// }
	public void open(int row, int col) {
		if (grid[row][col]) {
            return;
        }
        grid[row][col] = true;
        if (row == 0) {
            wqu.union(convert(row, col), size * size);
        }
        if (row == size - 1) {
            wqu.union(convert(row, col), size * size + 1);
        }
        if (row < size - 1 && grid[row + 1][col]) { //bottom element
            wqu.union(convert(row, col), convert(row + 1, col));
        }
        if (row > 0 && grid[row - 1][col]) { //top element
            wqu.union(convert(row, col), convert(row - 1, col));
        }
        if (col > 0 && grid[row][col - 1]) { //left element
            wqu.union(convert(row, col), convert(row, col - 1));
        }
        if (col < size - 1 && grid[row][col + 1]) { //right element
            wqu.union(convert(row, col), convert(row, col + 1));
        }
	}
	public int convert(final int i, final int j) {
        return i * size + j;
    }
     public boolean ispercolate() {
        return wqu.connected(size * size, size * size + 1);
    }
	
}
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int lines = Integer.parseInt(scan.nextLine());
		Percolation wqu = new Percolation(lines);
		while (scan.hasNextLine()) {
			String[] inputs = scan.nextLine().split(" ");
			wqu.open(Integer.parseInt(inputs[0]) - 1, Integer.parseInt(inputs[1]) - 1);
		}
		System.out.println(wqu.ispercolate());
	}
}

// import java.util.Scanner;
// /**.
// Solution the class for inputs
// */
// class Solution {
// /**.
// @Solution() the constructor
// */
//     Solution() {

//     }
// /**.
// @param args the arguments
// */
//     public static void main(final String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int input = Integer.parseInt(sc.nextLine());
//         Percolate obj = new Percolate(input);
//         while (sc.hasNextLine()) {
//             String[] inputs = sc.nextLine().split(" ");
//             obj.open(Integer.parseInt(
//                 inputs[0]) - 1, Integer.parseInt(inputs[1]) - 1);
//         }
//         System.out.println(obj.ispercolate());
//     }
// }
// /**.
// Percolate the class
// */
// class Percolate {
// /**.
// grid[][] the boolean array.
// obj the object of type class.
// size the size of the array
// */
//     private boolean[][] grid;
//     private WeightedQuickUnionUF obj;
//     private final int size;
// /**.
//     Percolate() the constructor
// */
//     Percolate(int size1) {
//         this.size = size1;
//         grid = new boolean[size][size];
//         obj = new WeightedQuickUnionUF(size * size + 2);
//     }
// /**.
// @open() the function to open the sites
// */
//     public void open(final int row, final int column) {
//         if (grid[row][column]) {
//             return;
//         }
//         grid[row][column] = true;
//         if (row == 0) {
//             obj.union(convert(row, column), size * size);
//         }
//         if (row == size - 1) {
//             obj.union(convert(row, column), size * size + 1);
//         }
//         if (row < size - 1 && grid[row + 1][column]) { //bottom element
//             obj.union(convert(row, column), convert(row + 1, column));
//         }
//         if (row > 0 && grid[row - 1][column]) { //top element
//             obj.union(convert(row, column), convert(row - 1, column));
//         }
//         if (column > 0 && grid[row][column - 1]) { //left element
//             obj.union(convert(row, column), convert(row, column - 1));
//         }
//         if (column < size - 1 && grid[row][column + 1]) { //right element
//             obj.union(convert(row, column), convert(row, column + 1));
//         }
//     }
// /**.
// @ispercolate() the function for validating the percolation
// @return returns the connections.
// */
//     public boolean ispercolate() {
//         return obj.connected(size * size, size * size + 1);
//     }

//     public int convert(final int i, final int j) {
//         return i * size + j;
//     }
// }