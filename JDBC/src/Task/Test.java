package Task;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {
public static void main(String[] args) throws Exception {
	//load the driver
	
Class.forName("com.mysql.cj.jdbc.Driver");

//establish connection with database
Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");

//construct the sql statement
String sql="create table student(rollno int primary key, name varchar(50))";

//create objects of required statements
Statement smt=con.createStatement();

//execute sql statement
smt.execute(sql);

//Closing the resources
smt.close();
con.close();
}
}
