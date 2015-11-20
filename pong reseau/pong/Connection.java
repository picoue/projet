package pong;

import java.net.*;
import java.io.*;

public class Connection{
	
  public Connection(int port){
    try {
      ServerSocket socketServeur = new ServerSocket(port);
      System.out.println("Lancement du serveur");

      while (true) {
        Socket socketClient = socketServeur.accept();
        

        // InputStream in = socketClient.getInputStream();
        // OutputStream out = socketClient.getOutputStream();

        BufferedReader in = new BufferedReader(
          new InputStreamReader(socketClient.getInputStream()));
        PrintStream out = new PrintStream(socketClient.getOutputStream());
        socketClient.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }



  public Connection(int port, String nomMachine){
	Socket socket;
	DataInputStream userInput;
	PrintStream theOutputStream;
	try {
		InetAddress serveur = InetAddress.getByName(nomMachine);
		socket = new Socket(serveur, port);

		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream out = new PrintStream(socket.getOutputStream());

	} catch (Exception e) {
	    e.printStackTrace();
	}
	    
  }	
}	