package com.controller;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.AdminDao;
import com.model.Admin;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.*;

public class AdminSignup extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		Random r=new Random();
		int y = r.nextInt(10000);
		Admin a=new Admin();
		a.setAddress(req.getParameter("address"));
		a.setLibraryName(req.getParameter("libraryName"));
		a.setMemebershipNumber("A"+y);
		String m="A"+y;
		a.setEmail(req.getParameter("email"));
		
		AdminDao ad=new AdminDao();
		boolean b=ad.signup(a);
		if(b){
			String msg="Your Registration Success and Your Membership Number Is : "+m;
			String subject="Registration Success Message.";
			String to=req.getParameter("email");
			String from="pjeetu311@gmail.com";
			
			boolean ba=sendEmail(msg,subject,to,from);
			if(ba) {
				res.sendRedirect("commonSignin.jsp");
			}
			else {
				req.setAttribute("failMsg","Something went wrong ! ");
				req.getRequestDispatcher("commonSignin.jsp").forward(req,res);
			}
		}
	}
	
	public static boolean sendEmail(String msg,String subject,String to,String from) {
		Properties p=System.getProperties();
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "465");// 465 is default port number of g
		p.put("mail.smtp.ssl.enable", true);
		p.put("mail.smtp.auth", true);
		
		Session session=Session.getInstance(p,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("pjeetu311@gmail.com", "yoorgpdhmehatabs");
			}
		});
		session.setDebug(true);
		
		try {
			MimeMessage m = new MimeMessage(session); 
			m.setFrom(new InternetAddress(from)); 
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);
			m.setText(msg); 
			Transport.send(m);
			System.out.println("Success Fully Send");
			return true;
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	    
	}
}
