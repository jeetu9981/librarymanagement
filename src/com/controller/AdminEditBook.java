package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BookDao;

public class AdminEditBook extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		BookDao bd=new BookDao();
		boolean b=bd.editBook(Integer.parseInt(req.getParameter("id")),req.getParameter("description"));
		if(b) {
			req.setAttribute("succMsg","Edit Added Successfully...");
			req.getRequestDispatcher("dashboard").forward(req,res);
		}
		else {
			req.setAttribute("failMsg","Something went wrong ! ");
			req.getRequestDispatcher("addbook").forward(req,res);
		}
	}
}
