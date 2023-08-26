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
import prem.enties.*;
import prem.serviceimpl.*;
import prem.services.*;

public class addteacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherService service=new TeacherServiceImpl();
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String qual=request.getParameter("qual");
		TeacherModel teacherModel=new TeacherModel();
		teacherModel.setName(name);
		teacherModel.setQualification(qual);
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		service.addTeacher(user, teacherModel);
		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}
