package login;

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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import utils.BackgroundUtils;
import utils.HoverPressUtils;

public class LoginSetting extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private static String SERVERADDRESS;
	private static String SERVERPORT;
	
	private JButton minButton, closeButton, confirmButton, cancelButton, testButton;
	private JLabel netTypeLabel, netSetLabel;
	
	private JComboBox<String> netTypeCombox;
	
	private JTextField netAddressTextField;
	private JLabel netAddressLabel;
	private JTextField netPortTextField;
	private JLabel netPortLabel;
	
	private JLabel usernameLabel;
	private JTextField usernameTextField;
	private JLabel passwordLabel;
	private JTextField passwordTextField;
	
	private JLabel fieldLabel;
	private JTextField jtField;
	
	private JLabel loginServerLabel, serverTypeLabel, serverAddressLabel;
	private JComboBox<String> serverTypeCombox;
	
	private JTextField serverAddressTextField;
	private JLabel serverPortLabel;
	
	private JTextField serverPortTextField;
	
	private Login login;
	private Point point;
	
	private Font font;
	
	private Container container;
	
	static {
		SERVERADDRESS = "127.0.0.1";
		SERVERPORT = "8088";
	}
	
	public static void main(String[] args) {
		new LoginSetting(new Login()).launchFrame();
	}

	public LoginSetting(Login login) {
		this.login = login;
		
		this.serverAddressTextField = new JTextField(LoginSetting.SERVERADDRESS);
		this.serverPortTextField = new JTextField(LoginSetting.SERVERPORT);
		
		this.font = new Font("楷书", Font.PLAIN, 13);
		
		this.container = this.getContentPane();
	}

	public void initWindow() {
		this.setSize(437, 340);
		this.setIconImage(this.getToolkit().getImage(this.getClass().getResource("title.png")));
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);
		
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		this.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mousePressed(MouseEvent e) {
				point = e.getPoint();
			}
		});
		
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point newPoint = e.getLocationOnScreen();
				setLocation(newPoint.x - point.x, newPoint.y - point.y);
			}
		});
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void initUsernameFrame() {
		this.usernameLabel = new JLabel("用户名");
		usernameLabel.setFont(font);
		usernameLabel.setForeground(Color.BLACK);
		usernameLabel.setBounds(14, 140, 50, 21);
		container.add(usernameLabel);
		
		this.usernameTextField = new JTextField();
		usernameTextField.setBorder(new LineBorder(Color.GRAY));
		usernameTextField.setFont(font);
		usernameTextField.setForeground(Color.BLACK);
		usernameTextField.setBounds(60, 140, 110, 22);
		container.add(usernameTextField);
	}
	
	public void initPasswordFrame() {
		this.passwordLabel = new JLabel("密码");
		passwordLabel.setFont(font);
		passwordLabel.setForeground(Color.BLACK);
		passwordLabel.setBounds(182, 140, 50, 20);
		container.add(passwordLabel);
		
		this.passwordTextField = new JTextField();
		passwordTextField.setBorder(new LineBorder(Color.GRAY));
		passwordTextField.setFont(font);
		passwordTextField.setForeground(Color.BLACK);
		passwordTextField.setBounds(215, 140, 80, 22);
		container.add(passwordTextField);
	}
	
	public void initFieldFrame() {
		this.fieldLabel = new JLabel("域");
		fieldLabel.setFont(font);
		fieldLabel.setForeground(Color.BLACK);
		fieldLabel.setBounds(322, 140, 50, 20);
		container.add(fieldLabel);
		
		this.jtField = new JTextField();
		jtField.setBorder(new LineBorder(Color.GRAY));
		jtField.setFont(font);
		jtField.setForeground(Color.BLACK);
		jtField.setBounds(350, 140, 60, 22);
		container.add(jtField);
	}
	
	public void initNetFrame() {
		this.netSetLabel = new JLabel("网络设置");
		netSetLabel.setFont(font);
		netSetLabel.setForeground(Color.BLACK);
		netSetLabel.setBounds(14, 60, 60, 20);
		container.add(netSetLabel);
		
		this.netTypeLabel = new JLabel("网络类型");
		netTypeLabel.setFont(font);
		netTypeLabel.setForeground(Color.BLACK);
		netTypeLabel.setBounds(24, 110, 50, 20);
		container.add(netTypeLabel);
		
		this.netAddressLabel = new JLabel("网络地址");
		netAddressLabel.setFont(font);
		netAddressLabel.setForeground(Color.BLACK);
		netAddressLabel.setBounds(182,110, 50, 20);
		container.add(netAddressLabel);
		
		this.netPortLabel = new JLabel("网络");
		netPortLabel.setFont(font);
		netPortLabel.setForeground(Color.BLACK);
		netPortLabel.setBounds(315, 110, 50, 20);
		container.add(netPortLabel);
		
		this.netTypeCombox = new JComboBox<String> (new String[] {
				"不使用代理", "HTTP代理", "SOCKSS代理", "使用浏览器代理"
			});
		netTypeCombox.setFont(font);
		netTypeCombox.setForeground(Color.BLACK);
		netTypeCombox.setBounds(60,110, 110, 21);
		container.add(netTypeCombox);
		
		this.netAddressTextField = new JTextField();
		netAddressTextField.setBorder(new LineBorder(Color.GRAY));
		netAddressTextField.setFont(font);
		netAddressTextField.setForeground(Color.BLACK);
		netAddressTextField.setBounds(215, 110, 80, 22);
		netAddressTextField.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (netAddressTextField.getText() != null) {
					testButton.setEnabled(true);
				}
			}
		});
		container.add(netAddressTextField);
		
		this.netPortTextField = new JTextField();
		netPortTextField.setBorder(new LineBorder(Color.GRAY));
		netPortTextField.setFont(font);
		netPortTextField.setForeground(Color.BLACK);
		netPortTextField.setBounds(350, 110, 60, 22);
		container.add(netPortTextField);
		
	}
	
	public void initServerFrame() {
		this.loginServerLabel = new JLabel("登录服务器");
		loginServerLabel.setFont(font);
		loginServerLabel.setForeground(Color.BLACK);
		loginServerLabel.setBounds(15, 200, 85, 22);
		container.add(loginServerLabel);
		
		this.serverTypeLabel = new JLabel("服务器类型");
		serverTypeLabel.setFont(font);
		serverTypeLabel.setForeground(Color.BLACK);
		serverTypeLabel.setBounds(14, 245, 50, 20);
		container.add(serverTypeLabel);
		
		this.serverAddressLabel = new JLabel("服务器地址");
		serverAddressLabel.setFont(font);
		serverAddressLabel.setForeground(Color.BLACK);
		serverAddressLabel.setBounds(182, 245, 50, 20);
		container.add(serverAddressLabel);
		
		this.serverAddressTextField.setBorder(new LineBorder(Color.GRAY));
		serverAddressTextField.setFont(font);
		serverAddressTextField.setForeground(Color.BLACK);
		serverAddressTextField.setBounds(215, 245, 80, 22);
		container.add(serverAddressTextField);
		
		this.serverPortLabel = new JLabel("端口");
		serverPortLabel.setFont(font);
		serverPortLabel.setForeground(Color.BLACK);
		serverPortLabel.setBounds(315, 245, 60, 20);
		container.add(serverPortLabel);
		
		this.serverPortTextField.setBorder(new LineBorder(Color.GRAY));
		serverPortTextField.setFont(font);
		serverPortTextField.setForeground(Color.BLACK);
		serverPortTextField.setBounds(350, 245, 55, 22);
		container.add(serverPortTextField);
		
		this.serverTypeCombox = new JComboBox<String> (new String[] { "TCP类型" , "UDP类型", "不使用高级选项"});
		serverTypeCombox.setFont(font);
		serverTypeCombox.setForeground(Color.BLACK);
		serverTypeCombox.setBounds(60, 245, 110, 21);
		container.add(serverTypeCombox);
	}
	
	public void initButtonFrame() {
		this.closeButton = HoverPressUtils.getCloseButton();
		closeButton.setBounds(395, 3, 39, 20);
		closeButton.addActionListener(this);
		container.add(closeButton);
		
		this.minButton = HoverPressUtils.getMinButton();
		minButton.setBounds(368, 2, 28, 20);
		minButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		container.add(minButton);
		
		this.cancelButton = new JButton("取消");
		cancelButton.setForeground(Color.BLACK);
		cancelButton.setContentAreaFilled(false);
		cancelButton.setFont(font);
		cancelButton.addActionListener(this);
		cancelButton.setBounds(330, 308, 85, 25);
		container.add(cancelButton);
		
		this.confirmButton = new JButton("确定");
		confirmButton.setForeground(Color.BLACK);
		confirmButton.setContentAreaFilled(false);
		confirmButton.setFont(font);
		confirmButton.addActionListener(this);
		confirmButton.setBounds(245, 308, 85, 25);
		container.add(confirmButton);
		
		// 待完善.............
		this.testButton = new JButton("测试");
		testButton.setForeground(Color.BLACK);
		testButton.setContentAreaFilled(false);
		testButton.setFont(font);
		testButton.addActionListener(this);
		testButton.setBounds(350, 170, 60, 25);
		container.add(testButton);
	}
	
	public void initBackgroundFrame() {
		BackgroundUtils bg = new BackgroundUtils();
		bg.setImage(this.getToolkit().getImage(this.getClass().getResource("settingbg.png")));
		bg.setBounds(0,0,437,340);
		container.add(bg);
	}
	
	public void launchFrame() {
		initWindow();
		initUsernameFrame();
		initPasswordFrame();
		initFieldFrame();
		initNetFrame();
		initServerFrame();
		initButtonFrame();
		initBackgroundFrame();
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelButton || e.getSource() == closeButton) {
			dispose();
			login.setLocation(LoginSetting.this.getX(), LoginSetting.this.getY());
			login.setVisible(true);
		} else if (e.getSource() == confirmButton) {
			dispose();
			login.setLocation(LoginSetting.this.getX(), LoginSetting.this.getY());
			login.setVisible(true);
			LoginSetting.SERVERADDRESS = serverAddressTextField.getText();
			LoginSetting.SERVERPORT = serverPortTextField.getText();
		}
	}

}
