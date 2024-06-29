package lk.next.workshop.chatapp;

import java.net.*;

public class ChatServer {

	public ChatServer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 MulticastSocket server = new MulticastSocket(4321);
		 InetAddress group = InetAddress.getByName("228.5.6.7");
		 //getByName - returns IP address of the given host
		 server.joinGroup(group);
		 System.out.println("***Server Started***");


		 /* Server continually receives data and prints them */

		 byte[] sendData = new byte[1024];
	     byte[] receiveData = new byte[1024];
	     
		 while(true) {

	 
			 DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		     server.receive(receivePacket);
		     String msg = new String(receivePacket.getData()).trim();
		     System.out.println("<from client>"+msg);
     	 
			 sendData = new String("<to client>"+msg).getBytes();
			 DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, group, 8885);
			 server.send(sendPacket);
		     }
	     }
	}

