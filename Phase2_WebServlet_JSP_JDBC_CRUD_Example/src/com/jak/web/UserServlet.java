package com.jak.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jak.dao.UserDAO;
import com.model.User;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDAO userDAO;

    public UserServlet() {
        super();
        userDAO = new UserDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		try {
			switch(action) {
			case "/newuser":
				userAdd(request,response);
				break;
				
			case "/deleteuser":
				deleteUser(request,response);
				break;
			case "/edituser":
				editUser(request,response);
				break;
				
				default:
					userList(request,response);
					break;
					
			}
			
		} catch(Exception e) {
			System.out.println();
			System.out.println();
		}
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void editUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void userList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<User> userList = userDAO.selectAllUser();
		request.setAttribute("listUser", userList);
		System.out.println(userList);		
		RequestDispatcher rd = request.getRequestDispatcher("user-list.jsp");
		rd.forward(request, response);
		
	}


	private void userAdd(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
