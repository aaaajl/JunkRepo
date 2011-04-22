/**
 * 
 */
package algorithm.interview;

/**
 * @author lj04482
 * 
 */
public class BinarySearch {

	public static int binarySearch(int[] dataset, int data, int beginIndex, int endIndex) {
		int midIndex = (beginIndex + endIndex) / 2;
		if (beginIndex > endIndex || data < dataset[beginIndex] || data > dataset[endIndex]) {
			return -1;
		}
		if (data < dataset[midIndex]) {
			return binarySearch(dataset, data, beginIndex, midIndex);
		} else if (data > dataset[midIndex]) {
			return binarySearch(dataset, data, midIndex, endIndex);
		} else {
			return midIndex;
		}
	}

	public int binarySearch(int[] dataset, int data) {
		int beginIndex = 0;
		int endIndex = dataset.length - 1;
		int midIndex = -1;
		if (data < dataset[beginIndex] || data > dataset[endIndex] || beginIndex > endIndex) {
			return -1;
		}
		while (beginIndex <= endIndex) {
			midIndex = (beginIndex + endIndex) / 2;
			if (data < dataset[midIndex]) {
				endIndex = midIndex - 1;
			} else if (data > dataset[midIndex]) {
				beginIndex = midIndex + 1;
			} else {
				return midIndex;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 7, 10, 35, 47, 60, 63, 87, 90 };
		long start = System.nanoTime();
		System.out.println(binarySearch(arr, 63, 0, arr.length - 1));
		long end = System.nanoTime();
		System.out.println("Recursion cost time:" + (end - start));

		start = System.nanoTime();
		System.out.println(binarySearch(arr, 63, 0, arr.length - 1));
		end = System.nanoTime();
		System.out.println("Cost time:" + (end - start));
	}
}
