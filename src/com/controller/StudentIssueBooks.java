package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.ExpireIssuseBooks;
import com.dao.StudentDao;

public class StudentIssueBooks extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		StudentDao s=new StudentDao();
		HttpSession session=req.getSession();
		
		ArrayList<ExpireIssuseBooks> al=s.getAllIssueBooks((int)session.getAttribute("Id"));
		req.setAttribute("books",al);
		RequestDispatcher rd=req.getRequestDispatcher("StudentIssueBooks.jsp");
		rd.forward(req,res);
	}
}
