package pong.gui;

import java.awt.Image;
import java.awt.Point;


public class MessageItem extends PongItem{
	public MessageItem(Image img){
		super(img);
		position = new Point(300, 200);
		speed = new Point(0, 0);
		name = "message";
	}
}
