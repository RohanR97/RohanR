package CallableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;

public class Test {
	public static void main(String[] args) {
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		CallableStatement cs=con.prepareCall("{call insertData(8,'DK')}");
		cs.execute();
		
	}catch(Exception e)
		{
		e.printStackTrace();
		}
	}
	}	
	

