/**
 * 
 */
package base.socket.datagram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import base.socket.IReciver;
import base.socket.SocketConstant;

/**
 * @author lj04482
 * 
 */
public class DatagramReceiver implements IReciver, Runnable {

	int PORT;

	public DatagramReceiver(int port) {
		super();
		PORT = port;
	}

	public void recive(int port) {
		try {
			DatagramSocket mySocket = new DatagramSocket(port);
			System.out.println("Localhost " + port);
			while (true) {
				byte[] buffer = new byte[SocketConstant.MAX_LEN];
				DatagramPacket packet = new DatagramPacket(buffer, SocketConstant.MAX_LEN);
				mySocket.receive(packet);
				String message = new String(buffer);
				System.out.println(message);
				if (message.indexOf("stop") >= 0) {
					System.exit(0);
				}
			}
			// mySocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		recive(PORT);

	}

	public static void main(String[] args) {
		Executor executor = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 3; i++) {
			executor.execute(new DatagramReceiver(SocketConstant.PORT + i));
		}
	}

}
