

import java.awt.BorderLayout;  
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import java.awt.Color ;  
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;



public class dialog_panel extends JFrame implements ActionListener{

	ObjectOutputStream out;// �������������
	
	
	
	
	String info;
	JButton min,big,close,shezhi,guanbi,fasong;
	
	JButton btn1[]=new JButton[6];
	String btn1_str[]={"shexiang","yuyin","wjcs","taolun","yczm","pmfx"};
	
	JButton btn2[]=new JButton[10];
	String btn2_str[]={"ziti","bianqing","mfbq","pmdd","yyxx","dgnsr","fstp","diange","jietu","xiaoxi"};
	
	JLabel title_img,user_qianming,duifang,ziji;
	static JLabel user_name;
	JPanel pane1,pane2;
	 JTextArea xiansixiaoxi;
	 JTextField fasongxiaoxi;
	 String usernicheng=FriendList.friendNo;
	 String userqianming="����ǩ��       (ͷ��͸���ǩ��������)  ";
	Point point;
	 JMenuBar mBar; // ��¼״̬�˵���
	 static JMenu 	MenuStatus;// ��¼״̬�˵�

	JMenu menuStatus;
	 JMenuItem zaixian;
	 JMenuItem yinshen ;
	JMenuItem manglu ;
	 JMenuItem likai ;
	
      JMenuItem qwo ;
	 JMenuItem wurao ;
	 Font font = new Font("΢���ź�", Font.PLAIN, 12);
	 String ownerId;
	 String friendId;
	 
