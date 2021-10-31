import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

//Client Handler to allow MultiClients
public class ClientHandler implements Runnable {
	
	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	private ArrayList<ClientHandler> clients;
	
	//Constructor of client Handler
	public ClientHandler(Socket clientSocket, ArrayList <ClientHandler> clients) throws IOException {
		this.client =clientSocket;
		this.clients =clients;
		in  = new BufferedReader (new InputStreamReader(client.getInputStream()));
		out = new PrintWriter(client.getOutputStream(),true);
	
	}
	
	//@Override
	public void run() {
			
		try {
			while (true) {
				String request = in.readLine();
				
				if(request.contains("connect")) {
					out.println("connected, Need Help?");
					
				}else if(request.startsWith("get me")){
					int firstSpace = request.indexOf(" ");
					if(firstSpace != -1) {
					out.println(request.substring(firstSpace + 3) + " recommendations");
					}
				else if(request.contains("say")) {
					int secondSpace = request.indexOf(" ");
					if(secondSpace != -1) {
					outToAll(request.substring(firstSpace + 1));
					}
				}
					
					
				} else {
					out.println(" Type 'get me <something>' to get it | type 'close' to clode connection ");
				}
		    }
			
		} catch (IOException e) {
			System.err.println("IO exception in Client Handler");
			//e.printStackTrace();
			
		} finally {
			out.close();
			
			try {
				in.close();
				client.close();
				
			}catch (IOException e) {
				//e.printStackTrace();
			}
			
		}
		
		}

	// say something to all clients
	private void outToAll(String msg) {
		for(ClientHandler aClient : clients) {
			aClient.out.println(msg);
		}
		
	}
		

	

}
