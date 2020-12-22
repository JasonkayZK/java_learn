



/**
 * ���������������ȴ�ĳ��qq�ͻ��ˣ������� 
 */


import java.net.*;  
import java.io.*;
import java.util.*;





public class Server {
	
	
	

	ServerSocket ss;
	public static void main (String args[])
	{
		new Server();
	    
		
	}
	
	public Server()
	{
		
		try {
			
			
			System.out.println("˽�ķ������ɹ�,�ڵ�������һ���ͻ���,����ȷ��qunliao_Server�Ƿ�������?");
			
		    ss=new ServerSocket(99);
			
			//����,�ȴ�����
			while(true)
			{
				Socket s=ss.accept();
				
				//���տͻ��˷�������Ϣ.
				
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				User u=(User)ois.readObject();
				System.out.println("���������յ��û�id:"+u.getUserId()+"  ����:"+u.getPasswd());
				Message m=new Message();
			
				
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			
				if(s!=null)
				{
					
						System.out.println("�ɹ���¼�����");
					
				
					//����һ���ɹ���½����Ϣ��
					
				
					m.setMesType("1");
					oos.writeObject(m);
					
					//����͵���һ���̣߳��ø��߳���ÿͻ��˱���ͨѶ.
					SerConClientThread scct=new SerConClientThread(s);
					ManageClientThread.addClientThread(u.getUserId(), scct);
					//������ÿͻ���ͨ�ŵ��߳�.
					scct.start();
			
					//��֪ͨ���������û�.
					scct.notifyOther(u.getUserId());
					
					
				}
				
				
                
				  
				 
				
//					System.out.print("aaaaa");
//					m.setMesType("2");
//					oos.writeObject(m);
//					//�ر�Socket
//					s.close();
//				
					
				
				
				
			}	
			
			
		} catch (BindException e) {
			System.out.println("�˿�ʹ����....");
			System.out.println("��ص���س����������з�������");
			System.exit(0);
		} catch (IOException e) {
			System.out.print(0);
		}catch (Exception e) {
			System.exit(0);
			// TODO: handle exception
		}finally{
			try {
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.exit(0);
			}
		}
		
	}
	
	
}
     
   //�����û���Ϣ��
 class User implements java.io.Serializable {

	private String userId;
	private String passwd;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
}
    
 
 class Message implements java.io.Serializable{

		private String mesType;
		
		private String sender;
		private String getter;
		private String con;
		private String sendTime;

		public String getSender() {
			return sender;
		}

		public void setSender(String sender) {
			this.sender = sender;
		}

		public String getGetter() {
			return getter;
		}

		public void setGetter(String getter) {
			this.getter = getter;
		}

		public String getCon() {
			return con;
		}

		public void setCon(String con) {
			this.con = con;
		}

		public String getSendTime() {
			return sendTime;
		}

		public void setSendTime(String sendTime) {
			this.sendTime = sendTime;
		}

		public String getMesType() {
			return mesType;
		}

		public void setMesType(String mesType) {
			this.mesType = mesType;
		}
	}
 
        
 /**
  * ��������ĳ���ͻ��˵�ͨ���߳� 
  */
  class SerConClientThread  extends Thread{

	Socket s;
	
	public SerConClientThread(Socket s)
	{
		//�ѷ������͸ÿͻ��˵����Ӹ���s
		this.s=s;
	}
	
	//�ø��߳�ȥ֪ͨ�����û�
	public void notifyOther(String iam)
	{
		//�õ��������ߵ��˵��߳�
		HashMap hm=ManageClientThread.hm;
		Iterator it=hm.keySet().iterator();
		
		while(it.hasNext())
		{
			Message m=new Message();
			m.setCon(iam);
			m.setMesType(MessageType.message_ret_onLineFriend);
			//ȡ�������˵�id
			String onLineUserId=it.next().toString();
			System.out.println(onLineUserId);
			try {
				ObjectOutputStream oos=new ObjectOutputStream(ManageClientThread.getClientThread(onLineUserId).s.getOutputStream());
				m.setGetter(onLineUserId);
				oos.writeObject(m);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
		}
	}
	
	public void run()
	{
		
		while(true)
		{
			
			//������߳̾Ϳ��Խ��տͻ��˵���Ϣ.
			try {
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message m=(Message)ois.readObject();
				
			//	System.out.println(m.getSender()+" �� "+m.getGetter()+" ˵:"+m.getCon());
				
				//�Դӿͻ���ȡ�õ���Ϣ���������жϣ�Ȼ������Ӧ�Ĵ���
				if(m.getMesType().equals(MessageType.message_comm_mes))
				{
					//һ�����ת��.
					//ȡ�ý����˵�ͨ���߳�
					SerConClientThread sc=ManageClientThread.getClientThread(m.getGetter());
					ObjectOutputStream oos=new ObjectOutputStream(sc.s.getOutputStream());
					oos.writeObject(m);
				}else if(m.getMesType().equals(MessageType.message_get_onLineFriend))
				{
					
					System.out.println(m.getSender()+" Ҫ���ĺ���");
					//���ڷ������ĺ��Ѹ��ÿͻ��˷���.
					String res=ManageClientThread.getAllOnLineUserid();
					Message m2=new Message();
					m2.setMesType(MessageType.message_ret_onLineFriend);
					m2.setCon(res);
					m2.setGetter(m.getSender());
					ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
					oos.writeObject(m2);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
			
			
		}
		
		
	}
}
  /**
   * �����������*/
       interface MessageType {

		String message_succeed="1";//�����ǵ�½�ɹ�
		String message_login_fail="2";//������¼ʧ��
		String message_comm_mes="3";//��ͨ��Ϣ��
		String message_get_onLineFriend="4";//Ҫ�����ߺ��ѵİ�
		String message_ret_onLineFriend="5";//�������ߺ��ѵİ�
	}

  class ManageClientThread {

		public static HashMap hm=new HashMap<String, SerConClientThread>();
		
		//��hm�����һ���ͻ���ͨѶ�߳�
		public static  void addClientThread(String uid,SerConClientThread ct)
		{
			hm.put(uid, ct);
		}
		
		public static SerConClientThread getClientThread(String uid)
		{
			return (SerConClientThread)hm.get(uid);
		}
		
		//���ص�ǰ���ߵ��˵����
		public static String getAllOnLineUserid()
		{
			//ʹ�õ��������
			Iterator it=hm.keySet().iterator();
			String res="";
			while(it.hasNext())
			{
				res+=it.next().toString()+" ";
			}
			return res;
		}
	}

  
  

