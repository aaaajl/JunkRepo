/**
 * 
 */
package base.concurrent.executors.counter;

/**
 * @author lj04482
 *
 */
public class SyncMethodCounter implements Counter{
	public int count=0;
	public synchronized int increment() {
		return count++;
	}
	public String getCounterName() {
		return "SyncMethodCounter";
	}

}
