


import java.io.*;
import java.net.*;


public class ClientConServerThread extends Thread {

	private Socket s;
	
	//���캯��
	public ClientConServerThread(Socket s)
	{
		this.s=s;
	}
	
	public void run()
	{
		while(true)
		{
			//��ͣ�Ķ�ȡ�ӷ������˷�������Ϣ
			try {
				
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message m=(Message)ois.readObject();
			/*	System.out.println("��ȡ���ӷ���������Ϣ"+ m.getSender() +" �� "+m.getGetter()+" ����"+
						m.getCon());*/
				
				if(m.getMesType().equals(MessageType.message_comm_mes))
				{
				
					//�Ѵӷ����������Ϣ����ʾ������ʾ���������
					dialog_panel dialog=ManageChat.getQqChat(m.getGetter()+" "+m.getSender());
					//��ʾ
					dialog.showMessage(m);
				}else if(m.getMesType().equals(MessageType.message_ret_onLineFriend))
				{
					System.out.println("�ͻ��˽��յ�"+m.getCon());
					String con=m.getCon();
					String friends[]=con.split(" ");
					String getter=m.getGetter();
					System.out.println("getter="+getter);
					//�޸���Ӧ�ĺ����б�.
					FriendList qqFriendList=ManageFriendList.getQqFriendList(getter);
					
				//	if(qqFriendList)
					//�������ߺ���.
					if(qqFriendList!=null)
					{
						qqFriendList.upateFriend(m);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}

	public Socket getS() {
		return s;
	}

	public void setS(Socket s) {
		this.s = s;
	}
	
}
