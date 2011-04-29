/**
 * 
 */
package base.socket.custom.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author lj04482
 * 
 */
public class HelloClient {

	public static void main(String args[]) {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		try {
			Registry registry = LocateRegistry.getRegistry(9999);
			Hello obj = (Hello) registry.lookup("Hello");
			for (int i = 0; i < 10; i++) {
				String message = obj.sayHello();
				System.out.println(message);
			}
		} catch (Exception e) {
			System.out.println("HelloClient exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
