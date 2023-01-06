package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
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
			// get iostream
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			while (true) {
				String request = br.readLine();

				if (request == null) {
					ChatServer.log("클라이언트로 부터 연결 끊김");
					doQuit(pw);
					break;
				} else {
					// 프로토콜 데이터 -> " "을 기준으로 짜름
					String[] tokens = request.split(" ");
					// 메시지를 저장할 변수
					String data = "";
					// QUIT은 tokens.length가 1임
					// 그 외 JOIN,MESSAGE는 2 이상 임. 
					if (tokens.length >= 2) {
						// if문이 없을 경우 index에러 발생
						// request는 프로토콜 {base64인코딩 한 값 = data} 으로 받음
						// data를 base64로 디코딩 함.
						byte[] decodedBytes = Base64.getDecoder().decode(tokens[1]);
						data = new String(decodedBytes, StandardCharsets.UTF_8);
					}

					if ("JOIN".equals(tokens[0])) {
						doJoin(data, pw);
					} else if ("MESSAGE".equals(tokens[0])) {
						doMessage(data, pw);
					} else if ("QUIT".equals(tokens[0])) {
						doQuit(pw);
					} else {
						ChatServer.log("error : 알수 없는 요청(" + tokens[0] + ")");
					}

				}

			}

		} catch (SocketException e) {
			System.out.println("채팅을 종료하였습니다.");
		} catch (IOException e) {
			ChatServer.log("error : " + e);
		} finally {

			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// join
	private void doJoin(String nickname, PrintWriter pw) {
		this.nickname = nickname;

		String data = "========[" + nickname + "]님이 입장하였습니다========"+date("[HH:mm:ss]");		
		System.out.println(nickname+"님 입장");
		broadcast(data);
		addWriter(pw);
		pw.println("JOIN:OK");

	}
	
	//입장 시 add
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

	//message
	private void doMessage(String msg,PrintWriter pw) {
		broadcast("[" + nickname + "]▶ " + msg+date("[HH:mm:ss]"));

	}

	//quit
	private void doQuit(Writer writer) {
		removeWriter(writer);
		String data = "========[" + nickname + "]님이 퇴장하였습니다========"+date("[HH:mm:ss]");
		System.out.println(nickname+"님 퇴장");
		broadcast(data);

	}

	//퇴장시 remove
	private void removeWriter(Writer writer) {
		synchronized (writer) {
			listWriters.remove(writer);
		}

	}
	
	public String date(String format) {
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat(format);
		String date = df.format(today);
		
		return "\t\t"+date;
	}

}
