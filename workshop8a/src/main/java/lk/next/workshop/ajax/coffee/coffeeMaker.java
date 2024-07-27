package lk.next.workshop.ajax.coffee;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class coffeeMaker extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        String name = request.getParameter( "name" );
        String size = request.getParameter( "size" );
        String beverage = request.getParameter( "beverage" );
        String coffeemaker = request.getParameter( "coffeemaker" );
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

	for (int i = 0; i < 1000000000; i++) {
		for (int j = 0; j < 10; j++) {

		    // looping here emulates brewing
		}
	    // looping here emulates brewing
	}
	out.println(coffeemaker+name);
    }
}