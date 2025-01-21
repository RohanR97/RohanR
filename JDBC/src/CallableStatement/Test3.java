package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Test3 {
	public static void main(String[] args) {
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		CallableStatement cs=con.prepareCall("{call insertandget(?,?)}");
		cs.setInt(1, 10);
		cs.setString(2, "WK");
		ResultSet rs= cs.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
		}
		
	}catch(Exception e)
		{
		e.printStackTrace();
		}
	}
}
