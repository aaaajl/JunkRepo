/**
 * 
 */
package base.concurrent.executors;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import base.concurrent.executors.counter.AtmicCounter;
import base.concurrent.executors.counter.Counter;
import base.concurrent.executors.counter.ReentrantLockCounter;
import base.concurrent.executors.counter.SyncClassCounter;
import base.concurrent.executors.counter.SyncMethodCounter;
import base.concurrent.executors.counter.SyncObjectCounter;
import base.concurrent.executors.counter.VolatileCounter;

/**
 * @author lj04482
 * 
 */
public class Main {

	public static void runCounter(Executor executor,final Counter counter) throws Exception
	{
		long start = System.currentTimeMillis();
		
		int loop = 400000;
		final CountDownLatch latch = new CountDownLatch(loop);
		for(int i=0;i<loop;i++)
		{
			executor.execute(new Runnable() {
				
				@Override
				public void run() {
					counter.increment();
					latch.countDown();
				}
			});
		}
		System.out.println("Thread:"+ Thread.activeCount());
		latch.await();
		long end = System.currentTimeMillis();
		System.out.println("Count:"+counter.increment());
		System.out.println(counter.getCounterName()+" Cost time:"+(end-start));
	}
	
	public static void main(String[] args) throws Exception {
		ExecutorService es = Executors.newFixedThreadPool(100);
		Counter volatileCounter = new VolatileCounter();
		Counter synMethodCounter = new SyncMethodCounter();
		Counter synObjCounter = new SyncObjectCounter();
		Counter synClazCounter = new SyncClassCounter();
		Counter atmiCounter = new AtmicCounter();
		Counter writelockCounter = new ReentrantLockCounter();
		runCounter(es ,volatileCounter);
		runCounter(es ,synMethodCounter);
		runCounter(es ,synObjCounter);
		runCounter(es ,synClazCounter);
		runCounter(es ,atmiCounter);
		runCounter(es ,writelockCounter);
		es.shutdown();
	}
}
