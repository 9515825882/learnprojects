package classreport.prem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        out.println("<html>");
	        out.println("<head><title>Welcome</title></head>");
	        out.println("<body>");
	        out.println("<h1>Welcome, Admin!</h1>");
	        out.println("<p>You have successfully logged in.</p>");
	        out.println("</body></html>");
	}

}
