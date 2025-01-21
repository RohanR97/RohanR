package TAsk3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
			String sql="insert into student values(?,?)";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1,10);
			ps.setString(2,"sk");
			
			ps.executeUpdate();
			ps.setInt(1,11);
			ps.setString(2,"rk");
			
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
