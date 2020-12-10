package miniproject;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientFrame extends JFrame {
	Socket clientSocket;
	DataInputStream dis;
	DataOutputStream dataOutputStream;
	JTextArea textArea;
	JTextField tfMsg;
	JButton btnSend;
	JButton btnConn;
	JButton btnDisconn;

	public ClientFrame() {
		//프레임창 세팅		
		setTitle("Client");
		setBounds(450,400,500,350);
		setVisible(true);
		
		//텍스트 영역 출력
		textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		add(scrollPane,BorderLayout.CENTER);

		//메시지 패널 출력
		JPanel msgPanel = new JPanel();
		msgPanel.setLayout(new BorderLayout());
		tfMsg = new JTextField();
		msgPanel.add(tfMsg, BorderLayout.CENTER);
		add(msgPanel,BorderLayout.SOUTH);

		//전송 버튼 출력
		btnSend = new JButton("전송");
		msgPanel.add(btnSend, BorderLayout.EAST);

		//전송 버튼 클릭
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});

		//접속 버튼 출력
		btnConn = new JButton("접속");
		msgPanel.add(btnConn, BorderLayout.PAGE_START);

		//연결해제 버튼 출력
		btnDisconn = new JButton("연결해제");
		msgPanel.add(btnDisconn, BorderLayout.PAGE_END);
		
		//연결해제 버튼 클릭
		btnDisconn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(dataOutputStream!=null) dataOutputStream.close();
					if(dis!=null) dis.close();
					if(clientSocket!=null) clientSocket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		//엔터키
		tfMsg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				
				int keyCode = e.getKeyCode();
				switch(keyCode) {
				case KeyEvent.VK_ENTER:
					sendMessage();
				break;
				}
			}
		});
		setVisible(true);
		tfMsg.requestFocus();
		
		//쓰레드 선언
		ClientThread clientThread = new ClientThread();
		clientThread.setDaemon(true);
//		clientThread.start();
		
		//접속 버튼 클릭
		btnConn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientThread.start();
			}
		});
		
		// window창 닫을시 할당해제
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				try {
					if(dataOutputStream!=null) dataOutputStream.close();
					if(dis!=null) dis.close();
					if(clientSocket!=null) clientSocket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});// addWindowListener

	}//생성자

	public class ClientThread extends Thread{
		@Override
		public void run() {
			try {
//				clientSocket = new Socket("192.168.1.17",10001);
				clientSocket = new Socket("localhost",10001);
//				clientSocket = new Socket("192.168.1.19",5011);
				textArea.append("서버접속됨\n");
				InputStream is = clientSocket.getInputStream();
				OutputStream os = clientSocket.getOutputStream();
				dis = new DataInputStream(is);
				dataOutputStream = new DataOutputStream(os);
				while(true) {
					String msg=dis.readUTF();
					textArea.append("[Server]:" + msg + "\n");
					textArea.setCaretPosition(textArea.getText().length());
				}
			} catch (IOException e) {
				textArea.append("접속해제\n");
//				e.printStackTrace();
			}
		}
//		Thread ct = new Thread();
	}//클라이언트쓰레드
	
	//메시지 입력받아서 보내기
	public void sendMessage() {
		String msg = tfMsg.getText();
		tfMsg.setText("");
		textArea.append(msg + "\n");
		textArea.setCaretPosition(textArea.getText().length());

		Thread t=new Thread() {
			@Override
			public void run() {
				try {
					dataOutputStream.writeUTF(msg);
					dataOutputStream.flush();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}; t.start();
	}//sendMessage
	
	public static void main(String[] args) {
		new ClientFrame();
	}

}
