/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3b;


import java.net.*;

class UDPServer 
{
	public static void main (String[] args) throws Exception
	{
		String sentence;
		String capitalisedSentence;
		InetAddress host = null;
		int port;
		
		DatagramSocket serverUDPSocket = new DatagramSocket(9876);

		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];

		while(true)
		{
			DatagramPacket receivePacket = new
               		DatagramPacket(receiveData, receiveData.length);
			serverUDPSocket.receive(receivePacket);
			sentence = new String(receivePacket.getData());
			host = receivePacket.getAddress();
			port = receivePacket.getPort();

			capitalisedSentence = sentence.toUpperCase();
			sendData = capitalisedSentence.getBytes();

			DatagramPacket sendPacket = new 
              		DatagramPacket(sendData, sendData.length, host, port);
			serverUDPSocket.send(sendPacket);
		}
	}
}