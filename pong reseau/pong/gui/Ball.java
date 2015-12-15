package pong.gui;

import java.awt.Image;
import java.awt.Point;


public class Ball extends PongItem{
	public static final int BALL_SPEED = 3; /** Speed of ball (in pixels per second) */
	protected boolean gameOver = false;
	
	
	//private static final long serialVersionUID = 1L;

	public Ball(Image img){
		super(img);
		position = new Point(100, 0);/** Position of ball *///changemeeee
		speed = new Point(BALL_SPEED, BALL_SPEED);/** Speed of ball, in pixels per timestep */
		name = "ball";
	}
	
	public boolean hit(Racket racket){
		if(position.x < racket.getPosition().x + racket.getWidth() && position.x + width > racket.getPosition().x)
			if(position.y < racket.getPosition().y + racket.getHeight() && position.y + height > racket.getPosition().y)
				return true;
		return false; 
	}
	
	public void setY(int y){
		this.position.y=y;
	}
	
	public void setX(int x){
		this.position.x=x;
	}
	
	public void animate(int SIZE_PONG_X,int SIZE_PONG_Y, Racket racket){
		this.position.translate(this.speed.x, this.speed.y);
		if (hit(racket))
			this.speed.x = -this.speed.x;
		if (this.position.x < 0){
			//this.position.x = 0;
			//this.speed.x = -this.speed.x;
			//this.speed.x=0;
			//this.speed.y=0;
			this.gameOver=true;
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
	


}
