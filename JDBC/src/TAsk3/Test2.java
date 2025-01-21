package TAsk3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
			String sql="delete from student where rollno=?";
			PreparedStatement ps= con.prepareStatement(sql);
			
			ps.setInt(1, 10);
			ps.executeUpdate();			

}catch(Exception e)
		{
	e.printStackTrace();
		}
}
}
