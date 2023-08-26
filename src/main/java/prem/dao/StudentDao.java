package prem.dao;

import java.util.List;

import prem.enties.Student;


public interface StudentDao {
	void add(Student student);
	void delete(int sid);
	List<Student> getAll();
}
