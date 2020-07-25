package com.jak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteEmployeeRecords {

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter EmpId to Delete :");
			int empid= in.nextInt();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplilearn","root","Jak@2019");
			
			PreparedStatement stmt = conn.prepareStatement("delete from employee where EmpId=?");
			stmt.setInt(1,empid );
			int  rows = stmt.executeUpdate();
			System.out.println("No. of rows deleted "+ rows);
			conn.close();
			}catch(Exception e) {
				System.out.println("Exception caught :");
				System.out.println(e.getMessage());
			}

	}

}
