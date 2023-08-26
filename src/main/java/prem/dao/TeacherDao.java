package prem.dao;

import java.util.List;

import prem.enties.Teacher;


public interface TeacherDao {
	void add(Teacher teacher);
	void delete(int tid);
	List<Teacher> getAll();
	
}
