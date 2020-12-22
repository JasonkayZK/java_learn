package chat_v1_1;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient extends Frame {

	private static final long serialVersionUID = 1L;
	private Socket s;
	private DataOutputStream dos;
	
	private TextArea taConnect;
	private TextField tfTxt;
	
	public static void main(String[] args) {
		new ChatClient().launchFrame();
	}

	public ChatClient() {
		this.s = null;
		this.dos = null;
		
		this.taConnect  = new TextArea();
		this.tfTxt = new TextField();
	}
	
	public void launchFrame () {
		this.setLocation(400, 300);
		this.setSize(300, 300);
		this.add(tfTxt, BorderLayout.SOUTH);
		this.add(taConnect, BorderLayout.NORTH);
		this.pack();
	
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					disconnect();
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					System.exit(0);	
				}
			}
		});
		this.tfTxt.addActionListener(new TFListener());
		this.setVisible(true);
		connect();
	}
	
	public void connect () {
		try {
			this.s = new Socket("127.0.0.1", 8888);
			this.dos = new DataOutputStream(s.getOutputStream());
			System.out.println("Connected!");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void disconnect() {
		try {
			if (dos != null) dos.close();
			if (s != null) s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private class TFListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String str = tfTxt.getText().trim();
			taConnect.setText(str);
			tfTxt.setText("");
			
			try {
				dos.writeUTF(str);
				dos.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
}

