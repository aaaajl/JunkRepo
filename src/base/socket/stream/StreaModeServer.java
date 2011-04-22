/**
 * 
 */
package base.socket.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import base.socket.IReciver;
import base.socket.SocketConstant;

/**
 * @author lj04482
 * 
 */
public class StreaModeServer implements IReciver {

	@Override
	public void recive(int serverPortNumber) {
		ServerSocket connectionSocket = null;
		try {
			connectionSocket = new ServerSocket(serverPortNumber);
			boolean a = true;
			while (a) {
				Socket dataSocket = connectionSocket.accept();
				PrintStream socketOutput = new PrintStream(dataSocket.getOutputStream());
				socketOutput.println("AAAAAAAAAAAAAAAAAAAA dddddddddddddddddd");
				System.out.println("Server: Sent response to client…");
				BufferedReader br = new BufferedReader(new InputStreamReader(dataSocket.getInputStream()));
				System.out.println(br.readLine());
				socketOutput.flush();
				dataSocket.close();
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

	public static void main(String[] args) {
		new StreaModeServer().recive(SocketConstant.PORT);
	}
}
