package com.jak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class EmployeeDetails {
	 public static void main(String[] args) {
		System.out.println("List of Employees :");
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter your employee id to fetch the details :");
			int empid= in.nextInt();
			
			//1. Register the Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. Create Connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplilearn","root","Jak@2019");
			//3. Prepare Statement
			PreparedStatement stmt = conn.prepareStatement("select * from employee where EmpId=?");
			stmt.setInt(1, empid);
			//4. Execute Query
			ResultSet  result = stmt.executeQuery();
			
			while(result.next()) {
				System.out.println(result.getInt(1)+ " : "+result.getString(2));
				
			}
			//5. Close connection
			conn.close();
		}catch(Exception e) {
			System.out.println("Exception caught :");
			System.out.println(e.getMessage());
		}
	}

}
