/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3b;

//Server that echoes back client's messages.
//At end of dialogue, sends message indicating number of
//messages received. Uses TCP.
import java.io.*;
import java.net.*;
import java.util.*;

public class TCPEchoServer
{
    private static ServerSocket servSock;
    private static final int PORT = 1234;
    
    public static void main(String[] args)
    {
        System.out.println("Opening port...\n");
        try
        {
            servSock = new ServerSocket(PORT); 
        }
        catch(IOException ioEx)
        {
            System.out.println("Unable to attach to port!");
            System.exit(1);
        }
        
        do
        {
            handleClient();
        }while (true);
    }
    
    
    private static void handleClient()
    {
        Socket link = null; 
        try
        {
            link = servSock.accept(); 

            Scanner input = new Scanner(link.getInputStream());
            PrintWriter output =
            new PrintWriter(
            link.getOutputStream(),true); 
            int numMessages = 0;
            String message = input.nextLine(); 
                
            while (!message.equals("***CLOSE***"))
            {
                System.out.println("Message received:" + message);
                numMessages++;
                output.println("Message " + numMessages + ": " + message); 
                message = input.nextLine();
            }
            output.println(numMessages + " messages received.");
        }
        catch(IOException ioEx)
        {
            ioEx.printStackTrace();
        }
        finally
        {
            try
            {
                System.out.println("\n* Closing connection... *");
                link.close(); 
            }
            catch(IOException ioEx)
            {
                System.out.println("Unable to disconnect!");
                System.exit(1);
            }
        }
    }
}