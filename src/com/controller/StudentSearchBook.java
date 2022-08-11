package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BookDao;
import com.dao.StudentDao;
import com.model.Book;

public class StudentSearchBook extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		StudentDao bd=new StudentDao();
		ArrayList<Book> al=bd.getAllBooksByName(req.getParameter("search"));
		HttpSession se=req.getSession();
		se.setAttribute("books",al);
		req.getRequestDispatcher("SearchBook.jsp").forward(req,res);
	}
}
