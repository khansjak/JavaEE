package com;

import java.io.IOException;
import dto.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class First1
 */
public class First1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public First1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUser u = new MyUser();
		HttpSession session = request.getSession();
		u.setFname(request.getParameter("fname"));
		u.setLname(request.getParameter("lname"));
		session.setAttribute("user", u);
		response.sendRedirect("second.html");
		
		
	}

}
