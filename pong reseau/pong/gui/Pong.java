package pong.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.JPanel;

import pong.Connection;

/** A Pong is a Java graphical container that extends the JPanel class in order to display graphical elements. */

public class Pong extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	/** Constant (c.f. final) common to all Pong instances (c.f. static) defining the background color of the Pong */
	private static final Color backgroundColor = new Color(0x00,0x00,0x00);	
	private static final int SIZE_PONG_X = 800;// Width of pong area
	private static final int SIZE_PONG_Y = 600;/** Height of pong area */
	public static final int timestep = 10; // Time step of the simulation (in ms)
	private Image buffer = null; /** Pixel data buffer for the Pong rendering */
	private Graphics graphicContext = null;/** Graphic component context derived from buffer Image */
	protected Ball ball;
	private Racket racket;/** One Racket to be displayed */
	private Racket racket2;
	private MessageItem winner;
	private MessageItem looser;
	protected Connection conn;	

	public Pong() {
		this.ball = new Ball(Toolkit.getDefaultToolkit().createImage(
				ClassLoader.getSystemResource("image/ball.png")));
		this.racket = new Racket(Toolkit.getDefaultToolkit().createImage(
				ClassLoader.getSystemResource("image/racket.png")));
		this.racket2 = new Racket(Toolkit.getDefaultToolkit().createImage(
				ClassLoader.getSystemResource("image/racket.png")), SIZE_PONG_X - racket.getWidth(), 0);
		this.winner = new MessageItem(Toolkit.getDefaultToolkit().createImage(
				ClassLoader.getSystemResource("image/bulle_winner.png")));
		this.looser = new MessageItem(Toolkit.getDefaultToolkit().createImage(
				ClassLoader.getSystemResource("image/bulle_looser.png")));
		
		this.setPreferredSize(new Dimension(SIZE_PONG_X, SIZE_PONG_Y));
		this.addKeyListener(this);
	}
	
	public Pong(Connection conn){
		this();
		this.conn = conn;
		if(conn.getPlayerID() == 1){
			ball.setPositionX(SIZE_PONG_X - 100 - ball.getWidth());
			ball.setSpeedX(- ball.getSpeed().x);
		}
	}
	
	public Ball getBall(){
		return this.ball;
	}

	/** Proceeds to the movement of the ball and updates the screen 
	 * @throws IOException 
	 * @throws NumberFormatException */
	public void animate() throws NumberFormatException, IOException {
		conn.receive(ball, racket2, SIZE_PONG_X);
		ball.animate(SIZE_PONG_X, SIZE_PONG_Y, racket);
		racket.animate(SIZE_PONG_Y);
		if (conn != null){
			conn.send(racket);
			//if ((ball.getPosition().getX() < SIZE_PONG_X / 2) ^ (racket.getPosition().getX() > SIZE_PONG_X / 2))
			if(ball.getPosition().getX() < 90)
				conn.send(ball);
			if(ball.gameOver == 1)
				conn.send(Connection.looserMessage);
		}
		updateScreen();
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
			case KeyEvent.VK_KP_UP:
				racket.setSpeedY(-Racket.RACKET_SPEED);
				break;
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_KP_DOWN:
				racket.setSpeedY(Racket.RACKET_SPEED);
				break;
			default:
				System.out.println("got press "+e);
		}
	}
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
			case KeyEvent.VK_KP_UP:
				racket.setSpeedY(0);
				break;
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_KP_DOWN:
				racket.setSpeedY(0);
				break;
			default:
				System.out.println("got release "+e);
		}
	}
	public void keyTyped(KeyEvent e) { }

	/*
	 * (non-Javadoc) This method is called by the AWT Engine to paint what
	 * appears in the screen. The AWT engine calls the paint method every time
	 * the operative system reports that the canvas has to be painted. When the
	 * window is created for the first time paint is called. The paint method is
	 * also called if we minimize and after we maximize the window and if we
	 * change the size of the window with the mouse.
	 * 
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		g.drawImage(buffer, 0, 0, this);
	}

	/**
	 * Draw each Pong item based on new positions
	 */
	public void updateScreen() {
		if (buffer == null) { //First time we get called with all windows initialized
			buffer = createImage(SIZE_PONG_X, SIZE_PONG_Y);
			if (buffer == null)
				throw new RuntimeException("Could not instanciate graphics");
			else
				graphicContext = buffer.getGraphics();
		}
		/* Fill the area with black */
		graphicContext.setColor(backgroundColor);
		graphicContext.fillRect(0, 0, SIZE_PONG_X, SIZE_PONG_Y);

		/* Draw items */
		ball.draw(graphicContext);
		racket.draw(graphicContext);
		racket2.draw(graphicContext);
		if(ball.gameOver == 1)
			looser.draw(graphicContext);
		if(ball.gameOver == 2)
			winner.draw(graphicContext);
		
		this.repaint();
	}
}
