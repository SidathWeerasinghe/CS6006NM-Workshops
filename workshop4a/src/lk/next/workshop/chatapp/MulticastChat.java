
package lk.next.workshop.chatapp;


 
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public final class MulticastChat implements Runnable, WindowListener, ActionListener {
   protected InetAddress group;
   protected int port;
 
  public MulticastChat (InetAddress group, int port) {
     this.group = group;
     this.port = port;
     initAWT ();
   }
 
   protected Frame frame;
   protected TextArea output;
   protected TextField input;
   private static final Logger logger =
	  Logger.getLogger(MulticastChat.class.getName());

 
   protected void initAWT () {
     frame = new Frame
       ("MulticastChat [" + group.getHostAddress () + ":" + port + "]");
     frame.addWindowListener (this);
     output = new TextArea ();
     output.setEditable (false);
     input = new TextField ();
     input.addActionListener (this);
     frame.setLayout (new BorderLayout ());
     frame.add (output, "Center");
     frame.add (input, "South");
     frame.pack ();
   }
 
    protected Thread listener;
 
    public synchronized void start () throws IOException {
     if (listener == null) {
       initNet ();
       listener = new Thread (this);
       listener.start ();
       frame.setVisible (true);
     }
   }
 
   protected MulticastSocket socket;
   protected DatagramPacket outgoing, incoming;
 
   protected void initNet () throws IOException {
     socket = new MulticastSocket (port);
     socket.setTimeToLive (5);
     socket.joinGroup (group);
     outgoing = new DatagramPacket (new byte[1], 1, group, port);
     incoming = new DatagramPacket (new byte[65508], 65508);
   }
 
   public synchronized void stop () throws IOException {
     frame.setVisible (false);
     if (listener != null) {
       listener.interrupt ();
       listener = null;
       try {
         socket.leaveGroup (group);
       } finally {
         socket.close ();
       }
     }
   }
 
   @Override
   public void windowOpened (WindowEvent event) {
     input.requestFocus ();
   }
 
   @Override
   public void windowClosing (WindowEvent event) {
     try {
       stop ();
     } catch (IOException ex) {
           logger.log(Level.WARNING,"WindowClosing IOException",ex);
     }
   }
 
   @Override
   public void windowClosed (WindowEvent event) {}
   @Override
   public void windowIconified (WindowEvent event) {}
   @Override
   public void windowDeiconified (WindowEvent event) {}
   @Override
   public void windowActivated (WindowEvent event) {}
   @Override
   public void windowDeactivated (WindowEvent event) {}
 
   @Override
   public void actionPerformed (ActionEvent event) {
     try {
       byte[] utf = event.getActionCommand ().getBytes ("UTF8");
       outgoing.setData (utf);
       outgoing.setLength (utf.length);
       socket.send (outgoing);
       input.setText ("");
     } catch (IOException ex) {
       handleIOException (ex);
     }
   }
 
   protected synchronized void handleIOException (IOException ex) {
     if (listener != null) {
       output.append (ex + "\n");
       input.setVisible (false);
       frame.validate ();
       if (listener != Thread.currentThread ())
         listener.interrupt ();
       listener = null;
       try {
         socket.leaveGroup (group);
       } catch (IOException ignored) {
       }
       socket.close ();
     }
   }
 
   @Override
   public void run () {
     try {
       while (!Thread.interrupted ()) {
         incoming.setLength (incoming.getData ().length);
         socket.receive (incoming);
         String message = new String
           (incoming.getData (), 0, incoming.getLength (), "UTF8");
         output.append (message + "\n");
       }
     } catch (IOException ex) {
        handleIOException (ex);
     }
   }
 
   public static void main (String[] args) throws IOException {
     if ((args.length != 1) || (args[0].indexOf (":") < 0))
       throw new IllegalArgumentException
         ("Syntax: MulticastChat <group>:<port>");
 
    int idx = args[0].indexOf (":");
       InetAddress group = InetAddress.getByName (args[0].substring (0, idx));
     int port = Integer.parseInt (args[0].substring (idx + 1));
 
    MulticastChat chat = new MulticastChat (group, port);
     chat.start ();
   }
 }
