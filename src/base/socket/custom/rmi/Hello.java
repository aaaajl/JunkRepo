/**
 * 
 */
package base.socket.custom.rmi;

import java.rmi.Remote;

/**
 * @author lj04482
 * 
 */
public interface Hello extends Remote {
	String sayHello() throws java.rmi.RemoteException;
}
