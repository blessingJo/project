package com.opule.controller.admin;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter {

   
    public AdminLoginFilter() {
    }


	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//obtaining the HTTP session from the request and cast rge httpRequest object to the httpServletRequest
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		//obtaining the seesion and using the argument true or false in the getSession()
		HttpSession session = httpRequest.getSession(false); //false bcoz we get the session and don't create a new one if the session doesn't exist
		//condition indicating that the user is logged or not
		
		boolean  loggedIn = session != null && session.getAttribute("useremail") != null;
		
		//condition to allow the request to be passed thru the filter
		String loginURI = httpRequest.getContextPath() + "/admin/login";
		//boolean variable to indicate the request is a login request 
		boolean loginRequest = httpRequest.getRequestURI().contentEquals(loginURI);
		//display the admin homepage when you go on login.jsp page if ADMIN is already logged in
		//instead of showing the login page again
		boolean loginPage = httpRequest.getRequestURI().endsWith("login.jsp");
		
		if (loggedIn && (loginRequest || loginPage)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/");
			//foward the dispacther 
			dispatcher.forward(request, response);
		}
		//check if user is logged in
		
		else if (loggedIn || loginRequest) {
			System.out.println("user logged in");
			//continue the normal request flow
			chain.doFilter(request, response);
		}else {
		//else show the login page using request dispathcer 
			System.out.println("failed");
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		//foward the dispacther 
		dispatcher.forward(request, response);
		
		
		}
		
		System.out.println("AdminLoginFilter is invoked");
		//pass the request along the filter chain 
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
