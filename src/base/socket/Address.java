/**
 * 
 */
package base.socket;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author lj04482
 * 
 */
public class Address {

	public static void main(String[] args) {
		Enumeration<NetworkInterface> enumeration;
		try {
			enumeration = NetworkInterface.getNetworkInterfaces();
			while (enumeration.hasMoreElements()) {
				NetworkInterface ni = enumeration.nextElement();
				System.out.println("MTU:" + ni.getMTU());
				System.out.println("DisplayName:" + ni.getDisplayName());
				System.out.println("Name:" + ni.getName());
				System.out.println("Parent:" + ni.getParent());
				System.out.println("Loopback:" + ni.isLoopback());
				Enumeration<InetAddress> iaEnums = ni.getInetAddresses();
				while (iaEnums.hasMoreElements()) {
					InetAddress address = iaEnums.nextElement();
					System.out.println(address.toString());
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
}
