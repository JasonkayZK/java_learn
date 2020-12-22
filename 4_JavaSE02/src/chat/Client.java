package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	/**
	 * 创建套接字
	 */
	private Socket socket;
	
	/** 
	 * 构造方法
	 * @throws Exception
	 */
	public Client() throws Exception {
		socket = new Socket("localhost", 8088);
		System.out.println("正在连接服务端.............");
		socket = new Socket("127.0.0.1", 8088);
		
		System.out.println("已经与服务端建立连接............");
	}
	
	/** 
	 * 启动客户端的方法
	 */
	public void start() {
		try {
			
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			
			/*
			 * 先要求用户输入一个昵称
			 */
			String userName = null;
			while (true) {
				System.out.println("Please input user name: ");
				userName = scan.nextLine();
				if (userName.length() > 0) {
					break;
				}
				System.out.println("Invalid Username!");
			}
			System.out.println("Welcome," + userName + ". Now start to talk");
			
			/*
			 * Socket提供的方法:
			 * OutputStream getOutputStream
			 * 获取一个字节输入流, 通过该流写出的数据会被发送到远程计算机
			 */
			OutputStream out = this.socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
			PrintWriter pw = new PrintWriter(osw, true);
			
			/*
			 * 将昵称发送给服务器
			 */
			pw.println(userName);
			
			/*
			 * 启动读取服务端发送过来的消息的线程
			 */
			ServerHandler handler = new ServerHandler();
			new Thread(handler).start();
			
			while (true) {
				pw.println(scan.nextLine());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] agrs ) {
		try {
			Client client = new Client();
			client.start();
		} catch(Exception e) {
			System.out.println("客户端启动失败");
//			e.printStackTrace();
		}
	}
	
	/*
	 * 该线程用于读取服务端发过来的消息,
	 * 并输出到客户端控制台
	 */
	class ServerHandler implements Runnable {
		@Override
		public void run() {
			try {
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				
				String msg = null;
				while ((msg = br.readLine()) != null) {
					System.out.println(msg);
				}
			} catch (Exception e) {
				
			}
		}
	}
	
	
}


