package chat.gui;

import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class test {

	public static void main(String[] args) {
		Frame f = new Frame();
		f.setSize(600,700);
		Label l = new Label("test");
		TextArea t = new TextArea(5,5);
		f.add(l);
		f.add(t);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

}
