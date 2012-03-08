/**
 * 
 */
package base.constructor;

/**
 * @author fanghui.jl
 *
 */
public class Child extends Father {

	int a = 1;
	long b = 10;
	static double c = 20;

	private Child() {
		super();
		System.out.println("a:" + a);
		System.out.println("b:" + b);
		System.out.println("c:" + c);
		a = 2;
		b = 11;
		c = 21;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Child child = new Child();
		System.out.println("a:" + child.a);
		System.out.println("b:" + child.b);
		System.out.println("c:" + child.c);

	}

}
