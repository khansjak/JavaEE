package com.jak;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LogoutServlet() {
        super();

    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		doGet(request, response);
		HttpSession session = request.getSession(true);
		if(session != null) {
			//writer.println("Session exist");
			session.invalidate();
			request.getRequestDispatcher("login.html").include(request,response);
			writer.println("Successfully logged out !");
		}else {
			writer.println("Session dors not exist");
		}
	}

}
