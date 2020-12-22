package chat_v0_8;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	public static void main(String[] args) {
		boolean started = false;
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(8888);
			started = true;
			while (started) {
				boolean bConnected = false;
				Socket s = ss.accept();
				System.out.println("A client connected!");
				bConnected = true;
				DataInputStream dis = new DataInputStream(s.getInputStream());
				while (bConnected) {
					String str = dis.readUTF();
					System.out.println(str);
				}
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
