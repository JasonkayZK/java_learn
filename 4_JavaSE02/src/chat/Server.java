package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	private ServerSocket server;

	/*
	 * 保存所有客户端输出流的集合
	 */
	private List<PrintWriter> allOut;
	
	/**
	 * 初始化服务端
	 * @throws Exception
	 */
	public Server() throws Exception {
		/**
		 * 初始化的同时申请服务端口
		 */
		server = new ServerSocket(8088);
		
		allOut = new ArrayList<PrintWriter> ();
		
	}
	
	/*
	 * 将给定的输出流存入共享集合
	 */
	public synchronized void addOut(PrintWriter pw) {
		this.allOut.add(pw);
	}
	
	/*
	 * 将给定的输出流从共享集合中删除
	 */
	public synchronized void removeOut(PrintWriter pw) {
		this.allOut.remove(pw);
	}

	/*
	 * 将给定的消息发送给所有的客户端
	 */
	public synchronized void sendMessage(String msg) {
		for (PrintWriter out : this.allOut) {
			out.println(msg);
		}
	}
	
	/**
	 * 服务端开始工作的方法
	 */
	public void start() {
		try {
			/**
			 * 阻塞方法
			 * 监听服务器端口, 直到一个客户端连接并创建一个Socket,
			 * 使用该Socket即可与刚连接的客户端进行交互
			 */
			while (true) {
				System.out.println("等待客户端连接...........");
				Socket socket = server.accept();
				System.out.println("一个客户端连接了...........");
				
				/*
				 * 启动一个线程, 完成与该客户端的交换
				 */	
				ClientHandler handler = new ClientHandler(socket);
				new Thread(handler).start();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("服务器启动失败!");
		}
	}
	
	
	class ClientHandler implements Runnable {
		/*
		 * 处理服务器的Socket
		 */
		private Socket socket;
		/*
		 * 客户端的地址信息
		 */
		private String host;
		
		// Username
		private String nickName;
		
		public ClientHandler(Socket socket) {
			this.socket = socket;
			/*
			 * 通过Socket可以获取远端计算机的地址信息
			 */
			InetAddress address = socket.getInetAddress();
			host = address.getHostAddress();
			
		}
		
		@Override
		public void run() {
			PrintWriter pw = null;
			try {
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				/*
				 * 通过Socket创建输出流用于将消息发送给客户端
				 */
				
				// Read username, Firstly. The first String is username
				this.nickName = br.readLine();
				sendMessage(nickName + ": 上线了!");
				
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
				pw = new PrintWriter(osw, true);
				
				/*
				 * 将该客户端的输出流存入到共享集合中
				 */
				addOut(pw);
				
				String msg = null;
				/*
				 * br.readLine() 在读取客户端发来的消息时, 由于客户端断线, 而其操作系统的不同,
				 * 这里读取到的结果也不同:
				 * Win客户端断开: br.readLine() 抛出异常
				 * Linux短卡: 返回null
				 */
				while ((msg = br.readLine()) != null) {
//					System.out.println("Client: " + host + ":" + msg);
//					pw.println(host + "说: " + msg);
					// 广播消息
					sendMessage(nickName + "  say: " + msg);
				}
				
			} catch (Exception e) {
				
			} finally {
				/*
				 * 处理当前客户端断开后的逻辑
				 */
				// 将该客户端的输出流从共享集合中删除
				if (pw != null) {
					removeOut(pw);
					sendMessage(nickName + ": 下线了!");
				}
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}





