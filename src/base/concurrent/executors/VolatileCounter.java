/**
 * 
 */
package base.concurrent.executors;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * @author lj04482
 *
 */
public class VolatileCounter implements Runnable {

	CountDownLatch latch = null;
	
	public VolatileCounter(CountDownLatch latch) {
		this.latch = latch;
	}
	public static volatile int count=0;
	/* (non-Javadoc)
	 * @see java.util.concurrent.Executor#execute(java.lang.Runnable)
	 */
	@Override
	public void run() {
		count++;
		latch.countDown();
	}

}