	public dialog_panel(String ownerId,String friend)
	{
		

		this.ownerId=ownerId;
		this.friendId=friend;
		
		mBar = new JMenuBar(); // ��¼״̬�˵���
		  this.menuStatus=MenuStatus;
		   menuStatus = new JMenu();// ��¼״̬�˵�
		   zaixian = new JMenuItem();
		   yinshen = new JMenuItem();
		   manglu = new JMenuItem();
		   likai = new JMenuItem();
	       qwo = new JMenuItem();
		   wurao = new JMenuItem();
		
		menuStatus.setIcon(new ImageIcon("image/zaixian.png"));
		menuStatus.setBorder(null);
		menuStatus.setFocusPainted(false);
		menuStatus.setContentAreaFilled(false);
		menuStatus.setName("zaixian");
		mBar.setBorder(null);
		menuStatus.setBorder(null);

		zaixian.setIcon(new ImageIcon("image/zaixian.png"));
		yinshen.setIcon(new ImageIcon("image/yinshen.png"));
		manglu.setIcon(new ImageIcon("image/manglu.png"));
		likai.setIcon(new ImageIcon("image/likai.png"));
		qwo.setIcon(new ImageIcon("image/qwo.png"));
		wurao.setIcon(new ImageIcon("image/wurao.png"));

		zaixian.setText("    ��������");
		zaixian.setFont(font);
		qwo.setText("    Q�Ұ�");
		qwo.setFont(font);
		likai.setText("    �뿪");
		likai.setFont(font);
		manglu.setText("    æµ");
		manglu.setFont(font);
		wurao.setText("    �������");
		wurao.setFont(font);
		yinshen.setText("    ����");
		yinshen.setFont(font);

		menuStatus.add(zaixian);
		menuStatus.addSeparator();
		menuStatus.add(qwo);
		menuStatus.add(likai);
		menuStatus.add(manglu);
		menuStatus.add(wurao);
		menuStatus.addSeparator();
		menuStatus.add(yinshen);
		mBar.add(menuStatus);
		mBar.setOpaque(false);// ���Ϊtrue��������������߽��ڵ���������
		menuStatus.setOpaque(false);

		zaixian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuStatus.setIcon(zaixian.getIcon());
				menuStatus.setName("zaixian");
			}
		});
		yinshen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuStatus.setIcon(yinshen.getIcon());
				menuStatus.setName("yinshen");
			}
		});
		manglu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuStatus.setIcon(manglu.getIcon());
				menuStatus.setName("manglu");
			}
		});
		likai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuStatus.setIcon(likai.getIcon());
				menuStatus.setName("likai");
			}
		});
		qwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuStatus.setIcon(qwo.getIcon());
				menuStatus.setName("qwo");
			}
		});
		wurao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuStatus.setIcon(wurao.getIcon());
				menuStatus.setName("wurao");
			}
		});
		

		
		mBar.setBounds(40, 40, 20, 16);
		add(mBar);
		mBar.updateUI();
	
		zaixian.setIcon(new ImageIcon("image/zaixian.png"));
		yinshen.setIcon(new ImageIcon("image/yinshen.png"));
		manglu.setIcon(new ImageIcon("image/manglu.png"));
		likai.setIcon(new ImageIcon("image/likai.png"));
		qwo.setIcon(new ImageIcon("image/qwo.png"));
		wurao.setIcon(new ImageIcon("image/wurao.png"));
		
		
		
		shezhi=hover_press_utilclass.getbtnShezhi();
		shezhi.setIcon(new ImageIcon("image/dialog/shezhi.png"));
		shezhi.setPressedIcon(new ImageIcon("image/dialog/shezhi_p.png"));
		shezhi.setRolloverIcon(new ImageIcon("image/dialog/shezhi_hover.png"));
		shezhi.setBounds(436, 2, 25, 16);
		add(shezhi);
		
		min=hover_press_utilclass.getbtnMin();
		min.setBounds(464, 2, 25, 16);
		add(min);
		min.setIcon(new ImageIcon("image/dialog/min.png"));
		min.setPressedIcon(new ImageIcon("image/dialog/min_p.png"));
		min.setRolloverIcon(new ImageIcon("image/dialog/min_hover.png"));
		min.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		
		big=hover_press_utilclass.getbtnClose();
		big.setBounds(492, 2, 25, 16);
		add(big);
		big.setIcon(new ImageIcon("image/dialog/big.png"));
		big.setRolloverIcon(new ImageIcon("image/dialog/big_hover.png"));
		big.setPressedIcon(new ImageIcon("image/dialog/big_p.png"));
		
		
		
		
		
		
		close=hover_press_utilclass.getbtnClose();
		close.setBounds(520, 2, 33, 16);
		add(close);
		close.setIcon(new ImageIcon("image/dialog/close.png"));
		close.setRolloverIcon(new ImageIcon("image/dialog/close_hover.png"));
		close.setPressedIcon(new ImageIcon("image/dialog/close_p.png"));
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				
				dialog_panel.this.dispose();
			}
		});
		
		//�رհ�ť
		guanbi=hover_press_utilclass.getbtnButton("image/dialog/guanbi.png", "image/dialog/guanbi_hover.png", "image/dialog/guanbi_p.png");
		guanbi.setBounds(230, 503, 71, 24);
		guanbi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				dialog_panel.this.dispose();
				 
				
			}
		});
		add(guanbi);
		
		//���Ͱ�ť
		fasong=hover_press_utilclass.getbtnButton("image/dialog/fasong.png", "image/dialog/fasong_hover.png", "image/dialog/fasong_p.png");
		fasong.setBounds(310, 503, 83, 24);
		add(fasong);
		fasong.addActionListener(this);
	
		duifang=new JLabel(new ImageIcon("image/dialog/duifang.png"));
		duifang.setBounds(405, 90, 143, 228);
		add(duifang);
		
		ziji=new JLabel(new ImageIcon("image/dialog/ziji.png"));
		ziji.setBounds(405, 390, 143, 142);
		add(ziji);
		
		title_img=new JLabel(new ImageIcon("image/dialog/touxiang.png"));
		title_img.setBounds(11, 11, 44, 44);
		add(title_img);
		
		user_name=new JLabel(usernicheng);
		user_name.setBounds(56, 12, 60, 20);
		add(user_name);
		
		user_qianming=new JLabel(userqianming);
		user_qianming.setBounds(60,33,300,20);
		add(user_qianming);
			//������Ϣ����
		fasongxiaoxi=new JTextField();
		fasongxiaoxi.setBorder(null);
		fasongxiaoxi.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
			
				if(e.getKeyChar()==KeyEvent.VK_ENTER)
				{

					System.out.println(e.getKeyCode());
					//����û�����ˣ����Ͱ�ť
					Message m=new Message();
					m.setMesType(MessageType.message_comm_mes);
					m.setSender(dialog_panel.this.ownerId);
					m.setGetter(dialog_panel.this.friendId);
					m.setCon(fasongxiaoxi.getText());
					
					DateFormat df = DateFormat.getDateInstance();// ���DateFormatʵ��
				    String dateString = df.format(new Date());         // ��ʽ��Ϊ����
				     df = DateFormat.getTimeInstance(DateFormat.MEDIUM);// ���DateFormatʵ��
				     String timeString = df.format(new Date());         // ��ʽ��Ϊʱ��
				 
				     m.setSendTime(dateString+"   "+timeString);
				     String temp=xiansixiaoxi.getText();
				     xiansixiaoxi.setText(temp+"��˵   : "+"                                        "+dateString+"   "+timeString+"\r\n"+"      "+fasongxiaoxi.getText()+"\r\n");
//				     try {
//							String filename="user//"+"(�û�)"+dialog_panel.user_name.getText()+"File//liaotianjilu.txt";
//							BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename,true)));		//����BufferedWriter����
//							out.write(temp+"��˵   : "+"                                        "+dateString+"   "+timeString+"\r\n"+"      "+fasongxiaoxi.getText()+"\r\n");
//						 	out.newLine();			//�½�һ��
//				
//						 	out.close();			//�ر���
//							
//						} catch (Exception e1) {					
//							e1.printStackTrace();
//						}
//				     
//				     
				     
				     fasongxiaoxi.setText(null);
				
					//���͸�������.
					try {
						ObjectOutputStream oos=new ObjectOutputStream
						(ManageClientConServerThread.getClientConServerThread(dialog_panel.this.ownerId).getS().getOutputStream());
						oos.writeObject(m);
					} catch (Exception ew) {
						ew.printStackTrace();
						// TODO: handle exception
					}
					
					
				

				}
			}

			
		});
	
		
		JScrollPane jsa1=new JScrollPane(fasongxiaoxi, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane1=new JPanel();
		pane1.setLayout(new BorderLayout());
		pane1.add(jsa1);
		pane1.setBounds(5,410, 395, 90);
		add(pane1);
		
		//��ʾ�Ի���Ϣ	
		xiansixiaoxi=new JTextArea();
	    xiansixiaoxi.setBorder(null);
	
		xiansixiaoxi.setLineWrap(true);
		JScrollPane jsa=new JScrollPane(xiansixiaoxi, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane2=new JPanel();
		pane2.setLayout(new BorderLayout());
		pane2.add(jsa);
		pane2.setBounds(5, 92, 395, 285);
		add(pane2);
		
		int x1=11;
		for(int i=0;i<6;i++)
		{
			btn1[i]=hover_press_utilclass.getbtnButton("image/dialog/"+btn1_str[i]+".png", "image/dialog/"+btn1_str[i]+"_hover.png", "image/dialog/"+btn1_str[i]+".png");
			btn1[i].setBackground(new Color(255,255,255));
			btn1[i].setBorder(null);
			btn1[i].setBounds(x1, 56, 34, 34);
			x1+=40;
			add(btn1[i]);
		}
		
		int x2=3;
		for(int i=0;i<10;i++)
		{
			btn2[i]=hover_press_utilclass.getbtnButton("image/dialog/"+btn2_str[i]+".png", "image/dialog/"+btn2_str[i]+"_hover.png", "image/dialog/"+btn2_str[i]+".png");
			//btn2[i].setIcon(new ImageIcon("image/dialog/"+btn2_str[i]+".png"));
			btn2[i].setBounds(x2, 382, 20, 20);
			btn2[i].setBorder(null);
			if(i==9)
			{
				btn2[i].setBounds(300, 380, 103,28 );
				btn2[i].addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						new liaotianjilu_panel();
					}
					
				});
			}
			x2+=30;
			add(btn2[i]);
		}

		background_utilclass bg=new background_utilclass();
		bg.setImage(dialog_panel.this.getToolkit().getImage(dialog_panel.this.getClass().getResource("dialogbg.png")));
		bg.setBounds(0, 0, 555,535);
		this.add(bg);
		
		this.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				point =e.getPoint();
			}
		});	
		
        // ���������ҷ�¼����ƶ�����
		this.addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{
				Point newpoint=e.getLocationOnScreen();
				
				setLocation(newpoint.x - point.x,newpoint.y-point.y);
				
			}
		});
		
		this.setAlwaysOnTop(true);
		this.setUndecorated(true);
		this.setSize(555, 535);
		this.setTitle(usernicheng);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setIconImage(this.getToolkit().getImage(this.getClass().getResource("title.png")));
		//this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		//this.setAlwaysOnTop(true);	
	
	
		
	
	

		
	}
	
	
	//дһ��������������ʾ��Ϣ
		public void showMessage(Message m)
		{
		
			info=m.getSender()+"˵:"+"                                     "+m.getSendTime()+"\r\n"+"    "+m.getCon()+"\r\n";
		    
			xiansixiaoxi.append(info);
		    try {
				String filename="user//"+"(�û�)"+dialog_panel.user_name.getText()+"File//liaotianjilu.txt";
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename,true)));		//����BufferedWriter����
				
				out.write(info);
			 	out.newLine();			//�½�һ��
			
			 	out.close();			//�ر���
				
			} catch (Exception e1) {					
				e1.printStackTrace();
			}
			
		    //==================================ʵʱ����Է������¼
           String info2="��˵:"+"                                     "+m.getSendTime()+"\r\n"+"    "+m.getCon()+"\r\n";
		    
			
		    try {
				String filename="user//"+"(�û�)"+m.getGetter()+"File//liaotianjilu.txt";
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename,true)));		//����BufferedWriter����
				
				out.write(info2);
			 	out.newLine();			//�½�һ��
			
			 	out.close();			//�ر���
				
			} catch (Exception e1) {					
				e1.printStackTrace();
			}
		
			
		}

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getSource()==fasong)
			{
				
				//����û�����ˣ����Ͱ�ť
				Message m=new Message();
				m.setMesType(MessageType.message_comm_mes);
				m.setSender(this.ownerId);
				m.setGetter(this.friendId);
				m.setCon(fasongxiaoxi.getText());
				
				DateFormat df = DateFormat.getDateInstance();// ���DateFormatʵ��
			    String dateString = df.format(new Date());         // ��ʽ��Ϊ����
			     df = DateFormat.getTimeInstance(DateFormat.MEDIUM);// ���DateFormatʵ��
			     String timeString = df.format(new Date());         // ��ʽ��Ϊʱ��
			 
			     m.setSendTime(dateString+"   "+timeString);
			     String temp=xiansixiaoxi.getText();
			     xiansixiaoxi.setText(temp+"��˵   : "+"                                        "+dateString+"   "+timeString+"\r\n"+"      "+fasongxiaoxi.getText()+"\r\n");
			 
				 fasongxiaoxi.setText(null);
			     
			     
				//���͸�������.
				try {
					ObjectOutputStream oos=new ObjectOutputStream
					(ManageClientConServerThread.getClientConServerThread(ownerId).getS().getOutputStream());
					oos.writeObject(m);
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				
				
			}
				
		}

	
	  
        
        
        
    }
    
	


