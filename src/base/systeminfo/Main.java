/**
 * 
 */
package base.systeminfo;

/**
 * @author fanghui.jl
 *
 */
public class Main {

	public static void main(String[] args) {

		System.out.println("CPU:" + Runtime.getRuntime().availableProcessors());
		System.out.println("FreeMemory:" + Runtime.getRuntime().freeMemory());
		System.out.println("MaxMemory:" + Runtime.getRuntime().maxMemory());
		System.out.println("TotalMemory:" + Runtime.getRuntime().totalMemory());
	}
}
