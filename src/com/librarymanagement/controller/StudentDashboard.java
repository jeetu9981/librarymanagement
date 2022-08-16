package com.librarymanagement.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.librarymanagement.entity.BookEntity;
import com.librarymanagement.model.StudentModel;

public class StudentDashboard extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		StudentModel bd=new StudentModel();
		req.setAttribute("succMsg", req.getAttribute("succMsg"));
		req.setAttribute("failMsg", req.getAttribute("failMsg"));
		ArrayList<BookEntity> al=bd.getAllBooks();
		HttpSession se=req.getSession();
		se.setAttribute("books",al);
		req.getRequestDispatcher("StudentDashBoard.jsp").forward(req,res);
	}
}
