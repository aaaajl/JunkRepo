/**
 * 
 */
package sort.stable;

import sort.SortUtil;

/**
 * @author aaaajl
 *
 */
public class Exchange_BubbleSort {
	/**
	 * Worst case performance	O(n2)
	 * Best case performance	O(n)
	 * Average case performance	O(n2)
	 * Worst case space complexity	O(1) auxiliary
	 * */
	public static void sort(Comparable []data) throws Exception
	{
		long start = System.nanoTime();
		int len = data.length;
		for(int i=0;i<len;i++)
		{
			for(int j=0;j<(len-i-1);j++)
			{
				if(data[j].compareTo(data[j+1])>0)
				{
					SortUtil.swap(data, j, j+1);
				}
			}
		}
		long end = System.nanoTime();
		System.out.println("\nBubbleSort Execute time:"+(end-start));
	}
}
