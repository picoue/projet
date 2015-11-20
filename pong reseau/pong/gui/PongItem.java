package pong.gui;


import java.awt.Graphics;
import java.awt.Point;
import java.awt.Image;

import javax.swing.ImageIcon;

public class PongItem {
	protected final Image img;//final?
	protected Point speed;
	protected int width;
	protected int height;
	protected Point position;
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public Point getPosition(){
		return (Point) position.clone();
	}
	
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
