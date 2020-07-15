package com.jak;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jak.dto.User;

/**
 * Servlet implementation class SummaryServlet
 */
public class SummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SummaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession(true);
		if(session!=null ) {
			User user = (User) session.getAttribute("userDetails");
			user.setContactNumber(request.getParameter("contact"));
			user.setCity(request.getParameter("city"));
			session.setAttribute("userDetails", user);
			
			writer.println("<br/></br> Welcome "+user.getFirstName()+"!");
			writer.println("<br/></br> Session Id :  "+session.getId()+".");
			writer.println("<br/></br> Session Time :  "+session.getCreationTime()+".");
			writer.println("<br/></br> Session Id :  "+user);
			
		}else {
			writer.println("There is no existing session !");
		}
	}

}
