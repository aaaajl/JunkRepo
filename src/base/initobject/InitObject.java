/**
 * 
 */
package base.initobject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fanghui.jl
 *
 */
public class InitObject {

	private static InitObject obj = null;
	private static AtomicBoolean isInit = new AtomicBoolean(false);
	private static AtomicBoolean isFinish = new AtomicBoolean(false);
	private static AtomicInteger ai = new AtomicInteger(0);
	private static ReentrantLock lock = new ReentrantLock();
	private final int a = 2;

	private InitObject() {
		super();
	}

	public static InitObject getInstance1() {
		long start = System.nanoTime();
		lock.lock();
		boolean a = isInit.compareAndSet(false, true);
		System.out.println("instance1:" + a);
		if (a) {
			obj = new InitObject();
		}
		lock.unlock();
		System.out.println("getInstance1 cost:" + (System.nanoTime() - start));
		return obj;
	}

	public static InitObject getInstance2() {
		long start = System.nanoTime();
		boolean a = ai.compareAndSet(0, 1);
		System.out.println("instance2:" + a);
		if (!isFinish.get()) {
			if (a) {
				obj = new InitObject();
				isFinish.compareAndSet(false, true);
			}
		}
		System.out.println("getInstance2 cost:" + (System.nanoTime() - start));
		return obj;
	}

	public static void main(String[] args) {
		ExecutorService e = Executors.newCachedThreadPool();
		for (int i = 0; i < 30; i++) {
			e.submit(new Runnable() {

				@Override
				public void run() {
					InitObject.getInstance2();
					InitObject.getInstance1();
				}
			});
		}
		e.shutdown();
	}
}
