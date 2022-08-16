package com.librarymanagement.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.librarymanagement.model.StudentModel;

import javafx.collections.ListChangeListener.Change;

public class CheckBookIssuedOrNot implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpSession hs=((HttpServletRequest) req).getSession();
		
		StudentModel sd=new StudentModel();
		if(sd.checkIssuOrNot(Integer.parseInt(req.getParameter("bookId")),(int)hs.getAttribute("Id"))) {
			req.setAttribute("succMsg","Book Aleady Issued");
			RequestDispatcher rd=rd=req.getRequestDispatcher("studentdashboard");
			rd.forward(req,res);
		}
		else
			chain.doFilter(req, res);
	}
}
