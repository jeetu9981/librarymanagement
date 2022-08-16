package com.librarymanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.librarymanagement.entity.AdminEntity;
import com.librarymanagement.entity.StudentEntity;
import com.librarymanagement.model.AdminModel;
import com.librarymanagement.model.StudentModel;

public class StudentSignin extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		if(req.getParameter("role").equals("admin")) {
			AdminEntity a=new AdminEntity();
			a.setEmail(req.getParameter("email"));
			a.setMemebershipNumber(req.getParameter("memership"));
			
			AdminModel ad=new AdminModel();
			AdminEntity b=ad.signin(a);
			
			RequestDispatcher rd;
			System.out.println(b);
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
			StudentEntity a=new StudentEntity();
			a.setEmail(req.getParameter("email"));
			a.setMemberShipNo(req.getParameter("memership"));
			
			StudentModel ad=new StudentModel();
			StudentEntity b=ad.signin(a);
			if(b.getName()!=null) {
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

