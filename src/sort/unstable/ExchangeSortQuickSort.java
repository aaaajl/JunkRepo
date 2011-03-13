/**
 * 
 */
package sort.unstable;

import sort.SortUtil;
import sort.stable.InsertionSortInsertion;

/**
 * @author aaaajl
 *
 */
public class ExchangeSortQuickSort {

	public static void sort(Comparable[] data) throws Exception
	{
		long start = System.nanoTime();
		int len = data.length-1;
		quickSort(data,0,len);
		long end = System.nanoTime();
		System.out.println("\nQuickSort Execute time:"+(end-start));
	}

	private static void quickSort(Comparable[] data, int begin, int end) throws Exception {
//		if((end-begin+1)<=4)
//		{
//			InsertionSortInsertion.sort(data);
//		}else{
			int pivotIndex = getPivot(data,begin,end);
			Comparable pivot = data[pivotIndex];
			int low = begin;
			int high = end;
			while(low<=high)
			{
				while(data[low].compareTo(pivot)<0)
				{
					low++;
				}
				while(data[high].compareTo(pivot)>0){
					high--;
				}
				if(low<=high)
				{
					SortUtil.swap(data, low, high);
					low++;
					high--;
				}
			}
			if(begin<high)
			{
				quickSort(data, begin, high);
			}
			if(low<end)
			{
				quickSort(data, low, end);
			}
			
//		}
		
		
	}

	private static int getPivot(Comparable[] data, int begin, int end) {
//		int returnValue = -1;
//		int mid = (begin+end)/2;
//		Comparable a =data[begin];
//		Comparable b= data[mid];
//		Comparable c = data[end];
//		Comparable[] subData = {a,b,c};
//		Comparable[] subDataCopy = subData.clone();
//		InsertionSortInsertion.sort(subDataCopy);
//		Comparable tmp = subDataCopy[1];
//		if(tmp.compareTo(a)==0){
//			returnValue = begin;
//		}else if(tmp.compareTo(b)==0)
//		{
//			returnValue = mid;
//		}else if(tmp.compareTo(c)==0){
//			returnValue = end;
//		}
		return (begin+end)/2;
	}
	
}
