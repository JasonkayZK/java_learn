

import java.awt.BorderLayout;
import java.awt.Color;   
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;






import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;








public class main_panel  extends JFrame {

 

	
     JLabel headimg,headimgbg;
     static JLabel usernicheng;
     JLabel qianming ;				//����ǩ��
	 JLabel kongjian ;					//QQ�ռ�ͼ��
	
	JLabel tianqi;					//����ͼ��

	JButton btnSearch ,huihua,lianxiren,konjian,konjian2, qun,weibo;					//������ť
	JTextField jtfSearch ;				//�����ı���
	Font font = new Font("΢���ź�", Font.PLAIN, 12);

	String userqianmingqianming;
     static JMenu  MenuStatus;
     JButton btnClose ;					//�رհ�ť
	 JButton btnMin ;						//��С����ť
	 JButton btnSkin ;						//������ť
	
	 JScrollPane js	 =new JScrollPane();//�����б�
	 
	 JScrollPane js2=new JScrollPane();//��ʱ�Ự�б�
	 JScrollPane js3=new JScrollPane();//�ռ��б�
	 JScrollPane js4=new JScrollPane();//΢���б�
	 JScrollPane jsqun=new JScrollPane();//΢���б�
	 
	 
	 qun_list_panel qunlist=new qun_list_panel();//Ⱥ
	 
	Container con=this.getContentPane();
	
	
	//�ⲿ�õ�����
	private long account = 0;								//�Լ����˺�
	private String picturePath;								//�Լ���ͷ��·��
	private String nicheng;								//�Լ����س�
	private String zhuantai;									//�Լ���״̬
	private String gexingqianming;							//�Լ��ĸ���ǩ��
	private String ip;								//�Լ���IP��ַ
	private int port;										//�Լ��Ķ˿ں�
	private String sex;										//�Լ����Ա�
	
	Point point;
	
	 JMenuBar mBar; // ��¼״̬�˵���
	 JMenu menuStatus;// ��¼״̬�˵�
	 JMenuItem zaixian;
	 JMenuItem yinshen ;
	JMenuItem manglu ;
	 JMenuItem likai ;
   JMenuItem qwo ;
	 JMenuItem wurao ;
	 FriendList qqList;
	
	
	public main_panel(String user)
	{
	 
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

	

			new Thread() {// �������߳�
	            public void run() {
	            	int screenwidth,screenheight;
	            	Toolkit kit=Toolkit.getDefaultToolkit();
	        		Dimension screensize=kit.getScreenSize();
	            	 screenwidth=(int)screensize.getWidth();
	        		 screenheight=(int)screensize.getHeight();
	                for (int i = 0; i <=674; i += 85) {// ѭ�����촰��
	                    setBounds( screenwidth/2-284/2, screenheight/2-i/2,284, i);// �������ô����С��λ��
	                    try {
	                        Thread.sleep(5);// �߳�����10����
	                    } catch (InterruptedException e1) {
	                        e1.printStackTrace();
	                    }
	                }
	            }
	        }.start();// �����߳�
    	       
		
		
	        usernicheng=new JLabel();
	    
            usernicheng.setText(user);
	        usernicheng.setBounds(79,37,80,17);
	        usernicheng.setFont(new Font("΢���ź�", Font.PLAIN, 12));
	        usernicheng.setForeground(Color.BLACK);
	       con.add(usernicheng);
	     	mBar = new JMenuBar(); // ��¼״̬�˵���
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
		
		
	

		mBar.setBounds(148, 40, 16, 14);
		con.add(mBar);
		mBar.updateUI();
		
		
		
		// ��½ͷ�񼰱���
		headimg=new JLabel(new ImageIcon("image/headimg2.jpg"));
		headimgbg=new JLabel(new ImageIcon("image/headimgbg.png"));
		
		con.add(headimg);
	    con.add(headimgbg);
	    
		headimg.setBounds(11, 41, 61, 60);
		headimgbg.setBounds(9, 39,65,65);
	   

		
		headimg.addMouseListener(new MouseAdapter() {

			public void mouseExited(MouseEvent e) {
			
				headimgbg.setBorder(BorderFactory.createLineBorder(new Color(147,112,219),20));
			   
			
			}
			public void mouseEntered(MouseEvent e) {
				
				headimgbg.setBorder(BorderFactory.createLineBorder(new Color(199,21,133 ),20));
				}
		});
	
	
		
		
	    btnClose = hover_press_utilclass.getbtnButton("image/Mainclose.png", 
				"image/Mainclose_hover.png",
				"image/Mainclose_press.png");
		btnMin = hover_press_utilclass.getbtnButton("image/Mainmin.png", 
				"image/Mainmin_hover.png",
				"image/Mainmin_press.png");
		btnSkin = hover_press_utilclass.getbtnButton("image/skin.png", 
				"image/skin_hover.png",
				"image/skin_press.png");
		
		con.add(btnClose);
		btnClose.setBounds(255, -2, 39, 20);
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
			 main_panel.this.dispose();
			 
//			 String exitUser = usernicheng.getText().trim();
//             Vector v = new Vector();
//             v.add("�˳���" + exitUser);
//             
//             try {
//                 out.writeObject(v);
//                 out.flush();// ˢ�����������
//             } catch (IOException ex) {
//                 ex.printStackTrace();
//             }
			}
		});
		
	   
		con.add(btnMin);
		btnMin.setBounds(230, -1, 28, 20);
		btnMin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
		    
				//setVisible(false);
			setExtendedState(JFrame.ICONIFIED);
				
			}
		});
		con.add(btnSkin);
		btnSkin.setBounds(204, -2, 28, 20);
		
		
		huihua= hover_press_utilclass.getbtnButton("image/xiang1.png", 
				"image/xiang1_press.png",
				"image/xiang1_press.png");
		lianxiren= hover_press_utilclass.getbtnButton("image/xiang2.png", 
				"image/xiang2_press.png",
				"image/xiang2_press.png");
		konjian= hover_press_utilclass.getbtnButton("image/xiang3.png", 
				"image/xiang3_press.png",
				"image/xiang3_press.png");
		qun= hover_press_utilclass.getbtnButton("image/xiang4.png", 
				"image/xiang4_press.png",
				"image/xiang4_press.png");
		weibo= hover_press_utilclass.getbtnButton("image/xiang5.png", 
				"image/xiang5_press.png",
				"image/xiang5_press.png");
		con.add(huihua);
		huihua.setToolTipText("��ʱ�Ự");
     	con.add(lianxiren);
     	lianxiren.setToolTipText("��ϵ��");
		con.add(konjian);
		konjian.setToolTipText("�ռ�");
		con.add(qun);
		qun.setToolTipText("Ⱥ�Ự");
		con.add(weibo);
		weibo.setToolTipText("΢��");
