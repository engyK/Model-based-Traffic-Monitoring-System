import java.io.IOException; 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//Class client by java-Socket
public class Client {

	public static final String SERVER_IP ="127.0.0.1"; //LocalHost
	public static final int SERVER_PORT =1234;

	public static void main(String[] args) throws IOException {
		
		Socket socket = new Socket(SERVER_IP,SERVER_PORT);
		ServerConnection serverConn = new ServerConnection(socket);
		BufferedReader keyboard =new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		new Thread (serverConn).start(); // 
		
		try {
			while(true) { 
				System.out.print(">");
				
				//wait user to type something
				String command = keyboard.readLine();
				out.println(command);
				
				
				if (command.contains("close connection")) break;
			}
		} catch(IOException e){
			System.err.println("IO exception in Client");
			
		}finally {
			out.println("Closed");
			keyboard.close();
			out.close();
			socket.close();
			System.exit(0);
			
		}	
	}
}
