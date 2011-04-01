/**
 * 
 */
package algorithm.sort;

import algorithm.sort.stable.Exchange_BubbleSort;
import algorithm.sort.stable.Exchange_CocktailSort;
import algorithm.sort.stable.Insertion_InsertionSort;
import algorithm.sort.stable.Merge_MergeSort;
import algorithm.sort.unstable.Exchange_QuickSort;
import algorithm.sort.unstable.Selection_HeapSort;
import algorithm.sort.unstable.Selection_SelectionSort;

/**
 * @author aaaajl
 *
 */
public class Main {
	public static void main(String[] args) {
		Comparable []data = {4,6,5,64,8,9,15,3,56,768,5679,87,9,89,30,23,12,38,86,90,45,23,78,32,43,54,65,76,876,98,5768,435,245,647,678,987,2345,2,34556,5,234,56785,46464,6423,45643,4578,6564,2234,3456756,43,4,8,78689,190,6575,89,4,6,5,64,8,9,15,3,56,768,5679,87,9,89,30,23,12,38,86,90,45,23,78,32,43,54,65,76,876,98,5768,435,245,647,678,987,2345,2,34556,5,234,56785,46464,6423,45643,4578,6564,2234,3456756,43,4,8,78689,190,6575,89,4,6,5,64,8,9,15,3,56,768,5679,87,9,89,30,23,12,38,86,90,45,23,78,32,43,54,65,76,876,98,5768,435,245,647,678,987,2345,2,34556,5,234,56785,46464,6423,45643,4578,6564,2234,3456756,43,4,8,78689,190,6575,89,4,6,5,64,8,9,15,3,56,768,5679,87,9,89,30,23,12,38,86,90,45,23,78,32,43,54,65,76,876,98,5768,435,245,647,678,987,2345,2,34556,5,234,56785,46464,6423,45643,4578,6564,2234,3456756,43,4,8,78689,190,6575,89};
//		Comparable []data = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		try {
			SortUtil.print(data);
			Comparable []c = data.clone();
			Exchange_BubbleSort.sort(c);
			SortUtil.print(c);
			c = data.clone();
			Exchange_CocktailSort.sort(c);
			SortUtil.print(c);
			c = data.clone();
			Selection_SelectionSort.sort(c);
			SortUtil.print(c);
			c = data.clone();
			Insertion_InsertionSort.sort(c);
			SortUtil.print(c);
			c = data.clone();
			Merge_MergeSort.sort(c);
			SortUtil.print(c);
			c = data.clone();
			Exchange_QuickSort.sort(c);
			SortUtil.print(c);
			c = data.clone();
			Selection_HeapSort.sort(c);
			SortUtil.print(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
