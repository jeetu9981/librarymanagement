package com.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminSendMail extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String msg=req.getParameter("msg");
		String subject=req.getParameter("subject");
		String to=req.getParameter("email");
		String from=req.getParameter("email");
		
		boolean ba=sendEmail(msg,subject,to,from);
		if(ba) {
			req.setAttribute("succMsg","Mail Sent Successfully...");
			req.getRequestDispatcher("expireIssuebook").forward(req,res);
		}
		else {
			req.setAttribute("failMsg","Something went wrong ! ");
			req.getRequestDispatcher("expireIssuebook").forward(req,res);
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
