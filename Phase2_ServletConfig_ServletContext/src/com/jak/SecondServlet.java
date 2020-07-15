package com.jak;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<h3>Accessing ServletContext Parameters: </h3>"); 
		ServletContext context = getServletContext();
		writer.println("<h3>URL Value :</h3>"+context.getInitParameter("URL"));
		writer.println("<h3>Driver Value :</h3>"+context.getInitParameter("Driver"));
		writer.println("Service Method of Second Servlet !");
		ServletConfig config = getServletConfig();
		writer.println("<br/><h2>Message :</h2>"+config.getInitParameter("Message"));
		writer.println("<h2>Command :</h2>"+config.getInitParameter("Command"));
	}

}
