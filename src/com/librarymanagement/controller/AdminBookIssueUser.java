package com.librarymanagement.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.librarymanagement.entity.StudentEntity;
import com.librarymanagement.model.BookModel;

public class AdminBookIssueUser extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		BookModel bd=new BookModel();
		ArrayList<StudentEntity> s=bd.getIssueBooks(Integer.parseInt(req.getParameter("bookId")));
		req.setAttribute("students", s);
		RequestDispatcher rd=req.getRequestDispatcher("BookIssueuser.jsp");
		rd.forward(req, res);
	}
}
