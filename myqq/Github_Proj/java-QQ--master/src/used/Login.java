

import java.awt.Color ;       
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;




public class Login extends JFrame implements ActionListener {
	
	private JButton login,close,min,shezhi;
	static JTextField user;
	static  JPasswordField psw;
	 JLabel headimg,headimgbg,loginlb,jizumima,zidonglogin,denglu;
	JButton erweima;
	JButton duoyonghu,zhaohuimima,zhuce;
	static JCheckBox fuxuanzidong;
	static JCheckBox fuxuanjizumima;
	Point point;// ��ҷ����֮ǰ�����λ�ã�����Ա������
	Container con=this.getContentPane();
	
	Font font = new Font("΢���ź�", Font.PLAIN, 12);
	
	
   
	 int screenwidth,screenheight;
	 
	
	public void launch()
	{
		this.setSize(437,340);
	
		/*����*/
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screensize=kit.getScreenSize();
		 screenwidth=(int)screensize.getWidth();
		 screenheight=(int)screensize.getHeight();
		this.setLocation(screenwidth/2-this.getWidth()/2,screenheight/2-this.getHeight()/2 );
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

		
		
//			@Override
//			public void windowActivated(WindowEvent e) {
//				// TODO Auto-generated method stub
//
//				new Thread() {// �������߳�
//    	            public void run() {
//    	               
//    	                for (int i = 0; i <=340; i += 85) {// ѭ�����촰��
//    	                    setBounds( screenwidth/2-437/2, screenheight/2-i/2,437, i);// �������ô����С��λ��
//    	                    try {
//    	                        Thread.sleep(5);// �߳�����10����
//    	                    } catch (InterruptedException e1) {
//    	                        e1.printStackTrace();
//    	                    }
//    	                }
//    	            }
//    	        }.start();// �����߳�
//	    	       ]
//			}
          
	     	
		
	
	    
	 
	    
	  
		
		// ��½ͷ�񼰱���
		headimg=new JLabel(new ImageIcon("image/headimg.png"));
		headimgbg=new JLabel(new ImageIcon("image/headimgbg.png"));
		this.setLayout(null);
		
		headimg.setBounds(42, 197, 80, 79);
		headimgbg.setBounds(40, 195, 84,84);
		

		con.add(headimg);
		con.add(headimgbg);
	
		
		user=new JTextField(1000);
		user.addActionListener(this);
		user.setBorder(BorderFactory.createLineBorder(Color.black));
		user.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e)
			{
				user.setBorder(BorderFactory.createLineBorder(Color.red));
				
			}
			public void mouseEntered(MouseEvent e)
			{
				user.setBorder(BorderFactory.createLineBorder(Color.blue));
				
			}
			public void mouseExited(MouseEvent e)
			{
				user.setBorder(BorderFactory.createLineBorder(Color.black));
				
			}
		});
	
			
		
		
		psw=new JPasswordField(1000);
		psw.addActionListener(this);
		psw.setBorder(BorderFactory.createLineBorder(Color.black));
		psw.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
			
				if(e.getKeyCode()==10)
				{
			
					//�س��¼�

					//System.out.println("hi");
					do_login();

			}
			}
		});
		psw.addMouseListener(new MouseAdapter(){
			
			public void mouseEntered(MouseEvent e)
			{
				psw.setBorder(BorderFactory.createLineBorder(Color.blue));
				
			}
			public void mouseClicked(MouseEvent e)
			{
				psw.setBorder(BorderFactory.createLineBorder(Color.red));
				
			}
			public void mouseExited(MouseEvent e)
			{
				psw.setBorder(BorderFactory.createLineBorder(Color.black));
				
			}
		
		});
		
			
	//	user.setBorder(new LineBorder(Color.gray,1));
		user.setFont(new Font("����",Font.BOLD,19));
		user.setForeground(Color.black);
	//	psw.setBorder(new LineBorder(Color.gray,1));
		psw.setFont(new Font("����",Font.BOLD,9));
		psw.setEchoChar('��');
		psw.setForeground(Color.black);
		psw.setToolTipText("����������");
		user.setToolTipText("�������û��˺�");
		psw.requestFocus(true);
		user.setBounds(140, 197,174, 28);
		psw.setBounds(140, 230, 174, 28);
		
	
		zhuce=hover_press_utilclass.getbtnButton("image"
				+ "/zhuce_normal.png",
				"image/zhuce_press.png", "image/zhuce_hover.png");
		zhuce.addActionListener(this);
	
		
		JLabel loginlb=new JLabel("�� ȫ �� ¼");
		loginlb.setForeground(Color.white);
		loginlb.setFont(new Font("����",Font.BOLD,19));
	    login = hover_press_utilclass.getbtnButton(
						"image/button_blue_normal.png",
						"image/button_blue_press.png",
						"image/button_blue_hover.png");
		
	    login.addActionListener(this);
	    
	    con.add(loginlb);
		loginlb.setBounds(172, 292, 250, 40);
		con.add(login);
		login.setBounds(110, 288, 237, 48);
		
		
	     duoyonghu = hover_press_utilclass.getbtnButton(
				"image/duoyonghu.png",
				"image/duoyonghu_hover.png",
				"image/duoyonghu_press.png");
		duoyonghu.setToolTipText("���ʺŵ�¼");
		duoyonghu.addActionListener(this);
	
					
		erweima =  hover_press_utilclass.getbtnButton(
							"image/weixin.png",
							"image/weixin_hover.png",
							"image/weixin_press.png");
					erweima.setToolTipText("΢��");
		
					con.add(duoyonghu);
					duoyonghu.setBounds(2, 300, 40, 40);
					con.add(erweima);
					erweima.setBounds(396, 300, 40, 40);
					
		erweima.addActionListener(this);			
					
					// ע�ᰴť
					zhuce = hover_press_utilclass.getbtnButton("image/zhuce_normal.png",
							"image/zhuce_press.png", "image/zhuce_hover.png");
					zhuce.addActionListener(this);
					// �����һذ�ť
					zhaohuimima =  hover_press_utilclass.getbtnButton(
							"image/mima_normal.png", "image/mima_press.png",
							"image/mima_hover.png");
					zhaohuimima.addActionListener(this);
				
					// �Զ���½��ѡ��
					fuxuanzidong = hover_press_utilclass.getIconCheckBox(
							"image/checkbox_normal.png",
							"image/checkbox_hover.png",
							"image/checkbox_press.png",
							"image/checkbox_selected_hover.png");
					fuxuanzidong.addActionListener(this);
					// ��ס���븴ѡ��
					fuxuanjizumima =  hover_press_utilclass.getIconCheckBox(
							"image/checkbox_normal.png",
							"image/checkbox_hover.png",
							"image/checkbox_press.png",
							"image/checkbox_selected_hover.png");
					
					
				
					fuxuanjizumima.addActionListener(this);
					
					
					
					
					fuxuanzidong.setBounds(243,260,50,15);
					fuxuanzidong.addActionListener(this);
					con.add(fuxuanzidong);
					
					
					// �Զ���½��ǩ
					zidonglogin= new JLabel("�Զ���¼");
					zidonglogin.setFont(new Font("����",Font.BOLD,12));
					zidonglogin.setForeground(Color.lightGray);
					// ��ס�����ǩ
					zidonglogin.setBounds(260, 260,100, 12);
				    con.add(zidonglogin);
					
					jizumima = new JLabel("��ס����");
					jizumima.setFont(new Font("����",Font.BOLD,11));
					jizumima.setForeground(Color.lightGray);
					jizumima.setBounds( 155, 260, 100, 15);
					con.add(jizumima);
					
					fuxuanjizumima.setBounds(138,260,40,15);
					con.add(fuxuanjizumima);
					fuxuanjizumima.addActionListener(this);
					
					
					zhaohuimima.setBounds(330, 230, 51, 16);
					con.add(zhaohuimima);
					
				    zhuce.setBounds(330, 200, 51, 16);
					con.add(zhuce);
					
			
					
					
					con.add(user);
					con.add(psw);	
					
						
	   close=hover_press_utilclass.getbtnClose();
	   close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	   
	   min=hover_press_utilclass.getbtnMin();
	   
	   shezhi=hover_press_utilclass.getbtnShezhi();
	   shezhi.addActionListener(new ActionListener()
	   {

		   
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		    setVisible(false);
		    
	        loginingset set=new loginingset(Login.this);
	        set.launch();  
	        set.setLocation(Login.this.getX(),Login.this.getY());
	        set.setVisible(true);
        
		
		}
		   
	   });
		con.add(close);
		close.setBounds(400, 5, 27, 19);
		con.add(min);
		min.setBounds(375, 5, 27, 17);
     
		

        min.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
		    
				//setVisible(false);
			setExtendedState(JFrame.ICONIFIED);
				
			}
		});
		con.add(shezhi);
		shezhi.setBounds(347, 6, 27, 17);
		background_utilclass bg=new background_utilclass();// �����������
		bg.setImage(this.getToolkit().getImage(getClass().getResource("loginbg.png")));// ������屳��ͼƬ
		bg.setBounds(0,0,437,340);
		con.add(bg);
		con.repaint();
		
		this.setIconImage(this.getToolkit().getImage(this.getClass().getResource("title.png")));
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);

	    this.setVisible(true);
		
	}
	
	
	
	
	 
	public static void main(String args[])  
	{
   
		new Login().launch();
	}


	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		
		 if(e.getSource()==zhuce)
		{
			 this.setVisible(false);
			  zhuce ing=new  zhuce(Login.this);
				ing.launch();
			    ing.setLocationRelativeTo(null);
			    ing.setVisible(true);
		}
		else if(e.getSource()==zhaohuimima)
		{
			  this.setVisible(false);
			    zhaohuimima_panel ing=new  zhaohuimima_panel(Login.this);
				ing.launch();
			    ing.setLocationRelativeTo(null);
			    ing.setVisible(true);
		}
		
		else if(e.getSource()==login)
		{
			do_login();
		}
		else if(e.getSource()==erweima)
		{
			this.setVisible(false);
			erweima_panel ing=new  erweima_panel(Login.this);
			ing.launch();
		    ing.setLocation(Login.this.getX(),Login.this.getY());
		    ing.setVisible(true);
		}
		else if(e.getSource()==duoyonghu)
		{
			this.setVisible(false);
			duoyonghu_panel ing=new  duoyonghu_panel(Login.this);
			ing.launch();
		    ing.setLocation(Login.this.getX(),Login.this.getY());
		    ing.setVisible(true);
		}
		
		
	}
	
	
	public void do_login()
	{
		if(user.getText().length()!=0&&psw.getText().length()!=0)
		{
				FileReader fr;
				try {
					fr = new FileReader("���ݿ�//�û�ע�����ݿ�.txt");
					BufferedReader in=new BufferedReader(fr);
					
					int x=0;
					for(;in.readLine()!=null;)
						x++;

					fr = new FileReader("���ݿ�//�û�ע�����ݿ�.txt");
					BufferedReader in2 = new BufferedReader(fr);
					String sth=in2.readLine();
					StringTokenizer st = new StringTokenizer(sth,"|");
					boolean pd=false;
					
					for(int i=1;i<=x;i++)
					{
						if(user.getText().equals(st.nextToken()) && psw.getText().equals(st.nextToken()))
						{
					//		System.out.print("1");
								
							
							this.setVisible(false);
						    logining_thread ing=new  logining_thread(Login.this);
							ing.launch();
						    ing.setLocation(Login.this.getX(),Login.this.getY());
						    ing.setVisible(true);
						    
					
						    pd=true;
						    break;
						}
						if(i==x) break;
						st = new StringTokenizer(in2.readLine(),"|");
					}
					if(!pd)
						JOptionPane.showMessageDialog(this, "���������û������ڣ�");
				
				} catch (FileNotFoundException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(this, "���������û������ڣ�");
				}
		}
		
	}
	
	
	public JTextField getJtfAccount() {
		return user;
	}

	public JPasswordField getPwdfPassword() {
		return psw;
	}

	

	
}

