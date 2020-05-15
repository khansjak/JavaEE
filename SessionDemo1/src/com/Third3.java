package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MyUser;

/**
 * Servlet implementation class Third3
 */
public class Third3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Third3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			MyUser u =(MyUser) session.getAttribute("user");
			u.setCity(request.getParameter("city"));
			u.setCountry(request.getParameter("country"));
			PrintWriter out = response.getWriter();
			out.println("<h2>Hello Mr."+u.getFname()+"</h2>");
			session.invalidate();
		}
	}

}
