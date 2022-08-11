package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDao;
import com.model.Student;

public class AdminBookIssueUser extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		BookDao bd=new BookDao();
		ArrayList<Student> s=bd.getIssueBooks(Integer.parseInt(req.getParameter("bookId")));
		req.setAttribute("students", s);
		RequestDispatcher rd=req.getRequestDispatcher("BookIssueuser.jsp");
		rd.forward(req, res);
	}
}
