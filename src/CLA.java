import java.net.*;
import java.io.*;
import java.util.*;

public class CLA extends Thread{
	private ServerSocket serverSocket;
	private Hashtable<String, Integer> users;
	
	public CLA (int port) throws IOException {
		serverSocket = new ServerSocket(port);
		users = new Hashtable<String, Integer>();
		serverSocket.setSoTimeout(10000);
	}
	
	private void addToHash(String name, int id) {
		Integer idNum = new Integer(id);
		users.put(name, idNum);
	}
	
	private ArrayList<Integer> getIDs() {
		ArrayList<Integer> IDList = new ArrayList<Integer>(users.values());
		return IDList;
	}
	
	public void run() {
		while (true) {
			try {
				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();
	            System.out.println("Just connected to " + server.getRemoteSocketAddress());
	            DataInputStream in = new DataInputStream(server.getInputStream());
	            System.out.println(in.readUTF());
	            DataOutputStream out = new DataOutputStream(server.getOutputStream());
	            out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
	            server.close();
			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
	            break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}
	
	public static void main(String args[]) {
		int port = Integer.parseInt(args[0]);
	     try {
	    	 Thread t = new GreetingServer(port);
	    	 t.start();
	     } catch(IOException e) {
	    	 e.printStackTrace();
	     }
	}
}
