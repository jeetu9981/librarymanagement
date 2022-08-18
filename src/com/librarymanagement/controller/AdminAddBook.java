package com.librarymanagement.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.librarymanagement.entity.BookEntity;
import com.librarymanagement.model.BookModel;

@MultipartConfig
public class AdminAddBook extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		HttpSession session=req.getSession();
		
		//Part we use for get image
		Part p=req.getPart("image");
		
		//with part object we get file name
		String fileName=p.getSubmittedFileName().trim();
		
		//we get file path in inputstream and write that file in other path from where it can be accessible by our application
		InputStream is=p.getInputStream();
		String path="C:\\Users\\DELL\\Documents\\workspace-sts-3.9.10.RELEASE\\library_management\\WebContent\\img\\"+fileName;
		int bytes=0;
		FileOutputStream fs=new FileOutputStream(path);
		while((bytes=is.read())!=-1)
			fs.write(bytes);
		fs.close();
		
		//here we get all data which comes from view and set into entity
		BookEntity b=new BookEntity();
		b.setBookName(req.getParameter("name"));
		b.setAuthorName(req.getParameter("authorName"));
		b.setAdminId((int)session.getAttribute("Id"));
		b.setDescription(req.getParameter("description"));
		b.setEdition(req.getParameter("edition"));
		b.setDelete(false);
		b.setImage(fileName);
		b.setQuantity(Integer.parseInt(req.getParameter("quantity")));
		
		//create model object and pass bookentity for save that entity into database
		BookModel bd=new BookModel();
		boolean ans=bd.addBook(b);
		if(ans) {
			res.sendRedirect("dashboard");
		}
		else {
			req.setAttribute("failMsg","Something went wrong ! ");
			req.getRequestDispatcher("addbook").forward(req,res);
		}
	}
}
