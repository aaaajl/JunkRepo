/**
 * 
 */
package sort.stable;

import sort.SortUtil;

/**
 * @author aaaajl
 *
 */
public class Exchange_CocktailSort {
	/**
	 * Worst case performance	O(n2)
	 * Best case performance	O(n)
	 * Average case performance	O(n2)
	 * */
	public static void sort(Comparable []data) throws Exception{
		long start = System.nanoTime();
		int bottom =0;
		int top=data.length;
		boolean swap = true;
		while(swap){
			swap = false;
			for(int i=bottom;i<top-2;i++)
			{
				if(data[i].compareTo(data[i+1])>0)
				{
					SortUtil.swap(data, i, i+1);
					swap=true;
				}
			}
			top--;
			for(int j=top;j>bottom;j--)
			{
				if(data[j].compareTo(data[j-1])<0)
				{
					SortUtil.swap(data, j, j-1);
					swap=true;
				}
			}
			bottom++;
		}
		long end = System.nanoTime();
		System.out.println("\nCocktailSort Execute time:"+(end-start));
	}
}
