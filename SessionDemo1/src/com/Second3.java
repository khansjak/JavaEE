package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MyUser;

/**
 * Servlet implementation class Second3
 */
public class Second3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Second3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//MyUser u = new MyUser();
		HttpSession session = request.getSession(false);
		if(session!=null) {
			MyUser u =(MyUser) session.getAttribute("user");
			u.setContact((Integer.parseInt(request.getParameter("contact"))));
			u.setEmail(request.getParameter("email"));
			session.setAttribute("user", u);
			response.sendRedirect("third.html");
	
		}
	}

}
