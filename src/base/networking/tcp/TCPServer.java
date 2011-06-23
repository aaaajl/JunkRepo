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

	public static final int BUFFER_SIZE = 128 * 1024;// 128k
	public static final int TIMEOUT = 30 * 1000; // 30s
	private ServerSocket serverSocket;

	// constructor
	public TCPServer(int port) throws IOException {
		this.serverSocket = new ServerSocket(port);
		serverSocket.setReceiveBufferSize(BUFFER_SIZE);
	}

	public void run() {
		for (;;) {
			try {
				Socket socket = serverSocket.accept();
				socket.setSendBufferSize(BUFFER_SIZE);
				socket.setSoTimeout(TIMEOUT);
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
