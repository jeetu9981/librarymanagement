package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.model.Book;

public class ViewDetails extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		StudentDao st=new StudentDao();
		Book b=st.getSingleBook(Integer.parseInt(req.getParameter("bookId")));
		req.setAttribute("book",b);
		req.getRequestDispatcher("BookViewDetail.jsp").forward(req,res);
	}
}
