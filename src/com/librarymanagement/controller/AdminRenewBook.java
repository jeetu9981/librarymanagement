package com.librarymanagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.librarymanagement.entity.BookEntity;
import com.librarymanagement.model.BookModel;

public class AdminRenewBook extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		BookModel bd=new BookModel();
		BookEntity b=new BookEntity();
		b.setId(Integer.parseInt(req.getParameter("newId")));
		b.setQuantity(Integer.parseInt(req.getParameter("quantity")));
		b.setDescription(req.getParameter("description"));
		boolean ans=bd.renewBook(b);
		if(ans) {
			req.setAttribute("succMsg","Book Renew Successfully...");
			req.getRequestDispatcher("dashboard").forward(req,res);
		}
		else {
			req.setAttribute("failMsg","Something went wrong ! ");
			req.getRequestDispatcher("addbook").forward(req,res);
		}
	}
}
