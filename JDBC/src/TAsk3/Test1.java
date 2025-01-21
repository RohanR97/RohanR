package TAsk3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
			String sql="select * from student";
			PreparedStatement ps= con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt("rollno"));
				System.out.println(rs.getString("name"));
			}
			

}catch(Exception e)
		{
	e.printStackTrace();
		}
}
}
