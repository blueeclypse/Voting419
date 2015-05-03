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
		//serverSocket.setSoTimeout(30000);
	}
	
	private int addToHash(String name) {
		if (users.containsKey(name)) {
			return 0;
		}
		int id = randomGen.nextInt();
		while ((users.containsValue(id)) || (id <= 0)) {
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
	
	private void sendIDs(ArrayList<Integer> IDList){
		ObjectOutputStream oos;
		String serverName = "localhost";
		int port = 6067;
		try {
			System.out.println("Connecting to " + serverName+ " on port " + port);
	         Socket client = new Socket(serverName, port);
	         System.out.println("Just connected to "+ client.getRemoteSocketAddress());
	         OutputStream outToServer = client.getOutputStream();
	         DataOutputStream out =new DataOutputStream(outToServer);

	         //out.writeUTF("Hello from "+ client.getLocalSocketAddress());
	         out.writeUTF("CLA");
	         oos = new ObjectOutputStream(client.getOutputStream());
	         oos.writeObject(IDList);
		} catch(IOException e)
	      {
	         //e.printStackTrace();
	          System.out.println("CLA Server is not running");
	      }
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
	            if (input.equals("CTF")) {
	            	ArrayList<Integer> IDList = getIDs();
	            	sendIDs(IDList);
	            	System.out.println("closing");
	            	break;
	            }
	            System.out.println(input);
	            int id = addToHash(input);
	            System.out.println("id:"+id);
	            DataOutputStream out = new DataOutputStream(server.getOutputStream());
	            out.writeInt(id);
	            System.out.println(users.toString());
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
		//int port = Integer.parseInt(args[0]);
	     try {
	    	 Thread t = new CLA();
	    	 t.start();
	     } catch(IOException e) {
	    	 e.printStackTrace();
	     }
	}
}
