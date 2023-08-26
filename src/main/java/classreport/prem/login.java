package classreport.prem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import prem.models.*;
import prem.serviceimpl.*;
import prem.services.*;
import prem.enties.*;
public class login extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	private UserService userService=new UserServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		LoginModel model=new LoginModel();
		model.setUsername(username);
		model.setPassword(password);
		User user=userService.getUser(model);
		if(user!=null)
		{
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("main.html");
			request.setAttribute("msg", "Username/Password is invalid");
			rd.forward(request, response);
		}
	}

}
