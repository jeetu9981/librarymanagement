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
import com.librarymanagement.model.StudentModel;

public class StudentSearchBook extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		StudentModel bd=new StudentModel();
		ArrayList<BookEntity> al=bd.getAllBooksByName(req.getParameter("search"));
		HttpSession se=req.getSession();
		se.setAttribute("books",al);
//		System.out.println(al);
		req.getRequestDispatcher("SearchBook.jsp").forward(req,res);
//		res.sendRedirect("SearchBook.jsp");
	}
}
