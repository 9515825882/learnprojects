package classreport.prem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prem.services.*;
import prem.serviceimpl.*;
import prem.models.*;
@WebServlet("/register")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService=new UserServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		UserModel userModel=new UserModel(username, password, email);
		userService.register(userModel);
		RequestDispatcher rd=request.getRequestDispatcher("login.html");
		request.setAttribute("msg", "User Registered Successfully");
		rd.forward(request, response);
	}

}
