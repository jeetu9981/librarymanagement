package com.librarymanagement.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.librarymanagement.model.StudentModel;

public class RouteSafe implements Filter{
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpSession hs=((HttpServletRequest) req).getSession();
		HttpServletResponse re=(HttpServletResponse)res;
		if(hs.getAttribute("Id")==null) {
			chain.doFilter(req, res);
		}
		else {
			re.sendRedirect("commonSignin.jsp");
		}
	}
}
