

/**
 * ���ǿͻ������ӷ������ĺ�̨
 */



import java.util.*;
import java.net.*;
import java.io.*;

public class ClientConnecttoServer {

	
	public  static Socket s;
	
	//���͵�һ������
	public boolean sendLoginInfoToServer(Object o)
	{
		boolean b=false;
		try {
			System.out.println("kk");
			s=new Socket("127.0.0.1",99);
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			
			Message ms=(Message)ois.readObject();
			//���������֤�û���¼�ĵط�
			if(ms.getMesType().equals("1"))
			{
				//�ʹ���һ����qq�źͷ������˱���ͨѶ���ӵ��߳�
				ClientConServerThread ccst=new ClientConServerThread(s);
				//������ͨѶ�߳�
				ccst.start();
				ManageClientConServerThread.addClientConServerThread
				(((User)o).getUserId(), ccst);
				b=true;
			}else{
				//�ر�Scoket
				s.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
		}
		return b;
	}
	
	public void SendInfoToServer(Object o)
	{
		/*try {
			Socket s=new Socket("127.0.0.1",9999);
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
		}*/
	}
}
