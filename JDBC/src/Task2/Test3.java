package Task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test3 {
	public static void main(String[] args) throws Exception {
		//load the driver
		
	Class.forName("com.mysql.cj.jdbc.Driver");

	//establish connection with database
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");

	//construct the sql statement
	String sql= "select * from student";

	

	//create objects of required statements
	Statement smt= con.createStatement();
	ResultSet rs= smt.executeQuery(sql);
	
	while(rs.next())
	{
		System.out.println((rs.getInt(1)));
		System.out.println((rs.getString(2)));
	}
	

	

	//Closing the resources
	smt.close();
	con.close();
	}
}
