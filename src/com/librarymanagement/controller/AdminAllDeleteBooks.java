package com.librarymanagement.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.librarymanagement.entity.BookEntity;
import com.librarymanagement.model.BookModel;

public class AdminAllDeleteBooks extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		HttpSession s=req.getSession();
		BookModel bd=new BookModel();
		ArrayList<BookEntity> al=bd.allDeleteBooks((int)s.getAttribute("Id"));
		s.setAttribute("books",al);
		if(al!=null) {
			req.getRequestDispatcher("AllDeleteBooks.jsp").forward(req,res);
		}
		else {
			req.setAttribute("failMsg","Something went wrong ! ");
			req.getRequestDispatcher("AllDeleteBooks.jsp").forward(req,res);
		}
	}
}
