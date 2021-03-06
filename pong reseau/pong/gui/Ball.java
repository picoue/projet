package pong.gui;

import java.awt.Image;
import java.awt.Point;


public class Ball extends PongItem{
	public static final int BALL_SPEED = 3; /** Speed of ball (in pixels per second) */
	protected int gameOver = 0;

	public Ball(Image img){
		super(img);
		position = new Point(100, 0);/** Position of ball */
		speed = new Point(BALL_SPEED, BALL_SPEED);/** Speed of ball, in pixels per timestep */
		name = "ball";
	}
	
	public boolean hit(Racket racket){
		if(position.x < racket.getPosition().x + racket.getWidth() && position.x + width > racket.getPosition().x)
			if(position.y < racket.getPosition().y + racket.getHeight() && position.y + height > racket.getPosition().y)
				return true;
		return false; 
	}
	
	public void animate(int SIZE_PONG_X,int SIZE_PONG_Y, Racket racket){
		this.position.translate(this.speed.x, this.speed.y);
		if (hit(racket)){
			this.speed.x = -this.speed.x;
			this.position.x = racket.getWidth();
		}
		if (this.position.x < 0){
			this.gameOver = 1;
		}
		
		if (this.position.y < 0){
			this.position.y = 0;
			this.speed.y = -this.speed.y;
		}
		if (this.position.x > SIZE_PONG_X - this.width){
			this.position.x = SIZE_PONG_X - this.width;
			this.speed.x = -this.speed.x;
		}
		if (this.position.y > SIZE_PONG_Y - this.height){
			this.position.y = SIZE_PONG_Y - this.height;
			this.speed.y = -this.speed.y;
		}
	}
	
	public void setGameOver(int i){
		gameOver = i;
	}
}
