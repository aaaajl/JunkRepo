/**
 * 
 */
package base.concurrent.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lj04482
 * 
 */
public class CallableImpl implements Callable<Integer> {
	private int myName;

	CallableImpl(int i) {
		myName = i;
	}

	public Integer call() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread : " + getMyName() + " I is : " + i);
		}
		return new Integer(getMyName());

	}

	public int getMyName() {
		return myName;
	}

	public void setMyName(int myName) {
		this.myName = myName;
	}

	public static void main(String[] args) {
		Callable<Integer> callable = new CallableImpl(2);

		ExecutorService executor = new ScheduledThreadPoolExecutor(5);
		Future<Integer> future = executor.submit(callable);
		try {
			System.out.println("Future value: " + future.get(50, TimeUnit.SECONDS));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Do somthing else");
	}
}