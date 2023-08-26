package prem.enties;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String email;
	@OneToMany(mappedBy = "user")
	private Set<Subject> subjects = new HashSet<>();

	@OneToMany(mappedBy = "user")
	private Set<AcdemicClass> classes = new HashSet<>();

	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
	private Set<Teacher> teachers = new HashSet<>();

	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
	private Set<Student> students = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<AcdemicClass> getClasses() {
		return classes;
	}

	public void setClasses(Set<AcdemicClass> classes) {
		this.classes = classes;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	// helper method
	public void addSubject(Subject subject) {
		subjects.add(subject);
	}

	public void addClass(AcdemicClass acdemicClass) {
		classes.add(acdemicClass);
	}

	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}

	public void addStudent(Student student) {
		students.add(student);
	}
}
