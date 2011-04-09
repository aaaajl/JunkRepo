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

	public int increment() {
		return count++;
	}

	public String getCounterName() {
		return "VolatileCounter";
	}
	
	
}
