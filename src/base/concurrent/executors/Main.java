/**
 * 
 */
package base.concurrent.executors;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import sun.misc.GC.LatencyRequest;

/**
 * @author lj04482
 * 
 */
public class Main {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(100);
		CountDownLatch cdl = new CountDownLatch(100000);
		Runnable r = new VolatileCounter(cdl);
		es.execute(r);
	}
}
