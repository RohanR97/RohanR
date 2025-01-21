package com.client;

import java.util.Scanner;

import com.service.Requirements;
import com.serviceImpl.Data;

public class Test {
	public static void main(String[] args) {
		Requirements req=  new Data();
		Scanner sc= new Scanner(System.in);
		
		while (true)
		{
			System.out.println("Choose among the following:");
			System.out.println("1.Create Table");
			System.out.println("2.Insert Data");
			System.out.println("3.View Single Data");
			System.out.println("4.View All Data");
			System.out.println("5.Update Data");
			System.out.println("6.Delete Single Data");
			System.out.println("7.Delete All Data");
			System.out.println("8.Delete Table");
			System.out.println("9.Exit");
			int ch= sc.nextInt();
			
			switch(ch)
			{
			case 1:
				try {
					 req.createTable();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				System.out.println("Table created successfully");
				break;
			case 2:
				try {
					req.insertData();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				System.out.println("Data inserted successfully");
				break;
				
			case 3:
				try {
					req.viewSingleData();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				System.out.println("Single data viewed successfully");
				break;
				
			case 4:
				try {
					req.viewAllData();
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				System.out.println("Viewed all data successfully");
				break;
				
			case 5:
			
				try {
					req.updateData();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				System.out.println("Data updated successfully");
				break;
			
			
			case 6:
				try {
					req.deleteSingleData();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				System.out.println("Single data deleted successfully");
				break;
				
			case 7:
				try {
					req.deleteAllData();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				System.out.println("All data deleted successfully");
				break;
				
			case 8:
				try {
					req.deleteTable();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				System.out.println("Table deleted successfully");
				break;
				
			case 9:
			{
				System.exit(0);
			}
		
			default:
			{
				System.out.println("Invalid choice.");
			}
}
		}
	}
}
