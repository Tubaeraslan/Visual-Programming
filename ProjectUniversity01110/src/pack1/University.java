package pack1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class University {

	ArrayList<Department> departments = new ArrayList<Department>();
	
	public String getString(String message) {
		return JOptionPane.showInputDialog(message);
	}
	
	public int getInt(String message) {
		return Integer.parseInt( JOptionPane.showInputDialog(message) );
	}
	
	
	public void newDepartment() {
		
		int deptID = getInt("Department ID");
		boolean checkDept = true;
		
		for (Department d : departments) {
			if(d.deptId==deptID) {
				checkDept = false;
			}
		}
		
		boolean checkDept2 = departments.stream()
				   .filter(d -> d.deptId==deptID)
				   .toList()
				   .isEmpty();
		
		
		if(checkDept2) {
			Department dept = new Department();
			dept.deptId = deptID;
			dept.title = getString("Department Title");
			dept.courses = new ArrayList<Course>();
			dept.students = new ArrayList<Student>();
			
			departments.add(dept);
			JOptionPane.showMessageDialog(null, "Department Saved!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Wrong ID");
		}
		
	}
	
	public void newCourse(int deptId) {
		boolean checkDept = departments.stream()
				   .filter(d -> d.deptId==deptId)
				   .findFirst()
				   .isPresent();
				   
		if(checkDept) {
			Course cou = new Course(getInt("Course ID"), getString("Title"));
			departments.stream()
					   .filter(d -> d.deptId==deptId)
					   .findFirst()
					   .get().addCourse(cou);
		}
	}
	
	public void newStudent(int deptId) {
		
	}
	
	public void getDepartments() {
		for (Department d : departments) {
			System.out.println(d.deptId+" "+d.title);
			System.out.println("Courses in "+d.title);
			for (Course c : d.courses) {
				System.out.println(c.courseId+" "+c.title);
			}
			System.out.println("Students in "+d.title);
			for (Student s : d.students) {
				System.out.println(s.studentId+" "+s.name+" "+s.surname);
			}
		}
		
		
		departments.forEach(d -> {
			System.out.println(d.deptId+" "+d.title);
			System.out.println("Courses in "+d.title);
			d.courses.forEach(c -> System.out.println(c.courseId+" "+c.title) );
			System.out.println("Students in "+d.title);
			d.students.forEach(s -> System.out.println(s.studentId+" "+s.name+" "+s.surname));
		});
	}
	
	public void getDepartment(int deptId) {
		
	}
	
	public void getStudents() {
		
	}
	
	public void getStudents(int deptId) {
		
	}
	
	public void getStudent(int studentId) {
		
	}
	
	
	public static void main(String[] args) {
		
	}

}
