package qunliao_Server;



import java.io.*; 
import java.net.*;
import java.util.*;

public class qunliao_Server {
	
	
	boolean started = false;
	ServerSocket ss = null;
	
	List<Client> clients = new ArrayList<Client>();
	
    
	public static void main(String args[])
	{
		 new qunliao_Server().start();
	}
	public void start() {
		try {
			ss = new ServerSocket(8888);
			System.out.println("Ⱥ�ķ������ɹ�����������Login");
			started = true;
		} catch (BindException e) {
//			System.out.println("�˿�ʹ����....");
//			System.out.println("��ص���س����������з�������");
			
			System.exit(0);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			
			while(started) {
				Socket s = ss.accept();
				Client c = new Client(s);
              System.out.println("�ɹ���¼Ⱥ�Ľ���,���������������!");
				new Thread(c).start();
				clients.add(c);
				//dis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class Client implements Runnable {
		private Socket s;
		private DataInputStream dis = null;
		private DataOutputStream dos = null;
		private boolean bConnected = false;
		
		public Client(Socket s) {
			this.s = s;
			try {
				dis = new DataInputStream(s.getInputStream());
				dos = new DataOutputStream(s.getOutputStream());
				bConnected = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void send(String str) {
			try {
				dos.writeUTF(str);
			} catch (IOException e) {
				clients.remove(this);
			//	System.out.println("�Է��˳��ˣ��Ҵ�List����ȥ���ˣ�");
				//e.printStackTrace();
			}
		}
		
		public void run() {
			try {
				while(bConnected) {
					String str = dis.readUTF();
                //      System.out.println(str);
					for(int i=0; i<clients.size(); i++) {
						Client c = clients.get(i);
						c.send(str);
                   //System.out.println(" a string send !");
					}
					/*
					for(Iterator<Client> it = clients.iterator(); it.hasNext(); ) {
						Client c = it.next();
						c.send(str);
					}
					*/
					/*
					Iterator<Client> it = clients.iterator();
					while(it.hasNext()) {
						Client c = it.next();
						c.send(str);
					}
					*/
				}
			} catch (EOFException e) {
				System.out.println("�뿪��Ⱥ�Ľ���");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(dis != null) dis.close();
					if(dos != null) dos.close();
					if(s != null)  {
						s.close();
						//s = null;
					}
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				
			}
		}
		
	}
	
}
