import java.net.*;
import java.io.*;
import java.util.*;

public class CLA extends Thread{
	private ServerSocket serverSocket;
	private Hashtable<String, Integer> users;
	Random randomGen;
	
	public CLA () throws IOException {
		serverSocket = new ServerSocket(6066);
		randomGen = new Random();
		users = new Hashtable<String, Integer>();
		serverSocket.setSoTimeout(10000);
	}
	
	private int addToHash(String name) {
		if (users.containsKey(name)) {
			return 0;
		}
		int id = randomGen.nextInt();
		while (users.containsValue(id)) {
			id = randomGen.nextInt();
		}
		Integer idNum = new Integer(id);
		users.put(name, idNum);
		return id;
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
	            String input = new String();
	            input = in.readUTF();
	            System.out.println(input);
	            int id = addToHash(input);
	            DataOutputStream out = new DataOutputStream(server.getOutputStream());
	            out.write(id);
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
