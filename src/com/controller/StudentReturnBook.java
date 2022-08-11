package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StudentDao;

public class StudentReturnBook extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		HttpSession session=req.getSession();
		StudentDao st=new StudentDao();
		boolean b=st.returnBook(Integer.parseInt(req.getParameter("bookId")),(int)session.getAttribute("Id"));
		RequestDispatcher rd;
		if(b) {
			b=st.increaseQuantity(Integer.parseInt(req.getParameter("bookId")));
			if(b) {
				req.setAttribute("succMsg","Book Return Successfully");
				rd=req.getRequestDispatcher("studentissuebooks");
			}
			else {
				req.setAttribute("failMsg","Something went wrong !");
				rd=req.getRequestDispatcher("studentissuebooks");
			}
			rd.forward(req,res);
		}	
	}
}
