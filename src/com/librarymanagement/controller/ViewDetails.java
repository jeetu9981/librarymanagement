package com.librarymanagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.librarymanagement.entity.BookEntity;
import com.librarymanagement.model.StudentModel;

public class ViewDetails extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		StudentModel st=new StudentModel();
		BookEntity b=st.getSingleBook(Integer.parseInt(req.getParameter("bookId")));
		req.setAttribute("book",b);
		req.getRequestDispatcher("BookViewDetail.jsp").forward(req,res);
	}
}
