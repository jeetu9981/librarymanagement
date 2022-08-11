package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BookDao;
import com.model.ExpireIssuseBooks;

public class AdminExpireIsueBook extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		BookDao bd=new BookDao();
		HttpSession s=req.getSession();
		ArrayList<ExpireIssuseBooks> al=bd.expireNooks((int)s.getAttribute("Id"));
		req.setAttribute("expires",al);
		RequestDispatcher rd=req.getRequestDispatcher("ExpiresBooks.jsp");
		rd.forward(req,res);
	}
}
