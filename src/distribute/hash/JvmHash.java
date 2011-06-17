/**
 * 
 */
package distribute.hash;


/**
 * @author lj04482
 * 
 */
public class JvmHash {

	public static int CHM_hash(int h) {
		h += (h << 15) ^ 0xffffcd7d;
		h ^= (h >>> 10);
		h += (h << 3);
		h ^= (h >>> 6);
		h += (h << 2) + (h << 14);
		return h ^ (h >>> 16);
	}

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE + " " + Integer.MIN_VALUE);
		System.out.println(JvmHash.CHM_hash(1));
	}
}
