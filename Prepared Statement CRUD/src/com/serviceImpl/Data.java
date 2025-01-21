package com.serviceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.service.Requirements;

public class Data implements Requirements {

	@Override
	public void createTable() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		String sql="create table Patient(id int primary key, name varchar(50),address varchar(80),mobno long,disease varchar(50),billAmount int,dischargeDate int)";
		Statement smt=con.createStatement();
		smt.execute(sql);
		System.out.println("Table is created");
		smt.close();
		con.close();
		
	}
	//Changes made

	@Override
	public void insertData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		Scanner sc= new Scanner(System.in);
String sql="insert into patient values (?,?,?,?,?,?,?)";
		
		PreparedStatement ps= con.prepareStatement(sql);
		System.out.println("Enter the no of Patient's to add:");
		int pat=sc.nextInt();
		for(int i=1; i<=pat; i++)
		{
		
		System.out.println("Enter id: ");
		int id= sc.nextInt();
		System.out.println("Enter name: ");
		String name= sc.next();
		System.out.println("Enter Address: ");
		String address=sc.next();
		System.out.println("Enter MobNo: ");
		long mob= sc.nextLong();
		System.out.println("Enter Disease: ");
		String dis= sc.next();
		System.out.println("Enter Bill Amount: ");
		int bill=sc.nextInt();
		
		System.out.println("Enter Discharge Date: ");
		int ch= sc.nextInt();
	
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3,address);
			ps.setLong(4,mob);
			ps.setString(5, dis);
			ps.setInt(6,bill);
			ps.setInt(7,ch);
			ps.executeUpdate();
			
			
	}
		ps.close();
		con.close();
		
	}

	@Override
	public void viewSingleData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the id of the patient to view:");
		int view= sc.nextInt();
		String sql="select * from patient where id=?" ;
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setInt(1, view);
		ResultSet rs= ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("address"));
			System.out.println(rs.getLong("mobno"));
			System.out.println(rs.getString("disease"));
			System.out.println(rs.getInt("billAmount"));
			System.out.println(rs.getInt("dischargeDate"));
		}
		
		
	}

	@Override
	public void viewAllData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		String sql="select * from patient";
		PreparedStatement ps= con.prepareStatement(sql);
		ResultSet rs= ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getLong(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getInt(6));
			System.out.println(rs.getInt(7));
		}
		
	}
		

	@Override
	public void updateData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the id of the patient to update:");
		int no= sc.nextInt();
		System.out.println("Which field would you like to updtae:");
		System.out.println("1. Name");
        System.out.println("2. Address");
        System.out.println("3. Mobile no");
        System.out.println("4. Disease");
        System.out.println("5. Bill Amount");
        System.out.println("6. Discharge Date");
        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();
        
        switch(ch)
        {
        case 1:
        
        	System.out.println("Enter new name:");
        	String na=sc.next();
        	String sql1="Update patient set name=? where id=?";
        	PreparedStatement ps= con.prepareStatement(sql1);
    		ps.setString(1, na);
    		ps.setInt(2, no);
    		ps.execute();
    		System.out.println("Name updated successfully");
    		break;
    		
        case 2:

        	System.out.println("Enter new address:");
        	String add=sc.next();
        	String sql="Update patient set address=? where id=?";
        	PreparedStatement ps1= con.prepareStatement(sql);
    		ps1.setString(1, add);
    		ps1.setInt(2, no);
    		ps1.execute();
    		System.out.println("Address updated successfully");
    		break;
    		
        case 3:
        	System.out.println("Enter new Mobile no:");
        	long mob=sc.nextLong();
        	String sql2="Update patient set mobno=? where id=?";
        	PreparedStatement ps2= con.prepareStatement(sql2);
    		ps2.setLong(1, mob);
    		ps2.setInt(2, no);
    		ps2.execute();
    		System.out.println("Mobile no updated successfully");
    		break;
    		
        case 4:
        	System.out.println("Enter new Disease:");
        	String dis=sc.next();
        	String sql3="Update patient set disease=? where id=?";
        	PreparedStatement ps3= con.prepareStatement(sql3);
    		ps3.setString(1, dis);
    		ps3.setInt(2, no);
    		ps3.execute();
    		System.out.println("Disease updated successfully");
    		break;
    		
        case 5:
        	System.out.println("Enter new Bill Amount:");
        	int bill=sc.nextInt();
        	String sql4="Update patient set billAmount=? where id=?";
        	PreparedStatement ps4= con.prepareStatement(sql4);
    		ps4.setLong(1, bill);
    		ps4.setInt(2, no);
    		ps4.execute();
    		System.out.println("Bill Amount updated successfully");
    		break;
    		
        case 6:
        	
        	System.out.println("Enter new Discharge Date:");
        	int bbb=sc.nextInt();
        	String sql5="Update patient set dischargeDate=? where id=?";
        	PreparedStatement ps5= con.prepareStatement(sql5);
    		ps5.setLong(1, bbb);
    		ps5.setInt(2, no);
    		ps5.execute();
    		System.out.println("Discharge Date updated successfully");
    		break;
        	
        	
        	
        	
        	
        	
		
	}
	}

	@Override
	public void deleteSingleData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the id of the patient to delete:");
		int delete= sc.nextInt();
		String sql="delete from patient where id=?" ;
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setInt(1, delete);
		int rs= ps.executeUpdate();
		System.out.println("Data deleted");
		
	}

	@Override
	public void deleteAllData() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		String sql="delete from patient";
		PreparedStatement ps= con.prepareStatement(sql);
	   int rs= ps.executeUpdate();
	   System.out.println("All data deleted");
		
	}

	@Override
	public void deleteTable() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		String sql="drop table patient";
		PreparedStatement ps= con.prepareStatement(sql);
	   int rs= ps.executeUpdate();
	   System.out.println("Table deleted");
		
	}
	

}
