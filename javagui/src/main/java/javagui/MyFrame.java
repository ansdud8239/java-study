package javagui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{

	public MyFrame()  {
		setTitle("Join");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		//contentPane.setBackground(Color.gray);
		contentPane.setLayout(new FlowLayout());

		contentPane.add(new Label("user : "));
		contentPane.add(new TextField(10));
		contentPane.add(new JButton("확인"));
		setSize(300,150);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new MyFrame();

	}

}
