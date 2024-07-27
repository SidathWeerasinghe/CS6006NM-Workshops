package lk.next.workshop.ajax.pizza;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class placeOrder extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        String address = request.getParameter( "address" );
        String order = request.getParameter( "order" );
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
out.println( "<html><head><title>Break Neck Pizza Delivery</title>" +
             "<link rel=\"stylesheet\" type=\" text/css\" href=\"breakneck.css\" /></head>" );
out.println( "<body>");
out.println( "<h1> Pizza Order</h1>");
out.println( "<h2>Delivery Address</h2>");
out.println(address);
out.println( "<h2>Your Order:</h2>");
out.println(order);
out.println( "</body></html>");
out.close();  // close stream to complete the page
}   
}
