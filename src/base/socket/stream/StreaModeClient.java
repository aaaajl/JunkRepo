/**
 * 
 */
package base.socket.stream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
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
			BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			System.out.println("Client:" + br.readLine());
			PrintStream ps = new PrintStream(clientSocket.getOutputStream());
			ps.println("received your message.. Thanks");
			ps.flush();
			clientSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new StreaModeClient().send("localhost", "");
	}
}
