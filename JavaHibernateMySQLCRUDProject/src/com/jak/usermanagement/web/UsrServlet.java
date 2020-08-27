package com.jak.usermanagement.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jak.model.User;
import com.jak.usermanagement.dao.UserDAO;

@WebServlet("/")
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
				newUserForm(request, response);
				break;
			case "/insertUser":
				insertUser(request,response);
				break;
			case "list":
				listUser(request, response);
				break;
				
			default:
				listUser(request, response);
				
			}
			
		} catch(Exception ex) {
			
		}
	}




	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setMail(request.getParameter("email"));
		user.setCountry(request.getParameter("country"));
		userDao.saveUser(user);
		response.sendRedirect("list");
		
	}

	private void newUserForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("I Clicked the new form creation link");
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);

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
