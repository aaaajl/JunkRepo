/**
 * 
 */
package base.socket.datagram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import base.socket.ISender;
import base.socket.SocketConstant;

/**
 * @author lj04482
 * 
 */
public class DatagramSender implements ISender {

	public void send(String hostName, String message) {
		try {
			InetAddress receiverHost = InetAddress.getByName(hostName);
			int receiverPort = SocketConstant.PORT;
			DatagramSocket mySocket = new DatagramSocket();
			byte[] buffer = message.getBytes();
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, receiverHost, receiverPort);
			DatagramPacket packet1 = new DatagramPacket(buffer, buffer.length, receiverHost, receiverPort + 1);
			mySocket.send(packet);
			mySocket.send(packet1);
			mySocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ISender sender = new DatagramSender();
		sender.send("10.183.3.93", "stop");
	}
}
