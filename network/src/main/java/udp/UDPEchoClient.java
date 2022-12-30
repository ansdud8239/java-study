package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPEchoClient {
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {

		DatagramSocket socket = null;
		Scanner sc = null;

		try {
			// 1.스캐너 생성
			sc = new Scanner(System.in);

			// 2.소캣 생성
			socket = new DatagramSocket();

			while (true) {
				System.out.print("> ");
				String line = sc.nextLine();

				if("quit".equals(line)) {
					break;
				}
				
				// 3.보내기
				byte[] sndData = line.getBytes("UTF-8");
				DatagramPacket sndPacket = new DatagramPacket(sndData, sndData.length,
						new InetSocketAddress(SERVER_IP, UDPEchoServer.PORT));
				socket.send(sndPacket);

				// 4.받기
				DatagramPacket rcvPacket = new DatagramPacket(new byte[UDPEchoServer.BUFFER_SIZE], UDPEchoServer.BUFFER_SIZE);
				socket.receive(rcvPacket); // blocking

				byte[] rcvData = rcvPacket.getData();
				int offset = rcvPacket.getLength();
				String msg = new String(rcvData, 0, offset, "UTF-8");

				System.out.println("< " + msg);
			}
		} catch (SocketException e) {
			System.out.println("[UDP Echo Client] error : " + e);
		} catch (IOException e) {
			System.out.println("[UDP Echo Client] error : " + e);
		} finally {
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
			if (sc != null) {
				sc.close();
			}
		}

	}

}
