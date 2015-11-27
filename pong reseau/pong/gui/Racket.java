package pong.gui;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Image;


public class Racket extends PongItem{
	
	public static final int RACKET_SPEED = 4; // Speed of racket (in pixels per second)
	//private int racket_speed;/** Speed of racket, in pixels per timestamp */

	//public int getSpeed(){
	//	return this.speed.y;
	//}
	public void setSpeed(int racket_speed){
		this.speed.y = racket_speed;
	}
	public Racket(Image img){
		super(img);
		position = new Point(0, 0);
		speed = new Point(0, 0);
	}
	
	public void setY(int y){
		this.position.y=y;
	}
	
	public void animate(int SIZE_PONG_Y){
		this.position.y += this.speed.y;
		if (this.position.y < 0)
			this.position.y = 0;
		if (this.position.y > SIZE_PONG_Y - this.height/2)
			this.position.y = SIZE_PONG_Y - this.height/2;
	}
	
}
