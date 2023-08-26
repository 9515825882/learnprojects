package prem.serviceimpl;

import prem.enties.User;
import prem.models.TeacherModel;
import prem.services.TeacherService;
import prem.enties.*;
import prem.dao.*;
import prem.daoimpl.*;

public class TeacherServiceImpl implements TeacherService{
	private UserDao userDao=new UserDaoImpl();
	private TeacherDao teacherDao=new TeacherDaoImpl();
	@Override
	public void addTeacher(User user, TeacherModel teacherModel) {
			Teacher teacher=new Teacher();
			teacher.setName(teacherModel.getName());
			teacher.setQual(teacherModel.getQualification());
			User user1=userDao.get(user.getUsername(), user.getPassword());
			user1.addTeacher(teacher);
			teacher.setUser(user1);
			teacherDao.add(teacher);
	}
	
}

