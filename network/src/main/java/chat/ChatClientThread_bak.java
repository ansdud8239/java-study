package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientThread_bak extends Thread {

	private Socket socket;

	public ChatClientThread_bak(Socket socket) {
		this.socket = socket;

	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			while (true) {
				String data = br.readLine();
				System.out.println(data);
			}
		} catch (SocketException e) {
			System.out.println("채팅을 종료하겠습니다.");
		} catch (IOException e) {
			ChatClient.log("error : " + e);
		}

	}

}
