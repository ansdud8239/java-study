package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServerThread extends Thread {

	private String nickname;
	private Socket socket;
	List<Writer> listWriters;

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			while (true) {
				String request = br.readLine();
				System.out.println("request***"+request);

				if (request == null) {
					ChatServer.log("클라이언트로 부터 연결 끊김");
					if(!socket.isClosed()) {
						doQuit(pw);
					}
					
					break;
				} else {
					String[] tokens = request.split(":");
					if ("JOIN".equals(tokens[0])) {
						doJoin(tokens[1], pw);
					} else if ("MESSAGE".equals(tokens[0])) {
						doMessage(tokens[1]);
					} else if ("QUIT".equals(tokens[0])) {
						doQuit(pw);
					} else {
						ChatServer.log("error : 알수 없는 요청(" + tokens[0] + ")");
					}

				}

			}

		} catch (IOException e) {
			ChatServer.log("error : " + e);
		}

	}

	private void doJoin(String nickname, PrintWriter pw) {
		this.nickname = nickname;

		String data = "[" + nickname + "]님이 참여하였습니다";
		broadcast(data);

		addWriter(pw);
		
		pw.println("JOIN:OK");

	}

	private void addWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}

	}

	private void broadcast(String data) {
		synchronized (listWriters) {
			for (Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println(data);
			}
		}
	}

	private void doMessage(String msg) {
		broadcast("[" + nickname + "] : " + msg);

	}

	private void doQuit(Writer writer) {
		removeWriter(writer);
		String data = "[" + nickname + "]님이 퇴장하였습니다.";
		broadcast(data);
	}

	private void removeWriter(Writer writer) {
		synchronized (writer) {
			listWriters.remove(writer);
		}

	}

}
