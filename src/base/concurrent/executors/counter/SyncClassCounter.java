/**
 * 
 */
package base.concurrent.executors.counter;

/**
 * @author lj04482
 *
 */
public class SyncClassCounter implements Counter {

	private int count;
	public int increment() {
		synchronized (SyncClassCounter.class) {
			return count++;
		}
	}
	public String getCounterName() {
		return "SyncClassCounter";
	}
}
