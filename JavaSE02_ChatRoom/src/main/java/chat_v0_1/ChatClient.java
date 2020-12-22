package chat_v0_1;

import java.awt.Frame;

public class ChatClient extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new ChatClient().launchFrame();
	}

	public void launchFrame() {
		setLocation(400, 300);
		this.setSize(300, 300);
		setVisible(true);
	}
	
}
