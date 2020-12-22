package chat_v1_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	
	private boolean started;
	private ServerSocket ss;

	private List<Client> clients;
	
	public static void main(String[] args) {
		new ChatServer().start();
	}

	public ChatServer() {
		this.started = false;
		this.ss = null;
		
		this.clients = new ArrayList<Client>();
	}
	
	public void start() {
		try {
			ss = new ServerSocket(8888);
			started = true;
		} catch (BindException e) {
			System.out.println("服务器连接失败");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			while (started) {
				Socket s = ss.accept();
				Client c = new Client(s);
				System.out.println("A client connected!");
				new Thread(c).start();
				clients.add(c);
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
	
	private class Client implements Runnable {
		private Socket s = null;
		private DataInputStream dis = null;
		private DataOutputStream dos = null;
		private boolean bConnected = false;
		
		public Client(Socket s) {
			this.s = s;
			try {
				this.dis = new DataInputStream(s.getInputStream());
				this.dos = new DataOutputStream(s.getOutputStream());
				this.bConnected = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void send(String str) {
			try {
				dos.writeUTF(str);
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
					for (int i = 0; i < clients.size(); ++i) {
						clients.get(i).send(str);
						System.out.println("A msg sent!");
					}
				}
			} catch (EOFException e) {
				System.out.println("Client closed!");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (dis != null) dis.close();
					if (dos != null) dos.close();
					if (s != null) s.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}
	
}
 