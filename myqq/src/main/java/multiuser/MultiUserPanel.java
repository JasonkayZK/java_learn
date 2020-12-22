package multiuser;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import login.Login;
import qrlogin.QRcodePanel;
import utils.BackgroundUtils;

public class MultiUserPanel extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private Point point;

	private Login loginframe;
	private QRcodePanel QRPanel;
	
	private JButton login, close, min, addUser;
	private JButton QRButton, multiUserButton;

	private BackgroundUtils background;
	
	private Container container = this.getContentPane();
	
	private JLabel threadBackground, tip;
	
	
	
	public static void main(String[] args) {

	}

	public MultiUserPanel(Login loginframe) {
		this.loginframe = loginframe;
	}
	
	public MultiUserPanel(QRcodePanel QRPanel) {
		this.QRPanel = QRPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

	
	}

}
