package pong;

import pong.gui.Window;
import pong.gui.Pong;

/**
 * Starting point of the Pong application
 */
public class Main  {
	public static void main(String[] args) {
		String t[] = "myballs.right=big".split("\\.|=");
		for(int i=0;i<t.length;i++){
			System.out.println(t[i]);
		}
		//Pong pong = new Pong();
		//Window window = new Window(pong);
		//window.displayOnscreen();
	}
}
