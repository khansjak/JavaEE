package com.jak;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String username = request.getParameter("uname");
		String password = request.getParameter("upass");
		RequestDispatcher rd = null;
		if(username.equals("javed") && password.equals("khan")) {
			rd = request.getRequestDispatcher("WelcomeServlet");
			rd.forward(request, response);
		} else {
			rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
			writer.println("<h3 style ='color:red; font-weight:bold'>Invalid credentials , please try again !</h3>");
		}
		//writer.println("Getting Login Request ...");
	}

}
