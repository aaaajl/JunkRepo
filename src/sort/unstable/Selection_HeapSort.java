/**
 * 
 */
package sort.unstable;

import sort.SortUtil;

/**
 * @author lj04482
 *
 */
public class Selection_HeapSort {
	public static void sort(Comparable[] data) throws Exception
	{
		long start = System.nanoTime();
		int len = data.length;
		buildMaxHeapify(data,len);
		while(len>0)
		{
			len--;
			SortUtil.swap(data, 0, len);
			maxHeapify(data,0,len);
		}
		long end = System.nanoTime();
		System.out.println("\nHeapSort Execute time:"+(end-start));
	}

	private static void buildMaxHeapify(Comparable[] data, int len) throws Exception {
		for(int i=len/2-1;i>=0;i--)
		{
			maxHeapify(data,i,len);
		}
		
	}

	private static void maxHeapify(Comparable[] data, int vertices,int len) throws Exception {
		int tmpIndex = vertices*2 +1;
		while(tmpIndex<len)
		{
			if(tmpIndex+1<len)
			{
				if(data[tmpIndex+1].compareTo(data[tmpIndex])>0)
				{
					tmpIndex++;
				}
			}
			if(data[tmpIndex].compareTo(data[vertices])>0)
			{
				SortUtil.swap(data, tmpIndex, vertices);
				vertices = tmpIndex;
				tmpIndex = vertices*2 +1;
			}else{
				return;
			}
		}
	}
}
