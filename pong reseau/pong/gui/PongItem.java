package pong.gui;


import java.awt.Graphics;
import java.awt.Point;
import java.awt.Image;

import javax.swing.ImageIcon;

public class PongItem {
	protected Image img;
	protected Point speed;
	protected int width;
	protected int height;
	protected Point position;
	
	public PongItem(Image img){
		ImageIcon icon;
		this.img = img; //sale?
		icon = new ImageIcon(img);
		this.width=icon.getIconWidth();
		this.height=icon.getIconHeight();
	}
	
	public void draw(Graphics graphicContext){
		graphicContext.drawImage(this.img, position.x, position.y, width, height, null);
	}

}
