/**
 * 
 */
package base.concurrent.executors.counter;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @author lj04482
 *
 */
public class ReentrantLockCounter implements Counter {

	private int count;
	
	private WriteLock lock = new ReentrantReadWriteLock().writeLock();
	@Override
	public int increment() {
		lock.lock();
		try {
			return count++;
		}finally{
			lock.unlock();
		}
	}

	@Override
	public String getCounterName() {
		return "ReentrantLockCounter";
	}

}
