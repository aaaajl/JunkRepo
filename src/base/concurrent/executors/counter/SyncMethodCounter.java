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
	@Override
	public synchronized int increment() {
		return count++;
	}
	@Override
	public String getCounterName() {
		return "SyncMethodCounter";
	}

}
