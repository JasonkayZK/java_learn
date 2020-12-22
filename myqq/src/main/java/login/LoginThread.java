package login;

import java.awt.Color;
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
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.MainPanel;
import utils.BackgroundUtils;
import utils.HoverPressUtils;


public class LoginThread extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private Login login;
	
	private JButton loginButton, closeButton, minButton, settingButton;
	
	private JLabel threadBackground, headImage, headImageBackground, loginLabel;
	
	private Container container;

	private BackgroundUtils background;
	
	private Point point;
	
	public static void main(String[] args) {
		Login login = new Login();
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new LoginThread(login).launchFrame();
	}

	public LoginThread(Login login) {
		this.login = login;
		
		container = this.getContentPane();
	}
	
	public void launchFrame() {
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
        // 面板的鼠标拖曳事件中移动窗体
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
		    @Override
			public void windowActivated(WindowEvent e) {
		    	LoginBackground thread = new LoginBackground();
		    	thread.start();
		    }
		});
		
		this.headImage = new JLabel(new ImageIcon(LoginThread.this.getClass().getResource("headimg.png")));
		headImage.setBounds( 80,202, 80, 79);
		
		this.headImageBackground = new JLabel(new ImageIcon(LoginThread.this.getClass().getResource("headimgbg.png")));
		headImageBackground.setBounds(78, 200, 84,84);
		
		this.threadBackground = new JLabel(new ImageIcon(LoginThread.this.getClass().getResource("login_head_white.png")));
		threadBackground.setBounds(0,205,437,40);

		this.loginLabel = new JLabel("取消登录");
		loginLabel.setForeground(Color.WHITE);
		loginLabel.setFont(new Font("宋体", Font.BOLD, 19));
		loginLabel.setBounds(165, 292, 250, 40);
		container.add(loginLabel);
		
		this.loginButton = HoverPressUtils.getbtnButton("image" + File.separator + "button_blue_normal.png", "image" + File.separator + "button_blue_press.png", "image" + File.separator + "button_blue_hover.png");
		loginButton.addActionListener(this);
		loginButton.setBounds(105, 288, 237, 48);
		container.add(loginButton);
		
		this.closeButton = HoverPressUtils.getCloseButton();
		closeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		closeButton.setBounds(400, 5, 27, 19);
		container.add(closeButton);
		
		this.minButton = HoverPressUtils.getMinButton();
		minButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		minButton.setBounds(375, 5, 27, 17);
		container.add(minButton);

		this.settingButton = HoverPressUtils.getSettingButton();
		settingButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
		        LoginSetting set=new LoginSetting(LoginThread.this.login);

		        set.launchFrame();  
		        set.setLocation(LoginThread.this.getX(), LoginThread.this.getY());
		        set.setVisible(true);
			}
		});
		settingButton.setBounds(347, 6, 27, 17);
		container.add(settingButton);
		
		background = new BackgroundUtils();
		background.setImage(this.getToolkit().getImage(getClass().getResource("loginbg.png")));
		background.setBounds(0,0,437,340);
		this.setIconImage(this.getToolkit().getImage(this.getClass().getResource("title.png")));
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login) {
			dispose();
			
			this.login.setLocation(LoginThread.this.getX(), LoginThread.this.getY());
			this.login.setVisible(true);
		}
	}

	private class LoginBackground extends Thread {
		private int loginX, loginY, loginLabelX, loginLabelY;
		private int headImageX, headImageY, headImageBackgroundX, headImageBackgroundY;
		private int threadBackgroundX, threadBackgroundY;
		
		private int i, j, k, o, p;
		
		private boolean verify;

		@Override
		public void run() {
			while (true) {
				threadBackgroundX = threadBackground.getBounds().x;
				threadBackgroundY = threadBackground.getBounds().y;
				headImageX = headImage.getBounds().x;
				headImageY = headImage.getBounds().y;
				headImageBackgroundX = headImageBackground.getBounds().x;
				headImageBackgroundY = headImageBackground.getBounds().y;
				loginLabelX = loginLabel.getBounds().x;
				loginLabelY = loginLabel.getBounds().y+3;
		        loginX = login.getBounds().x;
		        loginY = login.getBounds().y+3;
		        
				for(i = threadBackgroundY, j = headImageX, k = headImageBackgroundX, o = loginLabelY, p = loginY;
						i >= 171 && j<=198 && k <= 177 && o >= 120 && p >= 168;
						i = i - 1, j = j + 3, k = k + 3, o = o-1,p=p-1) {
				    	threadBackground.setLocation(0, i);
				    	headImage.setLocation(j, 202);
				    	headImageBackground.setLocation(k,200 );
				     	loginLabel.setLocation(165,o);
				     	login.setLocation(105,p );
				    	
				     	container.add(loginLabel);
				     	container.add(headImage);
				     	container.add(headImageBackground);
						
				     	container.add(threadBackground);
						
				     	container.add(background);
				     	container.repaint();
						try {
							Thread.sleep(6);
						} catch(InterruptedException e) {
							e.printStackTrace();
						}
				}
				
				if (threadBackgroundY == 173) {
					while (true) {
						for(int y = headImageY, y_bg = headImageBackgroundY;
								y >= 170 && y_bg >= 174;
								y-- , y_bg--) {
							headImage.setLocation(j, y);
							headImageBackground.setLocation(y_bg, y);
							
							container.repaint();
							try{
								Thread.sleep(30);
							} catch(InterruptedException  e) {
								e.printStackTrace();
							}
					    }
						verify = true;
						System.out.println("来了");
						
						LoginThread.this.setVisible(false);
						dispose();
						MainPanel m = new MainPanel(Login.username.getText());
						m.setVisible(true);
						
						return;
					}
				}
		        LinkTipPanel link = new LinkTipPanel();
		        link.setBounds(105, 307, 300,100);
		        container.add(link);
		        container.repaint();
			}
		}
	}
	
	private class LinkTipPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		
		public void paint(Graphics g) {
			   Color color=Color.darkGray;
			   g.setColor(color);
			   g.setFont(new Font("楷体",Font.BOLD,14));
			   g.drawString("正在连接服务器，请稍后.....",20, 20);
		}
	}
}
