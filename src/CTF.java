import java.net.*;
import java.nio.channels.Channels;
import java.io.*;
import java.util.*;

public class CTF extends Thread{
	private ServerSocket serverSocket;
	private ArrayList<Integer> idList;
	private int[] voteTally;
	private Hashtable<Integer, Integer> alreadyVoted;
	Random randomGen;
	
	public CTF () throws IOException {
		serverSocket = new ServerSocket(6067);
		randomGen = new Random();
		alreadyVoted = new Hashtable<Integer, Integer>();
		voteTally = new int[5];
		//serverSocket.setSoTimeout(30000);
	}
	
	public boolean initialBoot() {
		  String serverName = "localhost";
	      String temp = "6067";
	      int port = Integer.parseInt(temp);
	      try
	      {
	         System.out.println("Connecting to " + serverName+ " on port " + port);
	         Socket client = new Socket(serverName, port);
	         System.out.println("Just connected to "+ client.getRemoteSocketAddress());
	         OutputStream outToServer = client.getOutputStream();
	         DataOutputStream out =new DataOutputStream(outToServer);

	         //out.writeUTF("Hello from "+ client.getLocalSocketAddress());
	         out.writeUTF("CTF");
	         client.close(); 
	      } catch(IOException e)
	      {
	         //e.printStackTrace();
	          System.out.println("CLA Server is not running");
	          return false;
	      }
	      return true;
	}
	
	public void run() {
		initialBoot();
		while (true) {
			try {
				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();
                                //Socket server = new Socket("localhost", 6067);
	            System.out.println("Just connected to " + server.getRemoteSocketAddress());
	            DataInputStream in = new DataInputStream(server.getInputStream());
	            String input = new String();
	            input = in.readUTF();
	            if (input.equals("CLA")) {
	            	ObjectInputStream ois = new ObjectInputStream(server.getInputStream());
	            	Object obj = new Object();
	            	try {
						obj = ois.readObject();
						ArrayList<Integer> obj2 = (ArrayList<Integer>) obj;
						idList = obj2;
						System.out.println(idList.toString());
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	
	            }
	            StringTokenizer strtok = new StringTokenizer(input, ",");
	            int claID = Integer.parseInt(strtok.nextToken().replaceAll("\\s", ""));
	            int userID = Integer.parseInt(strtok.nextToken().replaceAll("\\s", ""));
	            int voteNum = Integer.parseInt(strtok.nextToken().replaceAll("\\s", ""));
	            System.out.println("claID: " + claID + " userID: " + userID + " voteNum: " + voteNum);
	            boolean registeredUser = false;
	            for (int x = 0; x < idList.size(); x++) {
	            	if (claID == idList.get(x)) {
	            		registeredUser = true;
	            		break;
	            	}
	            }
	            if (registeredUser) {
	            	if (!alreadyVoted.contains(userID)) {
	            		voteTally[voteNum]++;
	            		alreadyVoted.put(userID, voteNum);
	            	}
	            }
	            System.out.println("Votes: " + voteTally.toString());
	            System.out.println("Already voted: " + alreadyVoted.toString());
	            System.out.println(input);
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
	    	Thread t = new CTF();
	    	t.start();
	    } catch(IOException e) {
	    	e.printStackTrace();
	    }
	}
}
