package com.librarymanagement.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.librarymanagement.entity.BookEntity;
import com.librarymanagement.model.BookModel;

public class AdminDashboard extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		HttpSession s=req.getSession();
		req.setAttribute("succMsg", req.getAttribute("succMsg"));
		req.setAttribute("failMsg", req.getAttribute("failMsg"));
		int id=(int)s.getAttribute("Id");
		BookModel bd=new BookModel();
		ArrayList<BookEntity> al=bd.getAllBooks(id);
		s.setAttribute("books",al);
		req.getRequestDispatcher("Dashboard.jsp").forward(req,res);
	}
}
