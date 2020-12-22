

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class FriendList extends JPanel implements ActionListener,MouseListener{

	//�����һ�ſ�Ƭ.
	
	JPanel jphy1,jphy2,jphy3;
	JButton jphy_jb1,jphy_jb2;
	JScrollPane jsp1;
	String owner;
	static String friendNo;
	//����ڶ��ſ�Ƭ(İ����).
	int counter_user;
	JPanel jpmsr1,jpmsr2,jpmsr3;
	JButton jpmsr_jb1,jpmsr_jb2;
	JScrollPane jsp2;
	JLabel []jb1s;
	//������JFrame���ó�CardLayout
	CardLayout cl;
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//	//	QqFriendList qqFriendList=new QqFriendList();
//	}
	
	//�������ߵĺ������
	public void upateFriend(Message m)
	{
		String onLineFriend[]=m.getCon().split(" ");
		
		for(int i=0;i<onLineFriend.length;i++)
		{
			
			jb1s[Integer.parseInt(onLineFriend[i])-10001].setEnabled(true);
		}

	}
	
	public  FriendList(String ownerId)
	{
		this.owner=ownerId;
		//�����һ�ſ�Ƭ(��ʾ�����б�)
		jphy_jb1=new JButton("�ҵĺ���");
		jphy_jb2=new JButton("İ����");
		jphy_jb2.addActionListener(this);
		
		jphy1=new JPanel(new BorderLayout());
		//�ٶ���50������
		jphy2=new JPanel(new GridLayout(50,1,4,4));
		jphy2.setBorder(BorderFactory.createEmptyBorder(2, 10, 6, 5));
		//��jphy2����ʼ��20����.
		jb1s =new JLabel[50];
	

		for(int i=0;i<50;i++)
		{
			jb1s[i]=new JLabel(i+10001+"",new ImageIcon("image/headimg/"+i+".png"),JLabel.LEFT);
			jb1s[i].setEnabled(false);
			if(jb1s[i].getText().equals(ownerId))
			{
				jb1s[i].setEnabled(true);
			}
			jb1s[i].addMouseListener(this);
			jb1s[i].setFont(new Font("ŷ��",Font.PLAIN,15));
			jphy2.add(jb1s[i]);
			
			
		}
		

		  //��ʱ�Ƚ�ע����û�����ͬ���û��ĺ������ݿ�
		//��ȡ�û���
//		FileReader fr;
//		boolean pd=true;
//		
//		try {
//				fr = new FileReader("���ݿ�//�û�ע�����ݿ�.txt");
//				BufferedReader in=new BufferedReader(fr);
//				
//				int x=0;
//				for(;in.readLine()!=null;)
//					x++;
//
//				counter_user=x;
//				fr = new FileReader("���ݿ�//�û�ע�����ݿ�.txt");
//				BufferedReader in2 = new BufferedReader(fr);
//				String sth=in2.readLine();
//				StringTokenizer st = new StringTokenizer(sth,"|");
//				
//				String yhm;
//			String suzu[]=new String[x];
//				for(int i=1;i<=x;i++)
//				{
//					yhm=st.nextToken();
//					
//
//					suzu[i-1]=yhm;
//				//	System.out.println("ren"+yhm);
//					
//					if(i==x) break;
//					st = new StringTokenizer(in2.readLine(),"|");
//					
//				}
//				
//				for(int i=0;i<counter_user;i++)
//			    {
//					jb1s[i]=new JLabel(suzu[i]+" ",new ImageIcon("image/headimg/"+i+".png"),JLabel.LEFT);
//					jb1s[i].setEnabled(false);
//					if(jb1s[i].getText().equals(ownerId))
//					{
//						jb1s[i].setEnabled(true);
//					}
//					jb1s[i].addMouseListener(this);
//					jphy2.add(jb1s[i]);
//			     }
//			} catch (FileNotFoundException e3) {
//				// TODO �Զ����ɵ� catch ��
//				e3.printStackTrace();
//			} catch (IOException e1) {
//				// TODO �Զ����ɵ� catch ��
//				e1.printStackTrace();
//			}
			
		
		
	
//		
		
		jphy3=new JPanel(new GridLayout(2,1));
		//��������ť���뵽jphy3
		jphy3.add(jphy_jb2);
        
		
		
		jsp1=new JScrollPane(jphy2);
		
		
		//��jphy1,��ʼ��
		jphy1.add(jphy_jb1,"North");
		jphy1.add(jsp1,"Center");
		jphy1.add(jphy3,"South");
		
		
		//����ڶ��ſ�Ƭ
		
		
		jpmsr_jb1=new JButton("�ҵĺ���");
		jpmsr_jb1.addActionListener(this);
		jpmsr_jb2=new JButton("İ����");
		
		
		jpmsr1=new JPanel(new BorderLayout());
		//�ٶ���40��İ����
		jpmsr2=new JPanel(new GridLayout(50,1,4,4));
		
		//��jphy2����ʼ��50İ����.
		JLabel []jb1s2=new JLabel[50];
		
		for(int i=0;i<jb1s2.length;i++)
		{
			if(i==0)
				jb1s2[i]=new JLabel("      ��Ů"+"  ",new ImageIcon("image/headimg/"+i+".png"),JLabel.LEFT);
			else if(i==1)
				jb1s2[i]=new JLabel("      Ұè��"+"  ",new ImageIcon("image/headimg/"+i+".png"),JLabel.LEFT);
		    else
			{
				
				jb1s2[i]=new JLabel("      �� ˿"+" "+i+"��  ",new ImageIcon("image/headimg/"+i+".png"),JLabel.LEFT);
				jb1s2[i].setFont(new Font("ŷ��",Font.BOLD,15));

			}
			jpmsr2.add(jb1s2[i]);
		}
		
		jpmsr3=new JPanel(new GridLayout(2,1));
		//��������ť���뵽jphy3
		jpmsr3.add(jpmsr_jb1);
		jpmsr3.add(jpmsr_jb2);
		
		
		jsp2=new JScrollPane(jpmsr2);
		jsp2.setBorder(BorderFactory.createEmptyBorder(2, 10, 6, 5));
		
		//��jphy1,��ʼ��
		jpmsr1.add(jpmsr3,"North");
		jpmsr1.add(jsp2,"Center");

		
		
		cl=new CardLayout();
		this.setLayout(cl);
		this.add(jphy1,"1");
		this.add(jpmsr1,"2");
		//�ڴ�����ʾ�Լ��ı��.
	
		this.setSize(140, 400);
		this.setVisible(true);
		
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//��������İ���˰�ť������ʾ�ڶ��ſ�Ƭ
		if(arg0.getSource()==jphy_jb2)
		{
			cl.show(this, "2");
		}else if(arg0.getSource()==jpmsr_jb1){
			cl.show(this,"1");
		}
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//��Ӧ�û�˫�����¼������õ����ѵı��.
		if(arg0.getClickCount()==2)
		{
			//�õ��ú��ѵı��
			 friendNo=((JLabel)arg0.getSource()).getText();
			//System.out.println("��ϣ���� "+friendNo+" ����");
			dialog_panel dialog=new dialog_panel(this.owner,friendNo);
			System.out.print(arg0.getSource().toString());
			
			
			
			//�����������뵽������
			ManageChat.addQqChat(this.owner+" "+friendNo, dialog);
			
		}
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel jl=(JLabel)arg0.getSource();
		jl.setBackground(Color.red);
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel jl=(JLabel)arg0.getSource();
		jl.setForeground(Color.black);
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
