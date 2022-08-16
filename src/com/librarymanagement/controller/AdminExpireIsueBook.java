package com.librarymanagement.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.librarymanagement.entity.ExpireIssuseBooksEntity;
import com.librarymanagement.model.BookModel;

public class AdminExpireIsueBook extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		BookModel bd=new BookModel();
		HttpSession s=req.getSession();
		ArrayList<ExpireIssuseBooksEntity> al=bd.expireNooks((int)s.getAttribute("Id"));
		req.setAttribute("expires",al);
		RequestDispatcher rd=req.getRequestDispatcher("ExpiresBooks.jsp");
		rd.forward(req,res);
	}
}
