package pong;

import java.net.*;
import java.io.*;

import pong.gui.*;

public class Connection{
	private BufferedReader in;
	private PrintStream out;
	
	public Connection(int port){
		try {
			ServerSocket socketServeur = new ServerSocket(port);// TODO : Close me after
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
  
  	public void receive(Ball ball, Racket racket){
  		try {
			while(in.ready()){
				String s = in.readLine();// TODO : tester que la ligne est bien complete
				String t[] = s.split("\\.|=");
				if(t[0].equals("ball")){
					if(t[1].equals("y"))
						ball.setY(Integer.parseInt(t[2]));
					else
						ball.setX(Integer.parseInt(t[2]));	
				}
				if(t[0].equals("racket")){
					racket.setY(Integer.parseInt(t[2]));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	}
  
  	public Connection(String nomMachine, int port){
  		Socket socket;

  		try {
  			InetAddress serveur = InetAddress.getByName(nomMachine);
  			socket = new Socket(serveur, port);

  			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
  			out = new PrintStream(socket.getOutputStream());

  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  	}
  
  	public void send(PongItem p){
  		out.print(p.toString());
  	}
}	