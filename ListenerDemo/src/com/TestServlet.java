package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("Servlet : Session Created. Listener wil be invoked");
		session.setAttribute("username", "tom");
		session.setAttribute("password", "jerry");
		System.out.println("Servlet : Session attrbute displayed. Listener to come here.");
		session.setAttribute("username", "jim");
		System.out.println("Servlet : Session modified. Listener will be invoked.");
		session.invalidate();
		System.out.println("Servlet : Session destroyed.");
		
		
	}

}
