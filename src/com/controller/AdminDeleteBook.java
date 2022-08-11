package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BookDao;

public class AdminDeleteBook extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		HttpSession s=req.getSession();
		BookDao bd=new BookDao();
		boolean ans=bd.deleteBook(Integer.parseInt(req.getParameter("id")));
		if(ans) {
			req.setAttribute("succMsg","Book Delete Successfully...");
			req.getRequestDispatcher("dashboard").forward(req,res);
		}
		else {
			req.setAttribute("failMsg","Something went wrong ! ");
			req.getRequestDispatcher("addbook").forward(req,res);
		}
	}
}
