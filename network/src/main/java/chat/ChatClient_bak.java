package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatClient_bak {
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		Scanner sc = null;
		Socket socket = null;

		try {
			sc = new Scanner(System.in);
			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP,ChatServer.PORT));
			//log("connected");
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			System.out.print("닉네임>> ");
			String name = sc.nextLine();			
			pw.println("JOIN:"+name);
			String data = br.readLine();
			if("JOIN:OK".equals(data)) {
				System.out.println("환영합니다");
			}
			new ChatClientThread(socket).start();
			
			while(true) {
				String line = sc.nextLine();
				if("QUIT".equals(line)) {
					pw.println("QUIT");
					break;
				}else {
					pw.println("MESSAGE:"+line);
				}
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
				if (sc != null) {
					sc.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void log(String msg) {
		System.out.println("[ChatClient] " + msg);
	}
}
