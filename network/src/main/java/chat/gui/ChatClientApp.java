package chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

import chat.ChatClientThread;
import chat.ChatServer;

public class ChatClientApp {
	private static final String SERVER_IP="127.0.0.1";
	
	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;

		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			if (name.isEmpty() == false ) {
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP,ChatServer.PORT));
			//log("connected");
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));;			
			pw.println("JOIN:"+name);
			String data = br.readLine();
			if("JOIN:OK".equals(data)) {
				//System.out.println("환영합니다");
				//new ChatWindow(name,socket).show();
			}
			
		} catch (SocketException e) {
			log("suddenly closed by client");
		} catch (IOException e) {
			log("error : " + e);
		} finally {

			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
				if (scanner != null) {
					scanner.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
		// 2. conntect to server
		// 3. get iostream
		// 4. join protocol 진행
		// 		String line = "JOIN:OK"
		
		
//		String line = "JOIN;OK";
////		if("JOIN:OK".equals(line)) {
////			new ChatWindow(name).show();
////			return;
////		}
//		new ChatWindow(name).show();
//		scanner.close();

	}
	public static void log(String msg) {
		System.out.println("[ChatClient] " + msg);
	}
}
