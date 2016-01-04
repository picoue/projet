package pong.gui;

import java.awt.Point;
import java.awt.Image;


public class Racket extends PongItem{
	public static final int RACKET_SPEED = 4; // Speed of racket (in pixels per timestamp)
	
	public Racket(Image img, int x, int y){
		super(img);
		position = new Point(x, y);
		speed = new Point(0, 0);
		name = "racket";
	}
	
	public Racket(Image img){
		this(img, 0, 0);
	}
	
	public void animate(int SIZE_PONG_Y){
		this.position.y += this.speed.y;
		if (this.position.y < 0)
			this.position.y = 0;
		if (this.position.y > SIZE_PONG_Y - this.height)
			this.position.y = SIZE_PONG_Y - this.height;
	}
	
}
