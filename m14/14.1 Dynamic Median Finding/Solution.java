import java.util.Scanner;
/**
 *the class is for performing dynamic median.
 */
class DynamicMedian {
    /**
     *the object to access of minheap.
     */
    private MinPQ<Double> min;
    /**
     *the object to access of maxheap.
     */
    private MaxPQ<Double> max;
    /**
     *the constructor for initializing.
     */
    DynamicMedian() {
        min = new MinPQ<Double>();
        max = new MaxPQ<Double>();
    }
    /**
     * the method will insert the element
     * to minheap.
     * This method works with time complexity of O(lgN) as asked.
     * @param      item  The item
     */
    public void insertAtMin(final double item) {
        min.insert(item);
    }
    /**
     * the method will insert the element
     * to maxheap.
     * This method works with time complexity of O(lgN) as asked.
     * @param      item  The item
     */
    public void insertAtMax(final double item) {
        max.insert(item);
    }
    /**
     * this method gets the minimum element.
     * from minheap.
     * O(1) for any case.
     * @return     The minimum.
     */
    public double getMin() {
        return min.min();
    }
    /**
     * this method gets the maximum element.
     * from maxheap.
     * O(1) for any case.
     * @return     The minimum.
     */
    public double getMax() {
        return max.max();
    }
    /**
     * this method delete the maximum element.
     * from maxheap.
     * This method works with time complexity of O(lgN) as asked.
     * @return     The minimum.
     */
    public double delMax() {
        return max.delMax();
    }
    /**
     * this method delete the minimum element.
     * from maxheap.
     * This method works with time complexity of O(lgN) as asked.
     * @return     The minimum.
     */
    public double delMin() {
        return min.delMin();
    }
    /**
     * gets the size of minheap.
     * O(1) for any case.
     * @return     The minimum size.
     */
    public int getMinSize() {
        return min.size();
    }
    /**
     * Gets the maximum size of maxheap.
     * O(1) for any case.
     * @return     The maximum size.
     */
    public int getMaxSize() {
        return max.size();
    }
}
/**
 *this class is for main method.
 */
final class Solution {
    /**
     *an empty constructor.
     */
    private Solution() {
    }
    /**
     * the main method is to.
     * take the input from user and calculate the median.
     * The time complexity for the median calculation is O(1).
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        DynamicMedian obj = new DynamicMedian();
        long inputs = scan.nextLong();
        double element = scan.nextDouble();
        obj.insertAtMin(element);
        double median = element;
        System.out.println(median);
        for (long i = 1; i < inputs; i++) {
            double input = scan.nextDouble();
            if (input > median) {
                obj.insertAtMin(input);
            } else if (input < median) {
                obj.insertAtMax(input);
            } else {
                obj.insertAtMin(input);
            }
            if (obj.getMinSize() - obj.getMaxSize() > 1) {
                obj.insertAtMax(obj.delMin());
            }
            if (obj.getMaxSize() - obj.getMinSize()  > 1) {
                obj.insertAtMin(obj.delMax());
            }
            if (Math.abs(
                        obj.getMinSize() - obj.getMaxSize()) == 1) {
                if (obj.getMinSize() > obj.getMaxSize()) {
                    median = obj.getMin();
                    System.out.println(median);
                } else {
                    median = obj.getMax();
                    System.out.println(median);
                }
            }
            if (obj.getMinSize()  == obj.getMaxSize()) {
                double min = obj.getMin();
                double max = obj.getMax();
                // System.out.println(min + " " + max);
                median = (min + max) / 2.0;
                System.out.println(median);
            }
        }
    }
}