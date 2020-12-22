

import java.awt.Color;       
import java.awt.Container;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;



public class loginingset extends JFrame implements ActionListener{
	
	

	 JButton btnMin;
	 JButton btnClose ;
	 JButton btnConfirm ;
	 JButton btnCancel;
	 JButton btnTest ;
	 
	 JLabel lblBtnBkg ;

   	 JLabel lblNetSet;
	 JLabel lblNetType;
	 JComboBox cbxNetType;
	 JLabel lblNetAddress ;
	 JTextField jtfNetAddress ;
	 JLabel lblNetPort ;
	 JTextField jtfNetPort;

	 JLabel lblUserName ;
	 JTextField jtfUserName ;
	 JLabel lblPassword;
	 JPasswordField jtfPassword ;
	 JLabel lblField ;
	 JTextField jtfField;
     JLabel lblLoginServer ;
	 JLabel lblServerType ;
	 JComboBox cbxServerType;
	 JLabel lblServerAddress;
	 static JTextField jtfServerAddress = new JTextField("127.0.0.1");;
	 JLabel lblServerPort ;
	 static  String Serveraddress="127.0.0.1",
			 Serverport="123";
	 
	 public static JTextField jtfServerPort = new JTextField("123");

	Font font = new Font("΢���ź�", Font.PLAIN, 12);

	Login login;
	Point point;// ��ҷ����֮ǰ�����λ�ã�����Ա������
	public loginingset(Login login)
	{
		this.login=login;
		
	}
	duoyonghu_panel duo;
	
	public void launch() {
		this.setSize(437, 340);
		this.setIconImage(this.getToolkit().getImage(this.getClass().getResource("title.png")));
		
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);
  
     	this.setLocationRelativeTo(null);
        this.setLayout(null);
		
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
				setLocation(newpoint.x-point.x,newpoint.y-point.y);
			}
		});

	
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		lblNetSet = new JLabel("��������");
		lblNetSet.setFont(font);
		lblNetSet.setForeground(Color.black);
		lblNetType = new JLabel("���ͣ�");
		lblNetType.setFont(font);
		lblNetType.setForeground(Color.black);
		lblNetAddress = new JLabel("��ַ��");
		lblNetAddress.setFont(font);
		lblNetAddress.setForeground(Color.black);
		lblNetPort = new JLabel("�˿ڣ�");
		lblNetPort.setFont(font);
		lblNetPort.setForeground(Color.black);
		String[] items = new String[] { "��ʹ�ô���", "HTTP����", "SOCKSS����",
				"ʹ�����������" };
		cbxNetType = new JComboBox(items);
		cbxNetType.setFont(font);
		cbxNetType.setForeground(Color.black);
		jtfNetAddress = new JTextField();
		jtfNetAddress.setBorder(new LineBorder(Color.GRAY));
		jtfNetAddress.setFont(font);
		jtfNetAddress.setForeground(Color.black);
//		jtfNetAddress.setEnabled(false);
		jtfNetPort = new JTextField();
		jtfNetPort.setBorder(new LineBorder(Color.GRAY));
		jtfNetPort.setFont(font);
		jtfNetPort.setForeground(Color.black);
//		jtfNetPort.setEnabled(false);
		
		
		lblUserName = new JLabel("�û�����");
		lblUserName.setFont(font);
		lblUserName.setForeground(Color.black);
		jtfUserName = new JTextField();
		jtfUserName.setBorder(new LineBorder(Color.GRAY));
		jtfUserName.setFont(font);
		jtfUserName.setForeground(Color.black);
