/**
 * 
 */
package base.concurrent.executors.counter;

/**
 * @author lj04482
 *
 */
public class SyncObjectCounter implements Counter {

	private int count;
	/* (non-Javadoc)
	 * @see base.concurrent.executors.counter.Counter#increment()
	 */
	public int increment() {
		synchronized (this) {
			return count++;
		}
	}
	public String getCounterName() {
		return "SyncObjectCounter";
	}

}
