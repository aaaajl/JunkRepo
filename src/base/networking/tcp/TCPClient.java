/**
 * 
 */
package base.networking.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import base.networking.NetworkingConstants;

/**
 * @author lj04482
 * 
 */
public class TCPClient implements Runnable {

	public static final int BUFFER_SIZE = 128 * 1024;// 128k
	public static final int TIMEOUT = 30 * 1000; // 30s

	Socket socket;

	public void run() {
		try {
			socket = new Socket(NetworkingConstants.SERVER_HOST, NetworkingConstants.SERVER_PORT);
			socket.setReceiveBufferSize(BUFFER_SIZE);
			socket.setSendBufferSize(BUFFER_SIZE);
			socket.setSoTimeout(TIMEOUT);
			OutputStream out = socket.getOutputStream();
			PrintStream ps = new PrintStream(out, true);
			ps.println(NetworkingConstants.INIT_SENTENCE);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String sentence = br.readLine();
			while (sentence != null) {
				System.out.println("God say:" + sentence);
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				ps.println(reader.readLine());
				sentence = br.readLine();
			}
		} catch (IOException e) { /* … */
		} finally
		// ensure socket is closed
		{
			try {
				if (socket != null)
					socket.close();
			} catch (IOException e) {
			}
		} // end finally
	} // end run()

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(1000);
		for (int i = 0; i < 1; i++) {
			es.execute(new TCPClient());
		}
	}
} // end class
