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
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ServerFrame extends JFrame {
	ServerSocket serverSocket;
	Socket clientSocket;
//	List<Client> connections = new Vector<Client>();
	List<ServerThread> connections = new Vector<ServerThread>();
//	public static Vector<Client> clients = new Vector<Client>();
//	Vector v;

	DataInputStream dis;
	DataOutputStream dataOutputStream;
	JTextArea textArea;
	JTextField tfMsg;
	JButton btnDisconn;
	
	
	public ServerFrame() {
//		v = new Vector();
		
		//프레임창 세팅
		setTitle("Server");
		setBounds(450,50,500,350);

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
		JButton btnSend;
		btnSend = new JButton("전송");
		msgPanel.add(btnSend, BorderLayout.EAST);
		
		//전송 버튼 클릭
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});

		//연결해제 버튼 출력
		btnDisconn = new JButton("연결해제");
		msgPanel.add(btnDisconn, BorderLayout.PAGE_START);
		
		//연결해제 버튼 클릭
		btnDisconn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disconn();
			}

			private void disconn() {
				try {
					if(dataOutputStream != null) dataOutputStream.close();
					if(dis != null) dis.close();
//					if(clientSocket != null) clientSocket.close();
					if(serverSocket != null) serverSocket.close();
					textArea.append("서버접속해제\n");
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
		
		ServerThread serverThread = new ServerThread();
		serverThread.setDaemon(true);
		serverThread.start();
		
		addWindowListener(new WindowAdapter() {
			@Override //클라이언트 프레임에 window(창) 관련 리스너 추가
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				try {
					if(dataOutputStream != null) dataOutputStream.close();
					if(dis != null) dis.close();
//					if(clientSocket != null) clientSocket.close();
					if(serverSocket != null) serverSocket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	public void addThread(ServerThread serverThread) {
//		v.add(serverThread);
	}
	
	public void broadCast(String str) {
//		for (int i = 0; i < v.size(); i++) {
//			ServerThread serverThread = (ServerThread) v.elementAt(i);
			sendMessage();
//		}
	}
	

	class ServerThread extends Thread {
		
		public void run() {
			Thread connth = new Thread() {
				@Override
				public void run() {
					try {
						serverSocket = new ServerSocket(10001);
						textArea.append("서버소켓 준비됨\n");

						while(true) {
							clientSocket = serverSocket.accept();
							
//							Client client = new Client(clientSocket);
							
							ServerThread serverThread = new ServerThread();
							addThread(serverThread);
							connections.add(serverThread);
							
							
							textArea.append("클라연결됨\n");

							dis = new DataInputStream(clientSocket.getInputStream());
							dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
							
							recvMsg();
							
							serverThread.start();
						}

					} catch (IOException e) {
					}
				}

			};
			connth.start();
		}

	};

//	class Client{
//		Socket clientSocket;
//
//		Client(Socket clientSocket){
//			this.clientSocket = clientSocket;
//			recvMsg();
//		}
//	}
//	
//
//	void Cilent(Socket clientSocket) {
//		this.clientSocket = clientSocket;
//		recvMsg();		
//	}

	void recvMsg() {
		Thread recvThread = new Thread() {
			@Override
			public void run() {				
				try {
					while(true) {
						String msg=dis.readUTF();
						textArea.append("[Clinent]:" + msg + "\n");
						textArea.setCaretPosition(textArea.getText().length());
					}
				}
				catch (IOException e1) {
					textArea.append("클라종료\n");
				}
			}
		};
		recvThread.start();
	}

	//메시지 입력받아서 보내기
	void sendMessage() {
//		Socket socket;
		String msg = tfMsg.getText();
//		OutputStream outputStream = socket.getOutputStream();
//		DataOutputStream dataOutputStream = clientSocket.getOutputStream();

		tfMsg.setText("");
		textArea.append(msg + "\n");
		textArea.setCaretPosition(textArea.getText().length());

		Thread t = new Thread() {
			@Override
			public void run() {
				try {

					for (ServerThread serverThread : connections) {
						dataOutputStream.writeUTF(msg);
						dataOutputStream.flush();
					}

				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}; t.start();
	}
	
	public static void main(String[] args) {
		new ServerFrame();
	}
	

}
