package registor;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import exceptions.RegistorException;
import jdbc.DBUtils;
import jdbc.Transaction;
import login.Login;
import utils.BackgroundUtils;
import utils.HoverPressUtils;

public class RegistorPanel extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private Login login;
	private JButton minButton, closeButton, confirmButton, cancelButton, testButton;
	
	private JLabel usernameLabel, passwordLabel, nicknameLabel;
	private JTextField usernameTextField, passwordTextField, nicknameTextField;

	private Point point;
	
	private Font font;
	
	private Container container;
	
	public static void main(String[] args) {
		Login test = new Login();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new RegistorPanel(test).launchFrame();
	}
	
	public RegistorPanel(Login login) {
		this.login = login;
		
		this.passwordTextField = new JTextField();
		this.usernameTextField = new JTextField();
		this.nicknameTextField = new JTextField();
		
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

	public void initNicknameFrame() {
		this.nicknameLabel = new JLabel("昵称");
		nicknameLabel.setFont(font);
		nicknameLabel.setForeground(Color.BLACK);
		nicknameLabel.setBounds(120, 100, 50, 21);
		container.add(nicknameLabel);
		
		this.nicknameTextField = new JTextField();
		nicknameTextField.setBorder(new LineBorder(Color.GRAY));
		nicknameTextField.setFont(font);
		nicknameTextField.setForeground(Color.BLACK);
		nicknameTextField.setBounds(160, 100, 150, 22);
		container.add(nicknameTextField);
	}
	
	public void initUsernameFrame() {
		this.usernameLabel = new JLabel("用户名");
		usernameLabel.setFont(font);
		usernameLabel.setForeground(Color.BLACK);
		usernameLabel.setBounds(110, 160, 50, 21);
		container.add(usernameLabel);
		
		this.usernameTextField = new JTextField();
		usernameTextField.setBorder(new LineBorder(Color.GRAY));
		usernameTextField.setFont(font);
		usernameTextField.setForeground(Color.BLACK);
		usernameTextField.setBounds(160, 160, 150, 22);
		container.add(usernameTextField);
	}
	
	public void initPasswordFrame() {
		this.passwordLabel = new JLabel("密码");
		passwordLabel.setFont(font);
		passwordLabel.setForeground(Color.BLACK);
		passwordLabel.setBounds(120, 220, 50, 21);
		container.add(passwordLabel);
		
		this.passwordTextField = new JTextField();
		passwordTextField.setBorder(new LineBorder(Color.GRAY));
		passwordTextField.setFont(font);
		passwordTextField.setForeground(Color.BLACK);
		passwordTextField.setBounds(160, 220, 150, 22);
		container.add(passwordTextField);
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
		initNicknameFrame();
		initButtonFrame();
		initBackgroundFrame();
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelButton || e.getSource() == closeButton) {
			dispose();
			login.setLocation(RegistorPanel.this.getX(), RegistorPanel.this.getY());
		} else if (e.getSource() == confirmButton) {
			Connection conn = null;
			try {
				conn = DBUtils.getConnection();
				if (Transaction.registor(this.nicknameTextField.getText(), usernameTextField.getText(), passwordTextField.getText(), conn)) {
					JOptionPane.showMessageDialog(this, "注册成功！");
					dispose();
				} else {
					JOptionPane.showMessageDialog(this, "注册失败！");
				}
			} catch (RegistorException e1) {
				JOptionPane.showMessageDialog(this, "用户名已被使用！");
			} finally {
				if (conn != null) {
					DBUtils.close(conn);
				}
			}
					
			
		} else if (e.getSource() == testButton) {
			Connection conn = null;
			try {
				conn = DBUtils.getConnection();
				if (Transaction.registorTest(this.usernameTextField.getText(), conn)) {
					JOptionPane.showMessageDialog(this, "用户名可以使用！");
				} else {
					JOptionPane.showMessageDialog(this, "昵称或用户名已被注册");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				if (conn != null) {
					DBUtils.close(conn);
				}
			}
		}
	}

}