//		//�ٶ���50������
//		js.setVisible(false);
	
		
		huihua.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		//		System.out.print("Ⱥ");
				js.setVisible(false);
				js3.setVisible(false);
				js4.setVisible(false);
			
				js2.setVisible(true);
				con.repaint();
	//			System.out.print("Ⱥxxxxxx");
			
				
			}
			
		});
		konjian.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			//	System.out.print("Ⱥ");
				js2.setVisible(false);
				js.setVisible(false);
				js4.setVisible(false);
			
				js3.setVisible(true);
				con.repaint();
		//		System.out.print("Ⱥxxxxxx");
			
				
			}
			
		});
		weibo.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			//	System.out.print("Ⱥ");
				js2.setVisible(false);
				js.setVisible(false);
				js3.setVisible(false);
			
				js4.setVisible(true);
				con.repaint();
	//			System.out.print("Ⱥxxxxxx");
			
				
			}
			
		});
		lianxiren.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		//		System.out.print("��ϵ��");
				js2.setVisible(false);
				js4.setVisible(false);
				jsqun.setVisible(false);
				js3.setVisible(false);
				js.setVisible(true);
				
				con.repaint();
				
			}
			
		});
		qun.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		//		System.out.print("Ⱥ");
				js.setVisible(false);
				js3.setVisible(false);
				js2.setVisible(false);
				js4.setVisible(false);
				jsqun.setVisible(true);
				
				con.repaint();
		//		System.out.print("Ⱥxxxxxx");
			
				
			}
			
		});
		huihua.setBounds(14,141,34,40);
		lianxiren.setBounds(72,139,34,40);
		konjian.setBounds(129,135,34,46);
		qun.setBounds(178,141,34,40);
		weibo.setBounds(230,142,34,40);
		
		
		jtfSearch = new JTextField("����:��ϵ�ˡ������顢Ⱥ����ҵ");
		jtfSearch.setBorder(null);
		jtfSearch.setFont(new Font("����",Font.PLAIN,14));
		jtfSearch.setForeground(Color.darkGray);
		jtfSearch.setBackground(new Color(248,248,255 ) );
		
		jtfSearch.addMouseListener(new MouseAdapter() {

			
			public void mouseEntered(MouseEvent e) {
				
				jtfSearch.setBackground(Color.white);
				}
		});
		btnSearch = hover_press_utilclass.getbtnButton(
				"image/search.png",
				"image/search_hover.png",
				"image/search_press.png");

