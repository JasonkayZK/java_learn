package chat_v0_5;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatClient extends Frame {
	private static final long serialVersionUID = 1L;

	private TextArea taContent = new TextArea();
	
	private TextField tfTxt = new TextField();
	
	public static void main(String[] args) {
		new ChatClient().launchFrame();
	}
	
	public void launchFrame() {
		this.setLocation(400, 300);
		this.setSize(300, 300);
		this.add(taContent, BorderLayout.NORTH);
		this.add(tfTxt, BorderLayout.SOUTH);
		pack();
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		tfTxt.addActionListener(new TFListener());
		
		this.setVisible(true);
		
	}
	
	private class TFListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String s = tfTxt.getText().trim();
			taContent.setText(s);
			tfTxt.setText("");
		}
		
	}
}
