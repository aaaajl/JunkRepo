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
	@Override
	public int increment() {
		return count.getAndIncrement();
	}
	@Override
	public String getCounterName() {
		return "AtmicCounter";
	}

}
