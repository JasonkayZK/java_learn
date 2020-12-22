

import java.awt.Color ;   
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;




import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class logining_thread extends JFrame implements ActionListener{

	Login loginframe;
	public  logining_thread(Login loginframe)
	{
		this.loginframe=loginframe;
	}
	
	duoyonghu_adding_panel panel;
	public logining_thread(duoyonghu_adding_panel panel)
	{
		this.panel=panel;
	}
	private JButton login,close,min,shezhi;
	
	
	duoyonghu_panel duoyonghu_panel;
	public logining_thread(duoyonghu_panel duoyonghu_panel)
	{
		this.duoyonghu_panel=duoyonghu_panel;
	}
	
	

	JButton erweima,duoyonghu;


	Container con=this.getContentPane();
	JLabel threadbg,headimg,headimgbg, loginlb;
	background_utilclass bg;
	static boolean yanzheng;
	 int screenwidth,screenheight;
		Point point;// ��ҷ����֮ǰ�����λ�ã�����Ա������
	
	public void launch()
	{
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
		
		
		this.addWindowListener(new WindowAdapter() {
    
            public void windowActivated(WindowEvent e) {
//				// TODO Auto-generated method stub
         
              loginingbg thread =new loginingbg();
	     		thread.start();
		}
         
		});
		
		
	 
	    
	    
	 
		
		
		headimg=new JLabel(new ImageIcon( logining_thread.this.getClass().getResource("headimg.png")));
		headimgbg=new JLabel(new ImageIcon( logining_thread.this.getClass().getResource("headimgbg.png")));
		headimg.setBounds( 80,202, 80, 79);
		headimgbg.setBounds(78, 200, 84,84);
		
		
		
		
		
		threadbg=new JLabel(new ImageIcon( logining_thread.this.getClass().getResource("login_head_white.png")));
		 threadbg.setBounds(0,205,437,40);
	//	 con.add(threadbg);
		// con.remove(threadbg);]
		 
		
		
		
	    loginlb=new JLabel("ȡ �� �� ¼");
		loginlb.setForeground(Color.white);
		loginlb.setFont(new Font("����",Font.BOLD,19));
	    login = hover_press_utilclass.getbtnButton(
						"image/button_blue_normal.png",
						"image/button_blue_press.png",
						"image/button_blue_hover.png");
		
	    login.addActionListener(this);
	    
	    
		loginlb.setBounds(165, 292, 250, 40);
		
		login.setBounds(105, 288, 237, 48);
	
		
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
					
						
	   close=hover_press_utilclass.getbtnClose();
	   close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	   
	   min=hover_press_utilclass.getbtnMin();
	   min.addActionListener(this);
	   shezhi=hover_press_utilclass.getbtnShezhi();
	   shezhi.addActionListener(new ActionListener()
	   {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			dispose();
		    
	        loginingset set=new loginingset( logining_thread.this.loginframe);
	       
	        
	         set.launch();  
	        set.setLocation( logining_thread.this.getX(), logining_thread.this.getY());
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
		
		
	
	//	bg=new JLabel(new ImageIcon( logining_thread.this.getClass().getResource("loginbg.png")));
		//bg.setBounds(0,0,437,340);
	//	con.add(bg);
		 bg=new background_utilclass();// �����������
		bg.setImage(this.getToolkit().getImage(getClass().getResource("loginbg.png")));// ������屳��ͼƬ
		bg.setBounds(0,0,437,340);
		this.setIconImage(this.getToolkit().getImage(this.getClass().getResource("title.png")));
		
		
	}
	
	
	
	   class loginingbg extends Thread
	   {
		   int login_x ;// ����ͼƬ�ƶ�λ�õ�x����
	        int login_y;// ����ͼƬ�ƶ�λ�õ�y����
	        int loginlb_x;
	        int loginlb_y;
	        
			int headimg_x;
			int headimgbg_x;
			int headimg_y;
			int headimgbg_y;
			int threadbg_x;
			int threadbg_y;
			
			int i,j,k,o,p;
			
			public void run()
			{
			
				while (true)
				{
					
				     
					threadbg_x=threadbg.getBounds().x;
					threadbg_y=threadbg.getBounds().y;
			 
					headimg_x=headimg.getBounds().x;
					headimg_y=headimg.getBounds().y;
					
					headimgbg_x=headimg.getBounds().x;
					headimgbg_y=headimg.getBounds().y;
					
				    loginlb_x=loginlb.getBounds().x;
				    
			         loginlb_y=loginlb.getBounds().y+3;
					
			         login_x=login.getBounds().x;
					    //,       ,k++,o--   &&loginlb_x==152&&login_x==90
			         login_y=login.getBounds().y+3;
			         
					for( i=threadbg_y,j=headimg_x,k=headimgbg_x,o=loginlb_y,p=login_y;i>=171&&j<=198&&k<=177 &&o>=120&&p>=168 ;i=i-1,j=j+3,k=k+3,o=o-1,p=p-1)
					{
					    	threadbg.setLocation(0, i);
					    	headimg.setLocation(j, 202);
					    	headimgbg.setLocation(k,200 );
					     	loginlb.setLocation(165,o);
					     	login.setLocation(105,p );
					    	
					     	con.add(loginlb);
							con.add(login);
							con.add(headimg);
							con.add(headimgbg);
							
							con.add(threadbg);
							
					
							
							con.add(bg);
							
						    con.repaint();
					//		System.out.println(threadbg_y);
							try
							{
								Thread.sleep(6);
							}
							catch(InterruptedException e)
							{
								e.printStackTrace();
							}


					    }
				
					if(threadbg_y==173)
					{
						
				//		System.out.print("stop");
						while(true)
						{
							for(int y=headimg_y,y_bg=headimgbg_y;y>=170&&y_bg>=174;y--,y_bg--)
						    {
							headimg.setLocation(j, y);
							headimgbg.setLocation(y_bg, y);
							
							con.repaint();
							
							try{
								this.sleep(30);
							}
							catch(InterruptedException  e)
							{
								e.printStackTrace();
							}
						    }
							
						//	System.out.println("dsfdsfdsfd"+headimg_y);System.out.println(headimgbg_y);
						
                            yanzheng=true;
							System.out.print("����");
						    logining_thread.this.setVisible(false);
									
									dispose();
									main_panel m=new main_panel(Login.user.getText());
							
								 
									m.setVisible(true);
								    
									
								return;
							
						}
						
					
						
						
					}
					
					link_tip_panel link=new link_tip_panel();
					link.setBounds(105, 307, 300,100);
					con.add(link);
					
					con.repaint();
					
				}
			}
			
			
		}
	


/*����
	 public static void main(String args[])
	   {
		    logining_thread du=new  logining_thread();
		   du.setVisible(true);
		   
	   }
*/
	 
	   
	   class link_tip_panel extends JPanel{
		   public void paint(Graphics g)
		   {
			   Color color=Color.darkGray;
			   g.setColor(color);
			   g.setFont(new Font("����",Font.BOLD,14));
			   g.drawString("�������ӷ����������Ժ�.....",20, 20);
			   
			   
		   }
	   }
	   
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==login)
		{
		   
		    dispose();
		    
		    loginframe.setLocation( logining_thread.this.getX(), logining_thread.this.getY());
		    loginframe.setVisible(true);
		    
		}
//		else if(e.getSource()==erweima)
//		{
//			dispose();
//			
//			  
//		    loginframe.setLocation( logining_thread.this.getX(), logining_thread.this.getY());
//		    loginframe.setVisible(true);
//		    
//		    
//		}
		
		
		
		
	}

	
}

