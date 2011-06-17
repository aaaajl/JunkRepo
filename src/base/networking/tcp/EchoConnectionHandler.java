/**
 * 
 */
package base.networking.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

import base.networking.NetworkingConstants;

/**
 * @author lj04482
 * 
 */
public class EchoConnectionHandler extends ConnectionHandler {
	EchoConnectionHandler(Socket socket) {
		super(socket);
	}

	/**
	 * @param socket
	 *          Socket: must be closed on exit
	 */
	public void handleConversation(Socket socket) {
		try {
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			// read requests from the input until EOF
			int count;
			BufferedReader br = new BufferedReader(new InputStreamReader(in), 10);
			PrintStream ps = new PrintStream(out);
			String sentence = br.readLine();
			while (!NetworkingConstants.END_SENTENCE.equals(sentence)) {
				if (NetworkingConstants.INIT_SENTENCE.equals(sentence)) {
					ps.println("My son speak out your will");
				} else {
					ps.println(sentence);
				}
				ps.flush();
				sentence = br.readLine();
			}

		} catch (IOException e) {
			/* … */
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
			}
		} // end finally
	} // end run()
} // end class