//		jtfUserName.setEnabled(false);

		lblPassword = new JLabel("���룺");
		lblPassword.setFont(font);
		lblPassword.setForeground(Color.black);
		jtfPassword = new JPasswordField();
		jtfPassword.setBorder(new LineBorder(Color.GRAY));
		jtfPassword.setFont(font);
		jtfPassword.setForeground(Color.black);

		
		lblField = new JLabel("��");
		lblField.setFont(font);
		lblField.setForeground(Color.black);
		jtfField = new JTextField();
		jtfField.setBorder(new LineBorder(Color.GRAY));
		jtfField.setFont(font);
		jtfField.setForeground(Color.black);
    
		
		lblLoginServer = new JLabel("��½������");
		lblLoginServer.setFont(font);
		lblLoginServer.setForeground(Color.black);
		lblServerType = new JLabel("���ͣ�");
		lblServerType.setFont(font);
		lblServerType.setForeground(Color.black);
		lblServerAddress = new JLabel("��ַ��");
		lblServerAddress.setFont(font);
		lblServerAddress.setForeground(Color.black);
		lblServerPort = new JLabel("�˿ڣ�");
		lblServerPort.setFont(font);
		lblServerPort.setForeground(Color.black);

		cbxServerType = new JComboBox(new String[] { "TCP����" , "UDP����", "��ʹ�ø߼�ѡ��"});
		cbxServerType.setFont(font);
		cbxServerType.setForeground(Color.black);

		jtfServerAddress.setBorder(new LineBorder(Color.GRAY));
		jtfServerAddress.setFont(font);
		jtfServerAddress.setForeground(Color.black);

		
		jtfServerPort.setBorder(new LineBorder(Color.GRAY));
		jtfServerPort.setFont(font);
		jtfServerPort.setForeground(Color.black);

       
	

	
	    
		Container content=this.getContentPane();
	
		
		lblNetSet.setBounds(14, 60, 60, 20);
		content.add(lblNetSet);

		
		lblNetType.setBounds(24, 110, 50, 20);
		content.add(lblNetType);
		
		cbxNetType.setBounds(60,110, 110, 21);
		content.add(cbxNetType);
		
		lblNetAddress.setBounds(182,110, 50, 20);
		content.add(lblNetAddress);
		
		jtfNetAddress.setBounds(215, 110, 80, 22);
		content.add(jtfNetAddress);
		
		jtfNetAddress.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
			
				if(jtfNetAddress.getText() != null)
				{
					btnTest.setEnabled(true);
					
				}
				
				
			}
		});
		
		
		lblNetPort.setBounds(315, 110, 50, 20);
		content.add(lblNetPort);
		
		jtfNetPort.setBounds(350, 110, 60, 22);
		content.add(jtfNetPort);

		
		lblUserName.setBounds(14, 140, 50, 21);
		content.add(lblUserName);
		
		jtfUserName.setBounds(60, 140, 110, 22);
		content.add(jtfUserName);
		
		lblPassword.setBounds(182, 140, 50, 20);
		content.add(lblPassword);
		
	   jtfPassword.setBounds(215, 140, 80, 22);
		content.add(jtfPassword);
		
		lblField.setBounds(322, 140, 50, 20);
		content.add(lblField);
		
		jtfField.setBounds(350, 140, 60, 22);
		content.add(jtfField);

		 
	   
		
		lblLoginServer.setBounds(15, 200, 85, 22);
		content.add(lblLoginServer);

		
		lblServerType.setBounds(24, 245, 50, 20);
		content.add(lblServerType);
		
		cbxServerType.setBounds(60, 245, 110, 21);
		content.add(cbxServerType);
		
		lblServerAddress.setBounds(182, 245, 50, 20);
		content.add(lblServerAddress);
	
		jtfServerAddress.setBounds(215, 245, 80, 22);
		content.add(jtfServerAddress);
		
		lblServerPort.setBounds(315, 245, 60, 20);
		content.add(lblServerPort);
		
		jtfServerPort.setBounds(350, 245, 55, 22);
		content.add(jtfServerPort);
		
		
		btnClose = hover_press_utilclass.getbtnClose();
		
		btnMin=hover_press_utilclass.getbtnMin();
		
		btnCancel=new JButton("ȡ��");
		btnCancel.setForeground(Color.black);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setFont(font);
		btnCancel.addActionListener(this);
		
		btnConfirm=new JButton("ȷ��");
		btnConfirm.setForeground(Color.black);
		btnConfirm.setContentAreaFilled(false);
		btnConfirm.setFont(font);

	
		
	    btnConfirm.addActionListener(this);
        
	    
		btnTest=new JButton("����");
		btnTest.setEnabled(false);
	    btnTest.setForeground(Color.black);
		btnTest.setContentAreaFilled(false);
		btnTest.setFont(font);
		
		btnMin.setBounds(368, 2, 28, 20);
		content.add(btnMin);
		btnMin.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
			    
					
				setExtendedState(JFrame.ICONIFIED);
					
				}
			});
		
		
		btnClose.setBounds(395, 3, 39, 20);
		content.add(btnClose);
		btnClose.addActionListener(this);
		
		//�����ƵĲ��Թ���
		 btnTest.setBounds(350, 170, 60, 25);
		content.add(btnTest);
			
		btnConfirm.setBounds(245, 308, 85, 25);
		content.add(btnConfirm);
		btnConfirm.addActionListener(this);
		
		btnCancel.setBounds(330, 308, 85, 25);
		content.add(btnCancel);
        btnCancel.addActionListener(this);
		
		
		background_utilclass bg=new background_utilclass();// �����������
		bg.setImage(this.getToolkit().getImage(getClass().getResource("shezhibg.png")));// ������屳��ͼƬ
		bg.setBounds(0,0,437,340);
		content.add(bg);
	
	
		
	}

	






	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==btnCancel||e.getSource()==btnClose)
		{
			
		     dispose();
		     login.setLocation(loginingset.this.getX(),loginingset.this.getY());
		     login.setVisible(true);
		}
		else if(e.getSource()==btnConfirm)
		{
			dispose();
			login.setLocation(loginingset.this.getX(),loginingset.this.getY());
            login.setVisible(true);
            Serveraddress=jtfServerAddress.getText();
            Serverport=jtfServerPort.getText();
            
		}
			
	}

	

	
	
}