//		sousuoguanbi = hover_press_utilclass.getbtnButton(
//				"image/sousuoguanbi_press.png",
//				"image/sousuoguanbi_hover.png",
//				"image/sousuoguanbi_press.png");
		//�������ı������������
		jtfSearch.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				jtfSearch.setText("");
				
				
				
			 //   jtfSearch.setBackground(Color.white);
			   
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnSearch.updateUI();
				
			 //   jtfSearch.setBackground(Color.white);
			   
			}
		});
			
		jtfSearch.addKeyListener(new KeyAdapter(){

			@Override
			public void keyReleased(KeyEvent e){
				
			
				
		
				
			}
		});
		
		con.add(btnSearch);
		btnSearch.setBounds(250, 111, 22, 25);
		btnSearch.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	
		
			}
			
		});
	
			con.add(jtfSearch);
		jtfSearch.setBounds(1, 108, 282, 33);	
		
		
		
		userqianmingqianming="�Ұ��㣬�㰮����?";
		
		qianming = new JLabel(userqianmingqianming);	 // ����ǩ��
		qianming.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		qianming.setForeground(Color.BLACK);
		con.add(qianming);
	     qianming.setBounds(76, 54, 200, 20);	
	     
	 	//konjian2 = new JLabel(new ImageIcon("image/konjian.png"));// QQ�ռ�
	 	
		tianqi = new JLabel(new ImageIcon("image/tianqi.png"));
	        // con.add(konjian2);
		//	konjian2.setBounds(74, 74, 12, 12);
			con.add(tianqi );
			tianqi.setBounds(220, 30, 60, 50);
	     
//		 con.add(sousuoguanbi);
//			sousuoguanbi.setBounds(250, 110, 27, 24);
//		
//	   sousuoguanbi.updateUI(); 
//	
		
//	  
	     
		
			js.setBorder(null);
			
			
			js.setBounds(2,182 , 278, 430);
			js.setVisible(true);
			
			con.add(js);
		   
            js2.setBorder(null);
			js2.setBounds(2,182 , 278, 430);
			//js2.add(new JLabel("dfdfdflkdjflkdjkfldlkfjldkjfldjlfdjfdf"));
			js2.setViewportView(new JLabel("               ��ʱ�Ự�����δ���,�����ڴ�"));
			con.add(js2);
			//js2.setVisible(false);
			js3.setBorder(null);
			js3.setBounds(2,182 , 278, 430);
			//js2.add(new JLabel("dfdfdflkdjflkdjkfldlkfjldkjfldjlfdjfdf"));
			js3.setViewportView(new JLabel("               �ռ�Ự�����δ���,�����ڴ�"));
			con.add(js3);
			js4.setBorder(null);
			js4.setBounds(2,182 , 278, 430);
			//js2.add(new JLabel("dfdfdflkdjflkdjkfldlkfjldkjfldjlfdjfdf"));
			js4.setViewportView(new JLabel("               ΢���Ự�����δ���,�����ڴ�"));
			con.add(js4);
			jsqun.setBorder(null);
			jsqun.setBounds(2,182 , 278, 430);
			//js2.add(new JLabel("dfdfdflkdjflkdjkfldlkfjldkjfldjlfdjfdf"));
			jsqun.setViewportView(qunlist);
			con.add(jsqun);
	    	  ClientUser qqClientUser=new ClientUser();
				User u=new User();
				u.setUserId(Login.user.getText().trim());
				u.setPasswd(new String(Login.psw.getPassword()));
				
				
				if(qqClientUser.checkUser(u))
				{
					try {
						//�Ѵ��������б�������ǰ.
						
						 qqList=new FriendList(u.getUserId());
						 js.add(qqList);
						 js.setViewportView(qqList);
						
						ManageFriendList.addQqFriendList(u.getUserId(), qqList);
						
						//����һ��Ҫ�󷵻����ߺ��ѵ������.
						ObjectOutputStream oos=new ObjectOutputStream
						(ManageClientConServerThread.getClientConServerThread(u.getUserId()).getS().getOutputStream());
						
						//��һ��Message
						Message m=new Message();
						m.setMesType(MessageType.message_get_onLineFriend);
						//ָ����Ҫ�������qq�ŵĺ������.
						m.setSender(u.getUserId());
						oos.writeObject(m);
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
					
					
				}
	     
	     
	     
	
	    
		    System.out.println("1");
//	    
////		
//		  tree = new JTree();
//		  tree.setFont(new Font("΢���ź�", Font.PLAIN, 16));
//          tree.addTreeSelectionListener(new TreeSelectionListener() {
//            public void valueChanged(TreeSelectionEvent e) {
//                do_tree_valueChanged(e);
//            }
//        });
//        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
//      //  js.setViewportView(tree);
//////    
//        DefaultMutableTreeNode root = new DefaultMutableTreeNode("�����б�");
//        DefaultMutableTreeNode parent1 = new DefaultMutableTreeNode("�ҵĺ���");
//////     
//////        
//        parent1.add(new DefaultMutableTreeNode("����"));
//        parent1.add(new DefaultMutableTreeNode("ϵͳ�ͷ�"));
//
////        
////        
////        
////        
//////        
//        root.add(parent1);
//        DefaultMutableTreeNode parent2 = new DefaultMutableTreeNode("�ҵ�İ����");
//        parent2.add(new DefaultMutableTreeNode("İ����1"));
//        parent2.add(new DefaultMutableTreeNode("İ����2"));
//      
//        root.add(parent2);
//        DefaultTreeModel model = new DefaultTreeModel(root);
//        tree.setModel(model);
////////    
//        js.setViewportView(tree);
//////       
		
		
		background_utilclass bg=new background_utilclass();// �����������
		bg.setImage(this.getToolkit().getImage(getClass().getResource("mainbg.png")));// ������屳��ͼƬ
		bg.setBounds(0,0,284,674);
		con.add(bg);
		
		this.setIconImage(this.getToolkit().getImage(this.getClass().getResource("title.png")));

		this.setSize(284,674);
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);
		

	    this.setLocationRelativeTo(null);
    
