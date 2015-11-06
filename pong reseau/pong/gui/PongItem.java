package pong.gui;

import java.awt.Point;
import java.awt.Image;
import javax.swing.ImageIcon;

public class PongItem {
	protected Image img;
	protected Point speed;
	protected int width;
	protected int height;
	protected Point position;
	
	public PongItem(Image i){
		ImageIcon icon;
		img=i; //sale?
		icon=new ImageIcon(i);
		this.width=icon.getIconWidth();
		this.height=icon.getIconHeight();
		
	}

}
