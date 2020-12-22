package club.jasonkayzk666.client;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ChatClient extends Frame {
	
	private static final long serialVersionUID = 1L;
	private Socket s;
	private DataOutputStream dos;
	private DataInputStream dis;
	private boolean bConnected;
	
	private TextArea taContent;
	private TextField tfTxt;
	private Thread tRevc;
	
	public static void main(String[] args) {
		new ChatClient().launchFrame();
	}

	public ChatClient() {
		this.s = null;
		this.dos = null;
		this.dis = null;
		this.bConnected = false;
		
		this.taContent = new TextArea();
		this.tfTxt = new TextField();
		this.tRevc = new Thread(new RecvThread());
		
	}
	
	public void launchFrame() {
		this.setLocation(400, 300);
		this.setSize(300, 300);
		
	}
	
	public void connect() {
		
	}
	
	public void disconnect() {
		
	}
	
	private class TFListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

		}
		
	}

	private class RecvThread implements Runnable {

		@Override
		public void run() {
			
		}	
			
	}
	
}

