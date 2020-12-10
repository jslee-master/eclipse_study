package miniproject;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("Swing TCP Chatting");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		ServerFrame ServerFrame = new ServerFrame();
		ClientFrame ClientFrame = new ClientFrame();
		ClientFrame ClientFrame1 = new ClientFrame();

		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}

}
