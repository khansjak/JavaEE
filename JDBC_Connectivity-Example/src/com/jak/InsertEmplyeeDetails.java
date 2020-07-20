package com.jak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertEmplyeeDetails {

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter Employee ID:");
			int empid= in.nextInt();
			System.out.println("Enter Employee Name:");
			String empname= in.nextLine();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplilearn","root","Jak@2019");
			PreparedStatement stmt = conn.prepareStatement("insert into  employee values (?,?)");
			stmt.setInt(1,empid );
			stmt.setString(2, empname);
			int  rows = stmt.executeUpdate();
			System.out.println("No. of rows inserted "+ rows);
			conn.close();
			}catch(Exception e) {
				System.out.println("Exception caught :");
				System.out.println(e.getMessage());
			}
	}

}
