package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {
	public static final int PORT = 5000;
	public static final int BUFFER_SIZE = 256;

	public static void main(String[] args) {

		DatagramSocket socket = null;
		try {
			// 1.소켓 생성
			socket = new DatagramSocket(PORT);
			while (true) {
				// 2. 데이터 수신
				// 보내는 데이터와 받는 데어터의 바이트는 같아야함
				DatagramPacket rcvPacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
				socket.receive(rcvPacket); // blocking

				byte[] rcvData = rcvPacket.getData();
				int offset = rcvPacket.getLength();
				String msg = new String(rcvData, 0, offset, "UTF-8");

				System.out.println("[UDP Echo Server] received : " + msg);

				// 3.데이터 송신
				byte[] sndData = msg.getBytes("UTF-8");
				DatagramPacket sndPacket = new DatagramPacket(sndData, sndData.length, rcvPacket.getAddress(),
						rcvPacket.getPort());
				socket.send(sndPacket);
			}
		} catch (SocketException e) {
			System.out.println("[UDP Echo Server] error : " + e);
		} catch (IOException e) {
			System.out.println("[UDP Echo Server] error : " + e);
		} finally {
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
		}
	}
}
