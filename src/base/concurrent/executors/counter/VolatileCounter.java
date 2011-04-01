/**
 * 
 */
package base.concurrent.executors.counter;


/**
 * @author lj04482
 *
 */
public class VolatileCounter implements Counter{

	public volatile int count=0;

	@Override
	public int increment() {
		return count++;
	}

	@Override
	public String getCounterName() {
		return "VolatileCounter";
	}
	
	
}
