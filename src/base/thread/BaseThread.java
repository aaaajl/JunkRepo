/**
 * 
 */
package base.thread;

/**
 * @author lj04482
 *
 */
public class BaseThread implements Runnable {

	private String internalValue;
	public BaseThread(String value) {
		internalValue = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName()+":"+internalValue);

	}

}
