package com.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StudentDao;
import com.model.BookIssue;

public class StudentRenewBook extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		HttpSession s=req.getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        Calendar cal = Calendar.getInstance();  
        cal.add(Calendar.DAY_OF_MONTH, 7);  
        String dateAfter = sdf.format(cal.getTime());
        Date date=null;
        try {
			date=new SimpleDateFormat("yyyy-MM-dd").parse(dateAfter);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        StudentDao st=new StudentDao();
        boolean sta=st.studentRenewBook((int)s.getAttribute("Id"),Integer.parseInt(req.getParameter("bookId")),date);
        RequestDispatcher rd;
        if(sta) {
        	req.setAttribute("succMsg","Book Renew Successfully");
			rd=req.getRequestDispatcher("studentissuebooks");
        }
        else {
        	req.setAttribute("failMsg","Book Renew Successfully");
			rd=req.getRequestDispatcher("studentissuebooks");
        }
        rd.forward(req,res);
	}
}
