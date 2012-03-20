/**
 * 
 */
package base.socket.stream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import base.socket.ISender;
import base.socket.SocketConstant;

/**
 * @author lj04482
 * 
 */
public class StreaModeClient implements ISender {

	@Override
	public void send(String hostName, String message) {
		try {
			InetAddress acceptorHost = InetAddress.getByName(hostName);
			Socket clientSocket = new Socket(acceptorHost, SocketConstant.PORT);
			ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
			out.writeObject(message);
			out.flush();
			ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
			System.out.println("Client:" + in.readObject());
			clientSocket.close();
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new StreaModeClient().send("localhost", "ttttttttttttttt");
		new StreaModeClient().send("localhost", "aaaaaaaaaaaaaaaaa");
	}
}
