package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
public class EchoRequestHandler extends Thread {

	Socket socket = null;
	public EchoRequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		ServerSocket serverSocket = null;			

			try {
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();
				log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

				while (true) {
					String data = br.readLine();
					if (data == null) {
						log("closed by client");
						break;
					}
					log("received: " + data);
					// print로 하면 버퍼가 찼을때 출력 됨
					pw.println(data);
				}
			} catch (IOException e) {
				log("error: " + e);
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


	private void log(String msg) {
		System.out.println("[EchoServer] : " + msg);

	}

}
