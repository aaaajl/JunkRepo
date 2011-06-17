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
		final Thread t = new Thread() {
			public void run() {
				try {
					Thread.currentThread().sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print("aaaa");
			};
		};

		Thread t1 = new Thread() {
			public void run() {
				t.yield();
				System.out.print("bbbb");
			};
		};
		t.start();
		t1.start();
	}

}
