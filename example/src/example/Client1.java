package example;

import java.io.InputStream;
import java.net.Socket;

public class Client1 {

	public static void main(String[] args) {
		try {
			Socket client = new Socket("localhost",12345);
			
			InputStream input_data = client.getInputStream();
			
			byte[] receiveBuffer = new byte[100];
			input_data.read(receiveBuffer);
			
			System.out.println(new String(receiveBuffer));
			
			client.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
