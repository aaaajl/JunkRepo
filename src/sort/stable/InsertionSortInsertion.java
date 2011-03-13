/**
 * 
 */
package sort.stable;

import sort.SortUtil;

/**
 * @author aaaajl
 *
 */
public class InsertionSortInsertion {

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
