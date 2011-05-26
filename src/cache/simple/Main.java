/**
 * 
 */
package cache.simple;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lj04482
 * 
 */
public class Main {
	public static void main(String[] args) {
		FutureTask<String> ft = new FutureTask<String>(new Callable<String>() {

			@Override
			public String call() throws Exception {
				String value = "tttt";
				return value;
			}
		});
		try {
			ft.run();
			System.out.println(ft.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
