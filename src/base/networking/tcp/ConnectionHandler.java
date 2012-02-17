/**
 * 
 */
package base.networking.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author lj04482
 * 
 */
public class ConnectionHandler implements Runnable {

	private Socket socket;

	public ConnectionHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		handleConversation(socket);
	}

	/**
	 * @param socket
	 *          Socket: must be closed on exit
	 */
	public void handleConversation(Socket socket) {
		try {
			InputStream in = socket.getInputStream();
			// read request from the input:
			// conversation not shown �
			OutputStream out = socket.getOutputStream();
			// write reply to the output
			out.flush();
		} catch (IOException e) { /* �*/
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
			}
		} // end finally
	} // end run()
} // end class
