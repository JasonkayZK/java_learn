package utils;

import java.awt.Font;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class HoverPressUtils {

	public static JButton getTextButton(String s) {
		JButton button = new JButton(s);
		button.setFont(new Font("楷体", Font.BOLD, 12));
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		
		return button;
	}
	
	public static JButton getIconButton(String iconpath) {
		JButton button=new JButton();
		button.setIcon(new ImageIcon(iconpath));
		button.setBorder(null);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		
		return button;
	}
	
	public static JButton getbtnButton(String iconpath, String rolloverIconpath, String pressIconpath) {
		JButton button = new JButton();
		button.setIcon(new ImageIcon(iconpath));
		button.setRolloverIcon(new ImageIcon(rolloverIconpath));
		button.setPressedIcon(new ImageIcon(pressIconpath));
		button.setBorder(null);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		
		return button;
	}
	
	public static JButton getIconpressButton(String iconpath1, String iconpath2, String iconpath3) {
		JButton button=new JButton();
		button.setIcon(new ImageIcon(iconpath1));
		button.setPressedIcon(new ImageIcon(iconpath2));
	    button.setPressedIcon(new ImageIcon(iconpath3));
	    button.setBorder(null);
	    button.setFocusPainted(false);
	    button.setContentAreaFilled(false);
	  
	    return button;	
	}
	
	public static JButton getMinButton() {
		JButton button=new JButton();
		button.setIcon(new ImageIcon("image/min.png"));
		button.setPressedIcon(new ImageIcon("image/min_press.png"));
		button.setRolloverIcon(new ImageIcon("image/min_hover.png"));
		button.setToolTipText("最小化");
		button.setBorder(null);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		return button;
	}
	
	public static JButton getSettingButton() {
		JButton button=new JButton();
		button.setIcon(new ImageIcon("image" + File.separator + "setting.png"));
		button.setPressedIcon(new ImageIcon("image" + File.separator + "setting_press.png"));
		button.setRolloverIcon(new ImageIcon("image" + File.separator + "setting_hover.png"));
		button.setToolTipText("设置");
		button.setBorder(null);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		return button;
	}

	public static JButton getCloseButton() {
		JButton botton = new JButton();
		botton.setIcon(new ImageIcon("image" + File.separator + "close.png"));
		botton.setRolloverIcon(new ImageIcon("image" + File.separator + "close_hover.png"));
		botton.setPressedIcon(new ImageIcon("image" + File.separator + "close_press.png"));
		botton.setBorder(null);
		return botton;
	}
	
	public static JCheckBox getIconCheckBox(String iconpath, String pressIconpath, String rolloverIconpath, String selectedIconpath) {
		JCheckBox checkBox = new JCheckBox();
		checkBox.setIcon(new ImageIcon(iconpath));
		checkBox.setPressedIcon(new ImageIcon(pressIconpath));
		checkBox.setRolloverIcon(new ImageIcon(rolloverIconpath));
		checkBox.setSelectedIcon(new ImageIcon(selectedIconpath));
	
		checkBox.setBorder(null);
		checkBox.setFocusPainted(false);
		checkBox.setContentAreaFilled(false);
		
		return checkBox;
	}
	
}
