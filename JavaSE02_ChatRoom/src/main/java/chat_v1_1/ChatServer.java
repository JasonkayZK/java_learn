package chat_v1_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ChatServer {
	
	private boolean started;
	private ServerSocket ss;
	
	List<Client> clients;
	
	public static void main(String[] args) {
		new ChatServer().start();
	}

	public ChatServer() {
		this.started = false;
		this.ss = null;
		
		this.clients = new ArrayList<Client> ();
	}
	
	public void start() {
		try {
			ss = new ServerSocket(8888);
			started = true;
		} catch (BindException e) {
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			while (started) {
				Socket s = ss.accept();
				Client c = new Client(s);
				System.out.println("A client connected!");
				new Thread(c).start();
				this.clients.add(c);
				
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
		private Socket s;
		private DataInputStream dis = null;
		private DataOutputStream dos = null;
		
		private boolean bConnected;
		
		public Client(Socket s) {
			this.s = s;
			this.bConnected = false;
			
			try {
				this.dis = new DataInputStream(s.getInputStream());
				this.dos = new DataOutputStream(s.getOutputStream());
				bConnected = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void send(String str) {
			try {
				this.dos.writeUTF(str);
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
						Client c = clients.get(i);
						c.send(str);
					}
					for(ListIterator<Client> it = clients.listIterator(); it.hasNext(); ) {
						Client c = it.next();
						c.send(str);
					}
					ListIterator<Client> it = clients.listIterator();
					while(it.hasNext()) {
						Client c = it.next();
						c.send(str);
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
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}


















