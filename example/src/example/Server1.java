package example;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {

	public static void main(String[] args) {
		try {
			ServerSocket s_socket = new ServerSocket(12345);
			Socket c_socket = s_socket.accept();
			
			OutputStream output_data = c_socket.getOutputStream();
			
			String sendDataString = "Server";
			output_data.write(sendDataString.getBytes());
			
		}catch(Exception e) {
//			e.printStackTrace();
		}
	}

}
