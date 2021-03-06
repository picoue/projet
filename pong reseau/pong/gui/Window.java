package pong.gui;

import java.io.IOException;
import javax.swing.JFrame;

/** A Window is a Java frame containing a Pong */
public class Window extends JFrame {

	private static final long serialVersionUID = 1L;

	/** Pong component to be displayed */
	private final Pong pong;

	public Window(Pong pong) {
		this.pong = pong;
		this.addKeyListener(pong);
	}

	/** Displays the Window using the defined margins, and call the {@link Pong#animate()} method of the {@link Pong} every 100ms 
	 * @throws IOException 
	 * @throws NumberFormatException */
	public void displayOnscreen() throws NumberFormatException, IOException {
		add(pong);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		while(true) {
			pong.animate();
			if(this.pong.getBall().gameOver != 0)
				break;
			try {
				Thread.sleep(Pong.timestep);
			} catch (InterruptedException e) {};
		}
	}
}
