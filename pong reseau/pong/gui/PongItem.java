package pong.gui;


import java.awt.Graphics;
import java.awt.Point;
import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class PongItem {
	protected final Image img;
	protected Point speed;
	protected int width;
	protected int height;
	protected Point position;
	protected String name;
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public Point getPosition(){
		return (Point) position.clone();
	}
	
	public void setPositionX(int x){
		this.position.x=x;
	}
	
	public void setPositionY(int y){
		this.position.y=y;
	}
	
	public Point getSpeed(){
		return (Point) speed.clone();
	}
	
	public void setSpeedX(int x){
		this.speed.x=x;
	}
	
	public void setSpeedY(int y){
		this.speed.y=y;
	}

	
	public String toString(){
		String s = name + ".position.x." + position.x + "\n";
		s += name + ".position.y." + position.y + "\n";
		s += name + ".speed.x." + speed.x + "\n";
		s += name + ".speed.y." + speed.y + "\n";
		return s;
	}
	
	public PongItem(Image img){
		ImageIcon icon;
		this.img = img;
		icon = new ImageIcon(img);
		this.width=icon.getIconWidth();
		this.height=icon.getIconHeight();
	}
	
	public void draw(Graphics graphicContext){
		graphicContext.drawImage(this.img, position.x, position.y, width, height, null);
	}
}
