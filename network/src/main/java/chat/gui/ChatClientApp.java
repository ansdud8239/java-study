package chat.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

import javax.swing.JOptionPane;

import chat.ChatServer;

public class ChatClientApp {
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;

		try {
			// 소켓 생성
			socket = new Socket();
			// 소켓 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			// log("connected");

			// get iostream
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			while (true) {
				// 대화명 입력
				name = JOptionPane.showInputDialog("닉네임을 한글자 이상 입력하세요");
				// name = scanner.nextLine();
				// 취소버튼을 클릭 시 or 대화명을 입력하지 않은 경우
				if (name == null || name.equals("")) {
					System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
					System.exit(0);
				} else {
					//확인 버튼을 클릭 시
					if (name.isEmpty() == false) {
						pw.println("JOIN " + Base64.getEncoder().encodeToString(name.getBytes(StandardCharsets.UTF_8)));
						String data = br.readLine();
						if ("JOIN:OK".equals(data)) {
							System.out.println(name + "님 환영합니다");
							break;
						}
						
					}
				}			
			}
			new ChatWindow(name, socket).show();
		} catch (IOException e) {
			log("error : " + e);
		}

	}

	public static void log(String msg) {
		System.out.println("[ChatClient] " + msg);
	}
}
