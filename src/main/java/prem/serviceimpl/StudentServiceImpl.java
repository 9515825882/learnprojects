package prem.serviceimpl;

import prem.enties.User;
import prem.services.StudentService;
import prem.controllers.*;
import prem.daoimpl.*;
import prem.services.*;
import prem.serviceimpl.*;
import prem.models.*;
import prem.dao.*;
import prem.enties.*;

public class StudentServiceImpl implements StudentService{
	private StudentDao dao=new StudentDaoImpl();
	private UserDao userDao=new UserDaoImpl();
	@Override
	public void addStudent(User user, StudentModel studentModel) {
		User user1=userDao.get(user.getUsername(), user.getPassword());
		Student student=new Student();
		student.setSname(studentModel.getName());
		student.setAddress(studentModel.getAddress());
		user1.addStudent(student);
		student.setUser(user1);
		dao.add(student);
	}

}
