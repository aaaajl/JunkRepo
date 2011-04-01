/**
 * 
 */
package algorithm.sort.stable;

/**
 * @author aaaajl
 *
 */
public class Insertion_InsertionSort {
	/**
	 * Worst case performance	O(n2)
	 * Best case performance	O(n)
	 * Average case performance	O(n2)
	 * Worst case space complexity	O(n) total, O(1) auxiliary
	 * */
	public static void sort(Comparable[] data)
	{
		long start = System.nanoTime();
		int len = data.length;
		for(int i=1;i<len;i++)
		{
			Comparable c= data[i];
			int position = 0;
			for(position=i-1;position>=0;position--)
			{
				if(c.compareTo(data[position])<0)
				{
					data[position+1]=data[position];
				}else{
					break;
				}
			}
			data[position+1] =c;
			
		}
		long end = System.nanoTime();
		System.out.println("\nInsertionSort Execute time:"+(end-start));
	}
}
