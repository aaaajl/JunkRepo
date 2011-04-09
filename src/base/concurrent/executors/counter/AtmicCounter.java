/**
 * 
 */
package base.concurrent.executors.counter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lj04482
 *
 */
public class AtmicCounter implements Counter{

	AtomicInteger count = new AtomicInteger(0);
	public int increment() {
		return count.getAndIncrement();
	}
	public String getCounterName() {
		return "AtmicCounter";
	}

}
