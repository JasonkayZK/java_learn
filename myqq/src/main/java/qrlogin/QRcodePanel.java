package qrlogin;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import login.Login;
import utils.BackgroundUtils;

public class QRcodePanel extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private Login loginPanel;
	
	private JButton close, min;
	private JButton QRcode;
	
	private JLabel QRcodeBackground1, QRcodeBackground2;
	
	private Point point;

	private BackgroundUtils background;
	
	private boolean flag;
	
	private Container container = this.getContentPane();
	
	private int screenWidth, screenHeight;
	
	public static void main(String[] args) {
		
	}
	
	public QRcodePanel(Login loginPanel) {
		this.loginPanel = loginPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
