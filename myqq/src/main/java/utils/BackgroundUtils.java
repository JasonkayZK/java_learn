package utils;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class BackgroundUtils extends JPanel {

	private static final long serialVersionUID = 1L;
	// 背景图片
	private Image bgImage;
	
	public BackgroundUtils() {
		setOpaque(false);
		setLayout(null);
	}
	
	// 设置背景图片
	public void setImage(Image bgImage) {
		this.bgImage = bgImage;
	}
	
	@Override
	protected void paintComponent(Graphics g) { // 重写绘制组件外观
		if (bgImage != null) {
			g.drawImage(bgImage, 0, 0, this); // 绘制图片与组件大小相同
		}
		super.paintComponent(g); // 执行超类方法
	}
	
}
