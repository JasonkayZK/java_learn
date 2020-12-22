package chat_v0_2;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;

public class ChatClient extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TextField tfTxt = new TextField();
	
	TextArea taContent = new TextArea();
	
	public static void main(String[] args) {
		new ChatClient().launchFrame();
		
	}
	
	public void launchFrame() {
		setLocation(400, 300);
		this.setSize(300, 300);
		add(tfTxt, BorderLayout.SOUTH);
		add(taContent, BorderLayout.NORTH);
		pack();
		setVisible(true);
	}

}
