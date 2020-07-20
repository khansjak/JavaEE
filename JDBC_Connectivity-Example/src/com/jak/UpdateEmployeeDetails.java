package com.jak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateEmployeeDetails {

	public static void main(String[] args) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplilearn","root","Jak@2019");
			Statement stmt = conn.createStatement();
			int  rows = stmt.executeUpdate("update employee set EmpName=\"John Travolta\" where EmpName =\"Anant Sitaram\"");
			System.out.println("No. of rows deleted "+ rows);
			conn.close();
			}catch(Exception e) {
				System.out.println("Exception caught :");
				System.out.println(e.getMessage());
			}
	}

}
