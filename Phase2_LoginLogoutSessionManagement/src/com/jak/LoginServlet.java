package com.jak;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		PrintWriter writer = response.getWriter();
		String name = request.getParameter("uname");
		String pass = request.getParameter("upass");
		
		if(name.equals("admin") && pass.equals("admin")) {
			HttpSession session =  request.getSession();
			session.setAttribute("username", name);
			request.getRequestDispatcher("Dashboard.html").include(request, response);
		} else {
			request.getRequestDispatcher("login.html").include(request, response);
			writer.println("<h3>Invalid Credentials !</h3>");
			
		}
	}

}
