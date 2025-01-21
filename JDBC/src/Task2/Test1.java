package Task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test1 {
	public static void main(String[] args) throws Exception {
		//load the driver
		
	Class.forName("com.mysql.cj.jdbc.Driver");

	//establish connection with database
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");

	//construct the sql statement
	String sql= "insert into student values(2,'xyz'),(3,'bvb')";
	//String sql= "UPDATE student SET name='www' WHERE name='abc'";
	//String sql= "DELETE from student WHERE rollno=2";
	

	//create objects of required statements
	Statement smt= con.createStatement();
	
	int rowsAffected= smt.executeUpdate(sql);
	System.out.println(rowsAffected);
	
	//execute sql statement
	

	//Closing the resources
	smt.close();
	con.close();
	}
}
