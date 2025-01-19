package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

public class StudentServices {

	DataContext ctx = new DataContext();
	
	public ResultSet getStudents() throws SQLException {
		return ctx.getConnected().createStatement().executeQuery("select * from student");
	}
	
	public ArrayList<Student> getStudents(String department) throws SQLException{
		String query = "select * from student where department='"+department+"'";
		ResultSet rs = ctx.getConnected().createStatement().executeQuery(query);
		
		ArrayList<Student> temp_students = new ArrayList<Student>();
		
		while(rs.next()) {
			Student temp_stu = new Student( rs.getInt(1),
											rs.getString(2),
											rs.getString(3),
											rs.getString(4) );	
			temp_students.add(temp_stu);
		}
		return temp_students;
	}
	
	public Student getStudent(int stuId) throws SQLException{
		String query = "select * from student where stu_id='"+stuId+"'";
		ResultSet rs = ctx.getConnected().createStatement().executeQuery(query);
		
		rs.next();
		
		Student temp_stu = new Student( rs.getInt(1),
										rs.getString(2),
										rs.getString(3),
										rs.getString(4) );	
		return temp_stu;
	}
	
	public void saveStudent(Student s) throws SQLException {
		String query = "insert into student values(?,?,?,?)";
		PreparedStatement ps = ctx.getConnected().prepareStatement(query);
		ps.setInt(1, s.stuId);
		ps.setString(2, s.name);
		ps.setString(3, s.surname);
		ps.setString(4, s.department);
		
		ps.executeUpdate();

	}
	
	public void updateStudent(int stuId, String department) throws SQLException {
		String query = "update student set department=? where stu_id=?";
		PreparedStatement ps = ctx.getConnected().prepareStatement(query);
		ps.setString(1, department);
		ps.setInt(2, stuId);
		
		ps.executeUpdate();
	}
	
	public void deleteStudent(int stuId) throws SQLException {
	
		String query = "delete from student where stu_id=?";
		PreparedStatement ps = ctx.getConnected().prepareStatement(query);
		ps.setInt(1, stuId);
		ps.executeUpdate();
	}
	
}
