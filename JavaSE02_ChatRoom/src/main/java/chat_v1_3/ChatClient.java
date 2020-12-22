package chat_v1_3;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

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
		
		this.tfTxt = new TextField();
		this.taContent = new TextArea();
		
		this.tRevc = new Thread(new RecvThread());
	}
	
	public void launchFrame() {
		this.setLocation(400, 300);
		this.setSize(300, 300);
		this.add(tfTxt, BorderLayout.SOUTH);
		this.add(taContent, BorderLayout.NORTH);
		this.pack();
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				try {
					disconnect();
				} finally {
					System.out.println("Closing!");
					System.exit(0);
				}
			}
		});
		
		this.tfTxt.addActionListener(new TFListener());
		this.setVisible(true);
		connect();
		
		this.tRevc.start();
	}
	
	public void connect() {
		try {
			this.s = new Socket("127.0.0.1", 8888);
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			System.out.println("Connected");
			this.bConnected = true;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		try {
			bConnected = false;
//			tRevc.join();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null) dos.close();
				if (dis != null) dis.close();
				if (s != null) s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private class TFListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String str = tfTxt.getText().trim();
			tfTxt.setText("");
			
			try {
				dos.writeUTF(str);
				dos.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	public class RecvThread implements Runnable {
		
		@Override
		public void run() {
			try {
				while (bConnected) {
					String str = dis.readUTF();
					taContent.setText(taContent.getText() + str + '\n');
				}
			} catch (SocketException e) {
				System.out.println("bye!");
			} catch (EOFException e) {
				System.out.println("bye- bye!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
