package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDao;
import com.model.Admin;
import com.dao.StudentDao;
import com.model.Student;

public class StudentSignin extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		if(req.getParameter("role").equals("admin")) {
			Admin a=new Admin();
			a.setEmail(req.getParameter("email"));
			a.setMemebershipNumber(req.getParameter("memership"));
			
			AdminDao ad=new AdminDao();
			Admin b=ad.signin(a);
			
			RequestDispatcher rd;
			HttpSession s=req.getSession();
			if(b!=null) {
				s.setAttribute("Name",b.getName());
				s.setAttribute("Id",b.getId());
				res.sendRedirect("dashboard");
			}
			else {
				req.setAttribute("failMsg","Incoreect email or passoword ! ");
				rd=req.getRequestDispatcher("commonSignin.jsp");
				rd.forward(req,res);
			}
			
		}
		else {
			Student a=new Student();
			a.setEmail(req.getParameter("email"));
			a.setMemberShipNo(req.getParameter("memership"));
			
			StudentDao ad=new StudentDao();
			Student b=ad.signin(a);
			if(b!=null) {
				HttpSession s=req.getSession();
				s.setAttribute("Name",b.getName());
				s.setAttribute("Id",b.getId());
				res.sendRedirect("studentdashboard");
			}
			else {
				req.setAttribute("failMsg","Incoreect email or passoword ! ");
				req.getRequestDispatcher("commonSignin.jsp").forward(req,res);
			}
		}
		
		
	}
}

