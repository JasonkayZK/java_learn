package chat_v1_0;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	boolean started = false;
	ServerSocket ss = null;
	
	public static void main(String[] args) {
		new ChatServer().start();
	}

	public void start() {
		try {
			ss = new ServerSocket(8888);
			started = true;
		} catch (BindException e) {
			System.out.println("端口使用中....");
			System.out.println("请关掉相关程序并重新运行服务器！");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			while (started) {
				Socket s = ss.accept();
				Client c = new Client(s);
				System.out.println("A client connected!");
				new Thread(c).start();
			}	
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ss != null) {
					ss.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private class Client implements Runnable {
		private Socket s;
		private DataInputStream dis = null;
		private boolean bConnected = false;
		
		public Client(Socket s) {
			try {
				this.s = s;
				dis = new DataInputStream(s.getInputStream());
				bConnected = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				while (bConnected) {
					String str = dis.readUTF();
					System.out.println(str);
				}
			} catch (EOFException e) {
				System.out.println("Client closed!");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (dis != null) dis.close();
					if (s != null) s.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
}
