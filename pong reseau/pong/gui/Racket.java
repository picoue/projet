package pong.gui;

import java.awt.Toolkit;
import java.awt.Image;


public class Racket extends PongItem{
	
	public static final int RACKET_SPEED = 4; // Speed of racket (in pixels per second)
	private int racket_speed;/** Speed of racket, in pixels per timestamp */
	
	public void setRacketSpeed(int racket_speed){
		this.racket_speed = racket_speed;
	}
	public Racket(Image i){
		super(i);
	}
	
	public void animate(int SIZE_PONG_Y){
		this.position.y += racket_speed;
		if (this.position.y < 0)
			this.position.y = 0;
		if (this.position.y > SIZE_PONG_Y - this.height/2)
			this.position.y = SIZE_PONG_Y - this.height/2;

	}
	
}
