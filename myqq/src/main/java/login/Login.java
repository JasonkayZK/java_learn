package login;

import java.awt.Color;
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
import java.io.File;
import java.sql.Connection;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import exceptions.LoginException;
import jdbc.DBUtils;
import jdbc.Transaction;
import registor.RegistorPanel;
import utils.BackgroundUtils;
import utils.HoverPressUtils;

public class Login extends JFrame implements ActionListener {
	// 反序列化UID
	private static final long serialVersionUID = 1L;

	// 登录界面按钮与提示栏，输入栏
	private JButton loginButton, close, min, setting;
	public static JTextField username;
	private static JPasswordField password;
	
	private JLabel headimg, headimgbg, rememberPassword, antoLogin, loginLabel;
	private JButton QRcode;
	private JButton multiUser, findPassword, register;
	
	private static JCheckBox autoLoginBox;
	private static JCheckBox rememberLoginBox;
	
	// 鼠标位置记录和容器
	private Point point; // Mouse position
	private Container container = this.getContentPane();
	
	// 用户显示器大小
	private int screenWidth, screenHeight;
	
	// 测试Main函数
	public static void main(String[] args) {
		new Login().launchFrame();
	}
	
	public void initWindow() {
		// 设置登陆窗口大小
		this.setSize(437, 340);
		
		// 窗口居中
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screensize = kit.getScreenSize();
		this.screenWidth = (int)screensize.getWidth();
		this.screenHeight = (int)screensize.getHeight();
		this.setLocation(this.screenWidth / 2 - this.getWidth() / 2, this.screenHeight / 2 - this.getHeight() / 2);
		
		/* 鼠标拖动窗体设置 */
		// 鼠标按下记录鼠标位置
		this.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				point = e.getPoint();
				
			}
		});
		
		// 鼠标拖动行为移动窗体
		this.addMouseMotionListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseDragged(MouseEvent e) {
				Point newPoint = e.getLocationOnScreen();
//						System.out.println("Old: x: " + point.x + ", y: " + point.y);
//						System.out.println("New: x: " + newPoint.x + ", y: " + newPoint.y);
				setLocation(newPoint.x - point.x, newPoint.y - point.y);
			}
			
		});		
	}
	
	public void initHeadImg() {
		// 设置登录头像和背景, 并添加到容器
		this.headimg = new JLabel(new ImageIcon("image/headimg.png"));
		this.headimgbg = new JLabel(new ImageIcon("image/headimgbg.png"));
		this.setLayout(null);
		
		this.headimg.setBounds(42, 197, 80, 79);
		this.headimgbg.setBounds(40, 195, 84, 84);
		
		this.container.add(headimg);
		this.container.add(headimgbg);
	}
	
	public void initUsernameField() {
		/* 登录用户名设置区域 */
		// 设置用户名登录框
		Login.username = new JTextField(1000);
		Login.username.addActionListener(this);
		Login.username.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// 设置鼠标移入后输入栏颜色变化
		Login.username.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				username.setBorder(BorderFactory.createLineBorder(Color.RED));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				username.setBorder(BorderFactory.createLineBorder(Color.BLUE));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				username.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
		});
		// 设置用户名字体
		Login.username.setFont(new Font("楷体", Font.BOLD, 19));
		Login.username.setForeground(Color.BLACK);
		
		// 设置用户点击提示信息
		Login.username.setToolTipText("请输入用户名");
		
		// 设置用户名框体大小
		Login.username.setBounds(140, 197, 174, 28);
		this.container.add(Login.username);
	}
	
	public void initPasswordField() {
		/* 登陆密码设置区域 */
		// 设置密码登陆框
		Login.password = new JPasswordField(1000);
		Login.password.addActionListener(this);
		Login.password.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// 定义回车按下事件
		Login.password.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) { // Enter
					loginAction();
				}
			}
		});
		
		// 设置鼠标移入后输入栏颜色变化
		Login.password.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				Login.password.setBorder(BorderFactory.createLineBorder(Color.BLUE));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Login.password.setBorder(BorderFactory.createLineBorder(Color.RED));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				Login.password.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
			
		});
		
		Login.password.setFont(new Font("楷体", Font.BOLD, 15));
		Login.password.setEchoChar('*');
		Login.password.setForeground(Color.BLACK);
		Login.password.setToolTipText("请输入密码");
		Login.password.requestFocus(true);
		Login.password.setBounds(140, 230, 174, 28);
		this.container.add(Login.password);
	}
	
	public void initRegistor() {
		/* 注册部分 */
		// 注册按钮
		this.register = HoverPressUtils.getbtnButton("image" + File.separator + "registor_normal.png", "image" + File.separator + "registor_press.png", "image" + File.separator + "registor_hover.png");
		this.register.addActionListener(this);
		this.register.setLayout(null);
		this.register.setBounds(330, 200, 51, 16);
		this.container.add(this.register);
	}
	
	public void initLogin() { 
		/* 登录部分 */
		// 登录标签部分
		this.loginLabel = new JLabel("安全登录");
		this.loginLabel.setForeground(Color.WHITE);
		this.loginLabel.setFont(new Font("宋体", Font.BOLD, 19));
		this.container.add(this.loginLabel);
		this.loginLabel.setBounds(172, 292, 250, 40);
		// 登录按钮
		this.loginButton = HoverPressUtils.getbtnButton("image" + File.separator + "button_blue_normal.png", "image" + File.separator + "button_blue_press.png", "image" + File.separator + "button_blue_hover");
		this.loginButton.addActionListener(this);
		this.container.add(this.loginButton);
		this.loginButton.setBounds(125, 288, 180, 48);
	}
	
	public void initMultiUser() {
		/* 多用户登录 */
		this.multiUser = HoverPressUtils.getbtnButton("image" + File.separator + "multiuser.png", "image" + File.separator + "multiuser_hover.png", "image" + File.separator + "multiuser_press");
		this.multiUser.setToolTipText("多账号登录");
		this.multiUser.addActionListener(this);
		this.multiUser.setBounds(2, 300, 40, 40);
		this.container.add(multiUser);
	}
	
	public void initQRCodeLogin() {
		/* 二维码登录 */
		this.QRcode = HoverPressUtils.getbtnButton("image" + File.separator + "wechat.png", "image" + File.separator + "wechat_press.png", "image" + File.separator + "wechat_hover.png");
		this.QRcode.setToolTipText("微信");
		this.QRcode.addActionListener(this);
		this.QRcode.setBounds(396, 300, 40, 40);
		this.container.add(QRcode);	
	}
	
	public void initFindPassword() {
		/* 找回密码 */
		this.findPassword = HoverPressUtils.getbtnButton("image"+ File.separator + "findpassword_normal.png", "image" + File.separator + "findpassword_press.png", "image" + File.separator + "findpassword_hover.png");
		this.findPassword.addActionListener(this);
		this.findPassword.setBounds(330, 230, 51, 16);
		this.container.add(this.findPassword);
	}
	
	public void initAutoLogin() {
		/* 自动登录 */
		// 自动登录复选框
		Login.autoLoginBox = HoverPressUtils.getIconCheckBox("image" + File.separator + "checkbox_normal.png", "image" + File.separator + "checkbox_press.png", "image" + File.separator + "checkbox_hover.png", "image" + File.separator + "checkbox_selected_hover.png");
		Login.autoLoginBox.addActionListener(this);
		Login.autoLoginBox.setBounds(243,260,50,15);
		Login.autoLoginBox.addActionListener(this);
		this.container.add(Login.autoLoginBox);
		// 自动登录标签
		this.antoLogin = new JLabel("自动登录");
		this.antoLogin.setFont(new Font("楷体", Font.BOLD, 12));
		this.antoLogin.setForeground(Color.LIGHT_GRAY);
		this.antoLogin.setBounds(260, 260,100, 12);
		this.container.add(antoLogin);		
	}
	
	public void initRememberPassword() {
		/* 记住密码 */
		// 记住密码复选框
		Login.rememberLoginBox = HoverPressUtils.getIconCheckBox("image" + File.separator + "checkbox_normal.png", "image" + File.separator + "checkbox_press.png", "image" + File.separator + "checkbox_hover.png", "image" + File.separator + "checkbox_selected_hover.png");
		Login.rememberLoginBox.addActionListener(this);
		Login.rememberLoginBox.setBounds(138,260,40,15);
		Login.rememberLoginBox.addActionListener(this);
		this.container.add(rememberLoginBox);
		// 记住密码标签
		this.rememberPassword = new JLabel("记住密码");
		this.rememberPassword.setFont(new Font("楷体", Font.BOLD, 11));
		this.rememberPassword.setForeground(Color.LIGHT_GRAY);
		this.rememberPassword.setBounds(155, 260, 100, 15);
		this.container.add(this.rememberPassword);
	}
	
	public void initCloseButton() {
		/* 关闭按钮 */
		this.close = HoverPressUtils.getCloseButton();
		this.close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.close.setBounds(400, 5, 27, 19);
		this.container.add(close);
	}
	
	public void initMinButton() {
		/* 最小化按钮 */
		this.min = HoverPressUtils.getMinButton();
		this.min.setBounds(375, 5, 27, 17);
		this.min.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		this.container.add(this.min);
	}
	
	public void initSettingButton() {
		/* 设置按钮 */
		this.setting = HoverPressUtils.getSettingButton();
		this.setting.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
				LoginSetting set = new LoginSetting(Login.this);
				set.launchFrame();
				set.setLocation(Login.this.getX(), Login.this.getY());
				set.setVisible(true);
			}
		});
		this.setting.setBounds(347, 6, 27, 17);
		this.container.add(this.setting);
	}
	
	public void initBackground() {
		BackgroundUtils bg = new BackgroundUtils(); // 创建背景面板
		bg.setImage(this.getToolkit().getImage(this.getClass().getResource("loginbg.png")));
		bg.setBounds(0,0,437,340);
		this.container.add(bg);
	}
	
	public void launchFrame() {
		initWindow();
		initHeadImg();
		initUsernameField();
		initPasswordField();
		initRegistor();
		initLogin();
		initMultiUser();
		initQRCodeLogin();
		initFindPassword();
		initAutoLogin();
		initRememberPassword();
		initCloseButton();
		initMinButton();
		initSettingButton();
		initBackground();
		
		this.container.repaint();
		// 窗口设置
		this.setIconImage(this.getToolkit().getImage(this.getClass().getResource("title.png")));
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);
		
		this.setVisible(true);
	}

	@SuppressWarnings("deprecation")
	public void loginAction() {
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			if (Login.username.getText().length() != 0 && Login.password.getPassword().toString().length() != 0) {
				try {
					if (Transaction.login(Login.username.getText(), Login.password.getText(), conn)) {
//						JOptionPane.showMessageDialog(this, "登录成功！");
						dispose();
						LoginThread logining = new LoginThread(Login.this);
						logining.launchFrame();
						logining.setLocation(Login.this.getX(), Login.this.getY());
						logining.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(this, "密码错误！");
					}
				} catch (LoginException e) {
					JOptionPane.showMessageDialog(this, "登陆失败!请重试！");
				}
			} 
		} finally {
			DBUtils.close(conn);
		}
	}

	public void registorAction() {
		RegistorPanel reg = new RegistorPanel(Login.this);
		reg.launchFrame();
		reg.setLocationRelativeTo(null);
		reg.setVisible(true);
	}
	
	public void QRcodeAction() {
		
	}
	
	public void multiUserAction() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == register) {
			registorAction();
		} else if (e.getSource() == findPassword) {
			
		} else if (e.getSource() == loginButton) {
			loginAction();
		} else if (e.getSource() == QRcode) {
			QRcodeAction();
		} else if (e.getSource() == multiUser) {
			multiUserAction();
		}
		
	}
	
	// 返回用户名区域
	public JTextField getJtfUserAccount() {
		return Login.username;
	}
	
	// 返回密码输入区域
	public JPasswordField getPasswordField() {
		return Login.password;
	}
}

