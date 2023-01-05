package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.swing.WindowConstants;
import javax.swing.event.ChangeListener;

import chat.ChatClient;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private String name;
	private Socket socket;
	private PrintWriter pw;

	public ChatWindow(String name, Socket socket) {
		frame = new Frame(name+"님 채팅방입니다.");
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.name = name;
		this.socket = socket;
	}

	public void show() {

		
		// 사용자 입장
		textArea.append(name+"님 환영합니다.\n\n");


		// 가운데 정렬
		frame.setSize(600, 400);
		Dimension frameSize = frame.getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);

		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				sendMessage();
			}
		});
		// buttonSend.addActionListener((ActionEvent e) -> {});

		// Textfield
		textField.requestFocus();
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}

			
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		//pannel.setBackground(new Color(250,244,192));
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setBackground(new Color(250,244,192));
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);		
		
		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();

		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
		} catch (IOException e) {
			ChatClient.log("error : " + e);
		}

		new ChatClientThread(socket).start();
	}

	private void finish() {
		// quit protocol 구현
		pw.println("QUIT");
		// exit java
		System.exit(0);
	}

	private void sendMessage() {
		String message = textField.getText();
		//System.out.println("메세지 보내는 프로토콜 구현 ! " + message);

		if ("".equals(message)) {
			return;
		}
		if ("QUIT".equals(message)) {
			finish();
		}
		pw.println("MESSAGE " +  Base64.getEncoder().encodeToString(message.getBytes(StandardCharsets.UTF_8)));

		textField.setText("");
		textField.requestFocus();
	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");

	}

	private class ChatClientThread extends Thread {
		private Socket socket;
		private BufferedReader br;

		public ChatClientThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				this.br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
				while (true) {
					String data = br.readLine();
					updateTextArea(data);
					// System.out.println(data);
				}
			} catch (SocketException e) {
				System.out.println("채팅을 종료하겠습니다.");
				finish();
			} catch (IOException e) {
				ChatClient.log("error : " + e);
			}

		}

	}

}
