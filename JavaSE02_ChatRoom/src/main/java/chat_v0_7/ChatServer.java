package chat_v0_7;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(8888);
			while (true) {
				Socket s = ss.accept();
				System.out.println("A client connected!");
				DataInputStream dis = new DataInputStream(s.getInputStream());
				String str = dis.readUTF();
				System.out.println(str);
				dis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
