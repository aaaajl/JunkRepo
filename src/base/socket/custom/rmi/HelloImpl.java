/**
 * 
 */
package base.socket.custom.rmi;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

import base.socket.custom.xor.XorClientSocketFactory;
import base.socket.custom.xor.XorServerSocketFactory;

/**
 * @author lj04482
 * 
 */
public class HelloImpl implements Hello {

	public HelloImpl() {
		super();
	}

	public String sayHello() {
		System.out.println(Thread.currentThread().getName());
		return "Hello World!";
	}

	public static void main(String args[]) {
		System.setSecurityManager(new RMISecurityManager());
		int port = 9999;
		byte pattern = (byte) 0xAC;
		try {
			/*
			 * Create remote object and export it to use custom socket factories.
			 */
			HelloImpl obj = new HelloImpl();
			RMIClientSocketFactory csf = new XorClientSocketFactory(pattern);
			RMIServerSocketFactory ssf = new XorServerSocketFactory(pattern);
			Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0, csf, ssf);
			// Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, port);

			/*
			 * Create a registry and bind stub in registry.
			 */
			LocateRegistry.createRegistry(port);
			Registry registry = LocateRegistry.getRegistry(port);
			registry.rebind("Hello", stub);
			System.out.println("HelloImpl bound in registry");

		} catch (Exception e) {
			System.out.println("HelloImpl exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}