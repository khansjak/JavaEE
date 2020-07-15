package com.jak;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TestServlet() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("Session created listener will be invoked !");
		session.setAttribute("username", "Tom");
		session.setAttribute("password", "Jerry");
		System.out.println("Session attribute displayes. listener to com here.");
		session.setAttribute("username", "Jim");
		System.out.println("Attribute modified , listener will be invoked !");
		session.invalidate();
		System.out.println("Session destroyed !");
	}

}
