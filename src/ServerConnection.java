import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

// This file To make client get info from server without being blocked by keyboard input

public class ServerConnection implements Runnable {
	
	private Socket server;
	private BufferedReader in;
	
	//Constructor
	public ServerConnection(Socket s) throws IOException {
		server = s;
		in = new BufferedReader(new InputStreamReader(server.getInputStream()));
	}

	
	public void run() {
			try {
				
				String serverResponse=null;
				while(true) {
					
					serverResponse = in.readLine();
					
					if (serverResponse == null) break;
					
					System.out.println("Server sends: " + serverResponse);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				
			} finally {
				try {
					in.close();
					server.close();
				} catch (IOException e) {
					System.err.println("IO exception in Server Connection");
					
				}
			}
			
		}
		
	}

