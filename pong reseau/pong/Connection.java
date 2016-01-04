package pong;

import java.net.*;
import java.io.*;

import pong.gui.*;

public class Connection{
	protected BufferedReader in;
	protected PrintStream out;
	protected ServerSocket socketServeur;
	protected int playerID;
	
	public Connection(int port){
		try {
			playerID = 0;
			socketServeur = new ServerSocket(port);// TODO : Close me after
			socketServeur.setReuseAddress(true);
			System.out.println("Lancement du serveur");

			//while (true) {
				Socket socketClient = socketServeur.accept();
   
				// InputStream in = socketClient.getInputStream();
				// OutputStream out = socketClient.getOutputStream();
        
				in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
				out = new PrintStream(socketClient.getOutputStream());
				//socketClient.close();?
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
  	public Connection(String nomMachine, int port){
  		Socket socket;

  		playerID = 1;
  		try {
  			InetAddress serveur = InetAddress.getByName(nomMachine);
  			socket = new Socket(serveur, port);

  			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
  			out = new PrintStream(socket.getOutputStream());

  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  	}
  	
  	public int getPlayerID(){
  		return playerID;
  	}
  
  	public void receive(Ball ball, Racket racket, int SIZE_PONG_X) throws NumberFormatException, IOException{
		while(in.ready()){
			String s = in.readLine();//TODO : tester que la ligne est bien complete
			//System.out.println(s);
			String t[] = s.split("\\.|=");
			if(t[0].equals("ball")){
				if(t[1].equals("position")){
					if(t[2].equals("y"))
						ball.setPositionY(Integer.parseInt(t[3]));
					else
						ball.setPositionX(SIZE_PONG_X - Integer.parseInt(t[3]) - ball.getWidth());	
				}
				else if(t[1].equals("speed")){
					if(t[2].equals("y"))
						ball.setSpeedY(Integer.parseInt(t[3]));
					else
						ball.setSpeedX(- Integer.parseInt(t[3]));
				}
			}
			if(t[0].equals("racket")){
				if(t[1].equals("speed")){
					if(t[2].equals("y"))
						racket.setSpeed(Integer.parseInt(t[3]));
				}
				else if(t[1].equals("position")){
					if(t[2].equals("x"))
						racket.setPositionX(SIZE_PONG_X - Integer.parseInt(t[3]) - racket.getWidth());
					if(t[2].equals("y"))
						racket.setPositionY(Integer.parseInt(t[3]));
				}
			}
		}
  	}
  
  	public void send(PongItem p){
  		out.print(p.toString());
  	}
  	
  	public void close(){
  		if (socketServeur != null) {
            try {
                socketServeur.close();
            } catch (IOException e) {
                // TODO : log errors?
            }
        }
  	}
}	