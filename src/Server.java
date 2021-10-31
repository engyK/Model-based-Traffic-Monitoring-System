import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	
	private static final int PORT=1234;
	
	private static ArrayList <ClientHandler> clients = new ArrayList<>();
	private static ExecutorService pool = Executors.newFixedThreadPool(1);
	
	
	public static void main(String[] args) throws IOException {
		//server waiting for a client
		ServerSocket listener = new ServerSocket(PORT);
		
			
			try {
				while(true) {
					//accepting client
					System.out.println("[SERVER] Waiting for client connection...");
					Socket client = listener.accept();
					System.out.println("[SERVER] connected to client!");
					
					
					ClientHandler clientThread = new ClientHandler(client, clients);
					clients.add(clientThread);
					pool.execute(clientThread);
				} 
			}catch (IOException e){
				
				System.err.println("IO exception in Server");
			} finally {
				listener.close();
			}
				
	}
}


