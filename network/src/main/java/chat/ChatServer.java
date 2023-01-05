package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChatServer {

	public static final int PORT = 8989;

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		List<Writer> listWriters = new ArrayList<Writer>();

		try {
			// 서버 소켓 생성
			serverSocket = new ServerSocket();
			// 특정호스트 ip에 바인딩하지 않음(0.0.0.0)
			// 포트는 8989만 가능
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("연결대기...[port:" + PORT + "]");

			while (true) {
				// 클라이언트가 연결되면
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, listWriters).start();
			}

		} catch (IOException e) {
			log("error: " + e);
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

	public static void log(String msg) {
		System.out.println("[ChatServer] " + msg);
	}

}
