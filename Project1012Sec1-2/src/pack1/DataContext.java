package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataContext {

	public Connection getConnected() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","");	
	}
	
	
}
