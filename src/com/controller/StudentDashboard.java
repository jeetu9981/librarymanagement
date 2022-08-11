package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Book;
import com.dao.StudentDao;

public class StudentDashboard extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		StudentDao bd=new StudentDao();
		req.setAttribute("succMsg", req.getAttribute("succMsg"));
		req.setAttribute("failMsg", req.getAttribute("failMsg"));
		ArrayList<Book> al=bd.getAllBooks();
		HttpSession se=req.getSession();
		se.setAttribute("books",al);
		req.getRequestDispatcher("StudentDashBoard.jsp").forward(req,res);
	}
}
