package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class Test4 {
	public static void main(String[] args) {
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		CallableStatement cs=con.prepareCall("{call addtwonumber(?,?,?)}");
		cs.setInt(1, 10);
		cs.setInt(2, 20);
		cs.registerOutParameter(3,Types.INTEGER);
		cs.execute();
		System.out.println(cs.getInt(3));
		
	}catch(Exception e)
		{
		e.printStackTrace();
		}
	}
}