//	    this.addWindowListener(new WindowAdapter()
//	    {
//	    	public void windowClosing(WindowEvent e)
//	    	{
//	    		
//	    		
//	    	}
//	    	  
//	    });
	}

	
	

	

	public JMenu getMenuStatus() {
		return menuStatus;
	}
	
	public long getAccount() {
		return account;
	}

	
	public String getnicheng() {
		return nicheng;
	}

	public void setnicheng(String nicheng) {
		this.nicheng = nicheng;
	}

	public String getgexingqianming() {
		return gexingqianming;
	}

	public void setgexingqianming(String gexingqianming) {
		this.gexingqianming = gexingqianming;
	}

	
	public String getIpAddress() {
		return ip;
	}

	public void setIpAddress(String ipAddress) {
		this.ip = ipAddress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}


	public String getuserqianmingqianming() {
		return userqianmingqianming;
	}

	public void userqianmingqianming(String  userqianmingqianming) {
		this.userqianmingqianming = userqianmingqianming;
	}



	public JLabel getLblHead() {
		return headimg;
	}

	public void setLblHead(JLabel lblHead) {
		this.headimg = lblHead;
	}

	public JLabel getLblgexingqianming() {
		return qianming;
	}

	public void setLblgexingqianming(JLabel lblgexingqianming) {
		this.qianming = lblgexingqianming;
	}

	public JLabel getLblUserName() {
		return usernicheng;
	}

	public void setLblUserName(JLabel lblUserName) {
		this.usernicheng = lblUserName;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	
	

//	public  void do_tree_valueChanged(TreeSelectionEvent e) {
//        TreePath path = tree.getSelectionPath();
//        if(path==null) {
//            return;
//        }
//        DefaultMutableTreeNode node = (DefaultMutableTreeNode)path.getLastPathComponent();
//          if (!(node.toString().equals("�����б�")||node.toString().equals("�ҵĺ���")||node.toString().equals("�ҵ�İ����")))
//          {
//        	  new dialog_panel(node.toString(),"����ǩ��");// ���÷��������׽��ֶ���;//main_panel.this.MenuStatus �д�����Ҫ�Ľ�
//        	  
//          }
//         
//        
//    }
//	

	


//	public static void main(String args[])
//
//	{
//		new main_panel();
//	}
//	
}
