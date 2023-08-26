package prem.services;

import prem.enties.User;
import prem.models.TeacherModel;

public interface TeacherService {
	void addTeacher(User user,TeacherModel teacherModel);
}
