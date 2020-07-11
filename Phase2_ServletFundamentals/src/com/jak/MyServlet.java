package com.jak;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MyServlet() {
        super();

    }

    //Method for providing response for incoming request
    //But when  we comment the response will be served by Get method
    
    /*
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.println("Hello from Service method");
	}
	*/


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter writer = response.getWriter();
		String username = request.getParameter("uname");
		writer.println("Welcome "+username+"!");
		writer.println("<h2>Hello from Get method</h2>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		doGet(request, response);
		PrintWriter writer = response.getWriter();
		String username = request.getParameter("uname");
		writer.println("Welcome "+username+"!");
		writer.println("<h2>Hello from Post method</h2>");
		
	}

}
