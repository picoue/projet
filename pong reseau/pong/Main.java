package pong;

import java.io.IOException;

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
		else if(args.length == 1)
			conn = new Connection(args[0], 6667);
		else
			return;
		
		Pong pong = new Pong(conn);
		Window window = new Window(pong);
		try {
			window.displayOnscreen();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
