/**
 * 
 */
package algorithm.sort;

/**
 * @author aaaajl
 * 
 */
public class SortUtil {
	public static void swap(Comparable[] data, int i, int j) throws Exception {
		int len = data.length - 1;
		if (i < 0 || i > len)
			throw new Exception("i:" + i + "is invailed");
		if (j < 0 || j > len)
			throw new Exception("j:" + j + "is invailed");
		Comparable temp = null;
		temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public static void print(Comparable[] data) {
		for (int i = 0, len = data.length; i < len; i++) {
			System.out.print(data[i] + ",");
		}
	}

}
