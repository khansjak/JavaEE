package com.jak.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MainServlet() {
        super();
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("Session Created.Listener will be invoked..");
		
		session.setAttribute("username", "jak");
		session.setAttribute("password", "jak");
		System.out.println("Session attribute added .Listener will be invoked..");
		
		session.setAttribute("username", "mac");
		session.setAttribute("password", "mac");
		System.out.println("Session attribute modified.Listener will be invoked..");
		
		session.removeAttribute("username");
		session.removeAttribute("password");
		System.out.println("Session attribute removed.Listener will be invoked..");
		
		session.invalidate();
		System.out.println("Session Destroyed.Listener will be invoked..");
		
		
	}

}
