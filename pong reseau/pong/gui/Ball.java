package pong.gui;

import java.awt.Image;


public class Ball extends PongItem{
	public static final int BALL_SPEED = 2; /** Speed of ball (in pixels per second) */
	
	public Ball(Image i){
		super(i);
	}
	
	public void animate(int SIZE_PONG_X,int SIZE_PONG_Y){
		this.position.translate(this.speed.x, this.speed.y);
		if (this.position.x < 0){
			this.position.x = 0;
			this.speed.x = -this.speed.x;
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
