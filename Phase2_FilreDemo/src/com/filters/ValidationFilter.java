package com.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class ValidationFilter
 */
public class ValidationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ValidationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		System.out.println("Hi from the filter");
		String pan = request.getParameter("pan");
		if (pan == null || !pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
			request.getRequestDispatcher("index.html").include(request, response);
			out.println("<span style='color:red'>Invalid PAN number ! </span>");
		}else {
			request.setAttribute("pan", pan);
			chain.doFilter(request, response);
		}
		System.out.println("Bye from the Filter");
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
