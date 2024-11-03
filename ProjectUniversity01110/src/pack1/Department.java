package pack1;

import java.util.ArrayList;

public class Department {

	int deptId;
	String title;
	
	ArrayList<Student> students;
	ArrayList<Course> courses;
	
	public void addStudent(Student s) {
		this.students.add(s);
	}
	
	public void addCourse(Course c) {
		this.courses.add(c);
	}
	
}
