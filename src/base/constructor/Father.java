/**
 * 
 */
package base.constructor;

/**
 * @author fanghui.jl
 *
 */
public class Father {

	/**
	 * 
	 */
	public Father() {
		System.out.println("a:" + ((Child) this).a);
		System.out.println("b:" + ((Child) this).b);
		System.out.println("c:" + ((Child) this).c);
	}

}
