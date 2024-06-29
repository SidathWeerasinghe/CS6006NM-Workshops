package lk.next.workshop.chatapp;

import java.io.*;
import java.net.*;

public class ChatClient {

	public ChatClient() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		 MulticastSocket chat = new MulticastSocket(4321);
		 InetAddress group = InetAddress.getByName("228.5.6.7");
		 chat.joinGroup(group);
		 System.out.println("***Chatgroup joined***");
	 	 byte[] receiveData = new byte[1024];
	 	 
		 while(true) {
			 
	    	 String msg = "";
		     System.out.println("<to server>");
		     BufferedReader br = new BufferedReader(new
		     InputStreamReader(System.in));
		     msg = br.readLine();
		     DatagramPacket sendData = new DatagramPacket(msg.getBytes(), 0, msg.length(), group, 4321);
		     chat.send(sendData);
		     
		     DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			 chat.receive(receivePacket);
     	     System.out.println("<from server>" + (new String(receivePacket.getData())).trim());

	         }
    	}
    }