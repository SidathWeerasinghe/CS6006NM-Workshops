package lk.next.workshop;

import java.io.*;
import java.net.*;
import java.util.*;

public class TCPEmailClient
{
	private static InetAddress host;
	private static final int PORT = 1234;
	private static String name;
	private static Scanner networkInput, userEntry;
	private static PrintWriter networkOutput;

	public static void main(String[] args) throws IOException
	{
		try
		{
			host = InetAddress.getLocalHost();
		}
		catch(UnknownHostException uhEx)
		{
			System.out.println("Host ID not found!");
			System.exit(1);
		}

		userEntry = new Scanner(System.in);

		do
		{
			System.out.print("\nEnter name ('Dave' or 'Karen'): ");
			name = userEntry.nextLine();
		}while (!name.equals("Dave") && !name.equals("Karen"));

		talkToServer();
	}


	private static void talkToServer() throws IOException
	{
      /********************************************/
      /* Here should go your code for rhe request */
      /********************************************/
	}


	private static void doSend()
	{
		System.out.println("\nEnter 1-line message: ");
		String message = userEntry.nextLine();
		networkOutput.println(name);
		networkOutput.println("send");
		networkOutput.println(message);
	}


	private static void doRead()
	{
      /*********************************************/
      /* Here should go your code for the response */
      /*********************************************/
	}
}