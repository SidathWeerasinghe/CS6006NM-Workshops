/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3b;


import java.io.*;
import java.net.*;

class UDPClient 
{
  public static void main (String[] args) throws Exception
  {
	String sentence;
	String modifiedSentence;
	InetAddress host = null;

	BufferedReader inFromUser = new BufferedReader
	 (new InputStreamReader(System.in));
		
	DatagramSocket clientSocket = new DatagramSocket();

	byte[] sendData = new byte[1024];
	byte[] receiveData = new byte[1024];

	sentence = inFromUser.readLine();
	sendData = sentence.getBytes();

	if (args.length == 0) {
            host = InetAddress.getByName("127.0.0.1");
        } else {
            host = InetAddress.getByName(args[0]);
        }
        
	DatagramPacket sendPacket = new DatagramPacket
				(sendData, sendData.length, host, 9876);
        clientSocket.send(sendPacket);
        
	DatagramPacket receivePacket = new 
         DatagramPacket(receiveData, receiveData.length);
	clientSocket.receive(receivePacket);

	modifiedSentence = new String(receivePacket.getData());

	System.out.println("FROM SERVER: " + modifiedSentence);

	clientSocket.close();
  }
}