/**
 * 
 */
package base.socket.stream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import base.socket.IReciver;
import base.socket.SocketConstant;

/**
 * @author lj04482
 * 
 */
public class StreaModeServer implements IReciver {

	ExecutorService executor = Executors.newFixedThreadPool(10);

	@Override
	public void recive(int serverPortNumber) {
		ServerSocket connectionSocket = null;
		try {
			connectionSocket = new ServerSocket(serverPortNumber);
			boolean a = true;
			while (a) {
				Socket dataSocket = connectionSocket.accept();
				executor.execute(new Task(dataSocket));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connectionSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class Task implements Runnable {
		Socket dataSocket;

		private Task(Socket dataSocket) {
			super();
			this.dataSocket = dataSocket;
		}

		@Override
		public void run() {
			try {
				System.out.println("Connect OPEN");
				ObjectInputStream in = new ObjectInputStream(dataSocket.getInputStream());
				System.out.println((String) in.readObject());
				ObjectOutputStream out = new ObjectOutputStream(dataSocket.getOutputStream());
				out.writeObject("Sucess");
				out.flush();
				out.close();
				in.close();
				dataSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		new StreaModeServer().recive(SocketConstant.PORT);
	}
}
