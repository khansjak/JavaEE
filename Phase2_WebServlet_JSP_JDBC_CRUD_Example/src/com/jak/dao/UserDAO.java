package com.jak.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.User;



public class UserDAO {
	private static final String insertUserSQL="insert into users(name,email,country) values(?,?,?)";
	private static final String updateUserSQL="update users set name = ? , email =?, country = ? where id=?";
	private static final String deleteUserSQL="delete from users where id=?";
	private static final String selectUserSQL="select * from users where id=?";
	private static final String selectAllUserSQL="select * from users";
	
	
	
	
	//Connect Method
	Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplilearn","root","Jak@2019");
		
		}catch(Exception e) {
			System.out.println("Exception Caught");
			System.out.println(e.getMessage());
			
		}
		return conn;
	}
	
	//Insert 
	public void insertUser(User user) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement(insertUserSQL);
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getEmail());
		stmt.setString(3, user.getCountry());
		stmt.executeUpdate();
		conn.close();
	}
	
	//Update
	public boolean updateUser(User user) throws SQLException{
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement(updateUserSQL);
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getEmail());
		stmt.setString(3, user.getCountry());
		stmt.setInt(4, user.getId());
		boolean result =stmt.executeUpdate()>0;
		conn.close();
		return result;
			
		}
	
	//Delete
	public boolean deletetUser(int id) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement(deleteUserSQL);
		stmt.setInt(1, id);
		boolean result = stmt.executeUpdate() >0;
		conn.close();
		return result;
	}
	
	
	//Select
	public User selectUser(int id) throws SQLException {
		
		User user = new User();
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement(selectUserSQL);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setEmail(rs.getString(3));
			user.setCountry(rs.getString(4));
		}
		return user;
		
		
	}
	
	
	//Select All
	public List<User> selectAllUser() throws SQLException {
		List<User> userList = new ArrayList<User>();
		Connection conn = getConnection();
		PreparedStatement stmt = conn.prepareStatement(selectAllUserSQL);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			User user = new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setEmail(rs.getString(3));
			user.setCountry(rs.getString(4));
			System.out.println("Hello");
			userList.add(user);
		}
		return userList;
		
		
	}
}
