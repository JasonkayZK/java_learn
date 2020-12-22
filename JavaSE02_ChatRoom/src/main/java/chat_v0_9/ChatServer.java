package chat_v0_9;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	public static void main(String[] args) {
		boolean started = false;
		ServerSocket ss = null;
		Socket s = null;
		DataInputStream dis = null;
		try {
			ss = new ServerSocket(8888);
		} catch (BindException e) {
			System.out.println("端口使用中....");
			System.out.println("请关掉相关程序并重新运行服务器！");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			started = true;
			while (started) {
				boolean bConnected = false;
				s = ss.accept();
				System.out.println("A client connected!");
				bConnected = true;
				dis = new DataInputStream(s.getInputStream());
				while (bConnected) {
					String str = dis.readUTF();
					System.out.println(str);
				}
			}
		} catch (EOFException e) {
			System.out.println("Client closed!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dis != null) dis.close();
				if (s != null) s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
