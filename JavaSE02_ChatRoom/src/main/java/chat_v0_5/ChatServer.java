package chat_v0_5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(8808);
			while (true) {
				Socket s = ss.accept();
				System.out.println("a client connected!");
				s.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (ss != null) {
					ss.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
