package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. Server Socket 생성
			serverSocket = new ServerSocket();

			// 2. 바인팅(bindint)
			// Socket에 InetSocketAddress(IPAddress+Port)
			// ip를 고정시킬 경우(192.168.10x) 127.0.0.1은 사용이 안되기 때문에
			// "0.0.0.0" 으로 설정
			// IPAdresss: 0.0.0.0 : 특정 호스트 IP에 바인딩 하지 않는다
			// InetAddress inetAddress=InetAddress.getLocalHost();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000));

			// 3.accecpt
			Socket socket = serverSocket.accept(); // blocking

			try {
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();
				System.out.println("[server] connected by client[" + remoteHostAddress + ":" + remotePort + "]");

				// 4. IO Stream받아오기
				OutputStream os = socket.getOutputStream();
				InputStream is = socket.getInputStream();

				while (true) {
					// 5. 데이터 읽기
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer);	// blocking
					if(readByteCount == -1) {
						//서버가 연결이 끊어졌을경우
						System.out.println("[server] closed by client");
						break;
					}
					
					String data = new String(buffer,0,readByteCount,"utf-8");
					System.out.println("[server] received: "+data);
				}
			} catch (IOException e) {
				// Stream 예외
				System.out.println("[server] error: " + e);
			} finally {

				try {
					if (socket != null && !socket.isClosed()) {
						socket.close();
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			// serverSocket 예외처리
			System.out.println("[server] error: " + e);
		} finally {

			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}