package com.librarymanagement.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class SignupFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException {
		boolean status=false;
		HttpServletResponse res=(HttpServletResponse)response;
		if(request.getParameter("name") ==null || request.getParameter("email") ==null ||request.getParameter("password") ==null)
			status=true;
		try {
			Integer.parseInt(request.getParameter("name"));
			status=true;
		}
		catch(Exception e) {
			status=false; 
		}
		
		if(status)
		{
			request.setAttribute("failMsg", "Please enter valid data...");
			request.getRequestDispatcher("commonSignup.jsp").forward(request, res); 
		}else {
			chain.doFilter(request, res);
		}
	}
}
