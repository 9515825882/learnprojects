package classreport.prem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prem.dao.*;
import prem.daoimpl.*;
import prem.enties.*;
import prem.models.*;
import prem.enties.*;
import prem.services.*;
import prem.serviceimpl.*;

@WebServlet("/addStudent")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService studentService=new StudentServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		StudentModel studentModel=new StudentModel(name, address);
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		studentService.addStudent(user, studentModel);
		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}
