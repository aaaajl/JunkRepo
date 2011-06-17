/**
 * 
 */
package base.networking.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import base.networking.NetworkingConstants;

/**
 * @author lj04482
 * 
 */
public class TCPServer implements Runnable {

	private ServerSocket serverSocket;

	// constructor
	public TCPServer(int port) throws IOException {
		this.serverSocket = new ServerSocket(port);
	}

	public void run() {
		for (;;) {
			try {
				Socket socket = serverSocket.accept();
				new Thread(new EchoConnectionHandler(socket)).start();
			} catch (IOException e) { /* … */
			}
		} // end finally
	} // end run()

	public static void main(String[] args) {
		try {
			new Thread(new TCPServer(NetworkingConstants.SERVER_PORT)).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
} // end class
