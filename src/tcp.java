import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class tcp {
	public static void send(metadata m) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("title=");
		sb.append(m.title);
		sb.append("& artist=");
		sb.append(m.artist);
		System.out.println(sb.toString());
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] sendData = new byte[1024];
		sendData = sb.toString().getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
		clientSocket.send(sendPacket);
		clientSocket.close();
	}
}
