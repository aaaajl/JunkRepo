/**
 * 
 */
package algorithm.interview;


/**
 * @author lj04482
 * 
 */
public class AlgorithmMain {

	public static void nineNineMulitTable() {
		for (int i = 1, j = 1; j <= 9; i++) {
			System.out.print(i + "*" + j + "=" + i * j + " ");
			if (i == j) {
				i = 0;
				j++;
				System.out.println();
			}
		}
	}

	public static boolean isPrimeNumber(int number) {
		double end = Math.sqrt(number);
		for (int i = 2; i < end; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static int nextPrime(int number) {
		long start = System.nanoTime();
		int value = -1;
		for (int i = (number + 1);; i++) {
			if (isPrimeNumber(i)) {
				value = i;
				break;
			}
		}
		long end = System.nanoTime();
		System.out.println("Cost time:" + (end - start));
		return value;
	}

	// Greatest Common Divisor
	public static int divisor(int m, int n) {
		if (m % n == 0) {
			return n;
		} else {
			return divisor(n, m % n);
		}
	}

	// lowest common multiple
	public static int gbs(int a, int b) {
		int gbs = 0;
		gbs = a * b / divisor(a, b);
		return gbs;
	}

	public static void main(String[] args) {
		System.out.println(AlgorithmMain.divisor(99, 30));

	}
}
