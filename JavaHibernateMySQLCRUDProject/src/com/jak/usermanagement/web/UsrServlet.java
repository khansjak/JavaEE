package com.jak.usermanagement.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jak.model.User;
import com.jak.usermanagement.dao.UserDAO;


public class UsrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDao;
       
    public UsrServlet() {
        super();
        userDao = new UserDAO();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =  request.getServletPath();
		try {
			switch(action) {
			case "/new":
				newUser(request,response);
				break;
				
			default:
				listUser(request, response);
				
			}
			
		} catch(Exception ex) {
			
		}
	}

	private void newUser(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("I clicked the new user button");
		
	}


	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> listUser=userDao.getAllUser();
		/*for(User user:listUser) {
			System.out.println(user);
		}*/
		request.setAttribute("listUser",listUser );
		RequestDispatcher rd = request.getRequestDispatcher("user-list.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
