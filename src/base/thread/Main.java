/**
 * 
 */
package base.thread;

/**
 * @author lj04482
 *
 */
public class Main {
	
	public static void main(String[] args) {
		System.out.println("----------Print out by BaseThread----------");
		BaseThread bt = new BaseThread("aaaa");
		Thread t = new Thread(bt);
		bt.run();
		t.run();
		t.start();
	}
	
	
}
