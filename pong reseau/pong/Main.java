package pong;

import pong.gui.Window;
import pong.gui.Pong;

/**
 * Starting point of the Pong application
 */
public class Main  {
	public static void main(String[] args) {
		Connection conn;
		if(args.length == 0)
			conn = new Connection(6667);
		if(args.length == 1)
			conn = new Connection(args[0], 6667);
		
		Pong pong = new Pong();
		Window window = new Window(pong);
		window.displayOnscreen();
	}
}
