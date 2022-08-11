package com.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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

public class StudentIssueBook extends HttpServlet{
	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		StudentDao sd=new StudentDao();
		HttpSession hs=req.getSession();
		
		BookIssue bi=new BookIssue();
		bi.setStudentId((int)hs.getAttribute("Id"));
		bi.setBookId(Integer.parseInt(req.getParameter("bookId")));
		bi.setReturn(false);
		bi.setCharges(0);
		
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        Calendar cal = Calendar.getInstance();  
        cal.add(Calendar.DAY_OF_MONTH, 7);  
        String dateAfter = sdf.format(cal.getTime());
        try {
			Date date=new SimpleDateFormat("yyyy-MM-dd").parse(dateAfter);
			bi.setReturnDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        boolean status=sd.bookIssue(bi);
        if(status){
        	status=sd.updateQuantity(bi.getBookId());
        	if(status) {
    			RequestDispatcher rd=rd=req.getRequestDispatcher("studentissuebooks");
    			req.setAttribute("succMsg","Book Issued Successfully");
    			rd.forward(req,res);
    		}
        	else {
        		RequestDispatcher rd=rd=req.getRequestDispatcher("studentissuebooks");
    			req.setAttribute("failMsg","Something went wrong !");
    			rd.forward(req,res);
        	}
        }
	}
}
