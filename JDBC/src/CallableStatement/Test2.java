package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Test2 {
	public static void main(String[] args) {
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		CallableStatement cs=con.prepareCall("{call insertData(?,?)}");
		cs.setInt(1, 9);
		cs.setString(2, "AK");
		cs.execute();
		
	}catch(Exception e)
		{
		e.printStackTrace();
		}
	}
	}	

