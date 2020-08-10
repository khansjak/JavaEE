package com.jak.usermanagement.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jak.usermanagement.dao.UserDAO;
import com.jak.usermanagement.model.User;

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDAO userDao;

	public UserServlet() {
		super();
		userDao = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				newUserForm(request, response);
				break;

			case "/insert":
				inserUser(request, response);
				break;
				
			case "/edit":
				editUserForm(request, response);
				break;
				
			case "/delete":
				deleteUser(request, response);
				
			case "/update":
				updateUser(request, response);
				break;

			case "/list":
				listUser(request, response);
				break;

			default:
				listUser(request, response);
				break;
			}

		} catch (Exception ex) {
			System.out.println("Exception Caught : " + ex.getMessage());
		}
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user = new User();
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setCountry(request.getParameter("country"));
		userDao.updateUser(user);
		response.sendRedirect("list");

		
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		response.sendRedirect("list");
		
	}

	private void editUserForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User exisitingUser = userDao.getUserById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", exisitingUser);
		dispatcher.forward(request, response);
		
	}

	private void inserUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setCountry(request.getParameter("country"));
		userDao.saveUser(user);
		response.sendRedirect("list");

	}

	private void newUserForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);

	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> listUser = userDao.getAllUser();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}