package lk.next.workshop;


import java.io.*;
import java.net.*;

class TCPClient 
{
  public static void main (String[] args) throws Exception
  {
	String sentence;
	String modifiedSentence;
	InetAddress host = null;
	BufferedReader inFromUser = 
	  new BufferedReader(new InputStreamReader(System.in));
		
	if (args.length == 0) {
            host = InetAddress.getByName("127.0.0.1");
        } else {
            host = InetAddress.getByName(args[0]);
        }

        Socket clientSocket = new Socket(host, 6789);

	DataOutputStream outToServer = 
	  new DataOutputStream(clientSocket.getOutputStream());

	BufferedReader inFromServer = 
	 new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));
	sentence = inFromUser.readLine();

	outToServer.writeBytes(sentence +'\n');

	modifiedSentence = inFromServer.readLine();
	System.out.println("FROM SERVER: " + modifiedSentence);

	clientSocket.close();
  }
}