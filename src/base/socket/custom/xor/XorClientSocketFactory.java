/**
 * 
 */
package base.socket.custom.xor;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.rmi.server.RMIClientSocketFactory;

/**
 * @author lj04482
 * 
 */
public class XorClientSocketFactory implements RMIClientSocketFactory, Serializable {

	private byte pattern;

	public XorClientSocketFactory(byte pattern) {
		this.pattern = pattern;
	}

	public Socket createSocket(String host, int port) throws IOException {
		return new XorSocket(host, port, pattern);
	}

	public int hashCode() {
		return (int) pattern;
	}

	public boolean equals(Object obj) {
		return (getClass() == obj.getClass() && pattern == ((XorClientSocketFactory) obj).pattern);
	}
}