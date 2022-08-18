package com.librarymanagement.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class SigninFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		boolean status=false;
		HttpServletResponse res=(HttpServletResponse)response;
		if(request.getParameter("memership") =="" || request.getParameter("email") ==null)
			status=true;
		
		if(status)
		{
			request.setAttribute("failMsg", "Please enter valid data...");
			request.getRequestDispatcher("commonSignin.jsp").forward(request, res); 
		}else {
			chain.doFilter(request, res);
		}
		
	}

}
