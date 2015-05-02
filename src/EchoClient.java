import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;

public
class EchoClient {
    public static void main(String[] arstring) {
        try {
        	System.setProperty("javax.net.ssl.trustStore", "cacerts.jks");
        	System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket("localhost", 9999);

            InputStream inputstream = System.in;
            InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
            BufferedReader bufferedreader = new BufferedReader(inputstreamreader);

            OutputStream outputstream = sslsocket.getOutputStream();
            OutputStreamWriter outputstreamwriter = new OutputStreamWriter(outputstream);
            BufferedWriter bufferedwriter = new BufferedWriter(outputstreamwriter);
            String string = null;
            while ((string = bufferedreader.readLine()) != null) {
                bufferedwriter.write(string + '\n');
                bufferedwriter.flush();
                if(string.equals("exit"))
               {
                   System.out.println("Connection ended");
                   break;
               }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}