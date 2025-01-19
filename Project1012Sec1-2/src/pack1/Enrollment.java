package pack1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Enrollment {

	StudentServices stuSer = new StudentServices();
	
	
	public void displayStudents() throws SQLException {
		ResultSet rs = stuSer.getStudents();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		}
	}
	
	public void displayStudents(String department) throws SQLException {
		ArrayList<Student> students = stuSer.getStudents(department);
		for (Student s : students ) {
			System.out.println(s.stuId+" "+s.name+" "+s.surname+" "+s.department);
		} 
	}
	
	public void displayStudent(int stuId) throws SQLException {
		ResultSet rs = stuSer.getStudents();
		while(rs.next()) {
			if(rs.getInt(1)==stuId) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+
									rs.getString(3)+" "+rs.getString(4));
			}
		}
	}
	
	
	public static void main(String[] args) throws SQLException {
		
		Enrollment enr = new Enrollment();
		
		//enr.stuSer.saveStudent(new Student(1, "Mark", "Hall", "Computing"));
		//enr.stuSer.saveStudent(new Student(2, "Lisa", "Gray", "Computing"));
		//enr.stuSer.saveStudent(new Student(3, "Paul", "Lane", "Business"));
		
		/*enr.displayStudents();
		System.out.println();
		enr.displayStudents("Computing");
		System.out.println();
		enr.displayStudent(3);*/
		
		//enr.stuSer.updateStudent(3, "History");
		enr.stuSer.deleteStudent(3);
		
		enr.displayStudents();

	}

}
