package lk.next.workshop.ajax.pizza;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class lookupCustomer extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        response.setContentType("text/xml");
        PrintWriter out = response.getWriter();
        String phone = request.getParameter( "phone" );
        out.println("London Metropolitan University");
        out.println("School of Computing");
        out.println("Tower Building"); 
        out.println("220 Holloway Road");
        out.println("London N7 8DD");
        
}
}
