package pong.gui;

import java.awt.Image;
import java.awt.Point;


public class Ball extends PongItem{
	public static final int BALL_SPEED = 2; /** Speed of ball (in pixels per second) */
	
	
	//private static final long serialVersionUID = 1L;

	public Ball(Image img){
		super(img);
		position = new Point(0, 0);/** Position of ball */
		speed = new Point(BALL_SPEED, BALL_SPEED);/** Speed of ball, in pixels per timestep */
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
