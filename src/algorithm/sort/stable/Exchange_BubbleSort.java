/**
 * 
 */
package algorithm.sort.stable;

import algorithm.sort.SortUtil;

/**
 * @author aaaajl
 * 
 */
public class Exchange_BubbleSort {
	/**
	 * Worst case performance O(n2) Best case performance O(n) Average case
	 * performance O(n2) Worst case space complexity O(1) auxiliary
	 * */
	public static void sort(Comparable[] data) throws Exception {
		long start = System.nanoTime();
		for (int i = 0, ilen = data.length; i < ilen; i++) {
			for (int j = 0, jlen = (ilen - i - 1); j < jlen; j++) {
				if (data[j].compareTo(data[j + 1]) > 0) {
					SortUtil.swap(data, j, j + 1);
				}
			}
		}
		long end = System.nanoTime();
		System.out.println("\nBubbleSort Execute time:" + (end - start));
	}
}
