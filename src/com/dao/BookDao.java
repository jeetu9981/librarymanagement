package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Book;
import com.model.ExpireIssuseBooks;
import com.model.Student;
import com.util.GetConnection;

public class BookDao {
	public boolean addBook(Book b) {
		Connection con=GetConnection.getConnection();
		try {
			String q="insert into books(bookName,authorName,edition,quantity,image,description,isDelete,adminId) values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getAuthorName());
			ps.setString(3, b.getEdition());
			ps.setInt(4, b.getQuantity());
			ps.setString(5, b.getImage());
			ps.setString(6, b.getDescription());
			ps.setBoolean(7,false);
			ps.setInt(8,b.getAdminId());
			int i=ps.executeUpdate();
			if(i>0)
				return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public ArrayList<Book> getAllBooks(int id){
		ArrayList<Book> books=new ArrayList<Book>();
		Connection con=GetConnection.getConnection();
		try {
			String q="select * from books where adminId=? and isDelete=false";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Book b=new Book();
				b.setId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthorName(rs.getString(3));
				b.setEdition(rs.getString(4));
				b.setQuantity(rs.getInt(5));
				b.setImage(rs.getString(6));
				b.setDescription(rs.getString(7));
				b.setDelete(rs.getBoolean(8));
				b.setAdminId(rs.getInt(9));
				books.add(b);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return books;
	}
	
	public boolean deleteBook(int id) {
		Connection con=GetConnection.getConnection();
		try {
			String q="update books set isDelete=? where id=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setBoolean(1, true);
			ps.setInt(2, id);
			int i=ps.executeUpdate();
			if(i>0)
				return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public ArrayList<Book> allDeleteBooks(int id){
		ArrayList<Book> books=new ArrayList<Book>();
		Connection con=GetConnection.getConnection();
		try {
			String q="select * from books where adminId=? and isDelete=true";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Book b=new Book();
				b.setId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthorName(rs.getString(3));
				b.setEdition(rs.getString(4));
				b.setQuantity(rs.getInt(5));
				b.setImage(rs.getString(6));
				b.setDescription(rs.getString(7));
				b.setDelete(rs.getBoolean(8));
				b.setAdminId(rs.getInt(9));
				books.add(b);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return books;
	}
	
	public boolean renewBook(Book b){
		Connection con=GetConnection.getConnection();
		try {
			String q="update books set description=?,quantity=?,isDelete=false where id=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, b.getDescription());
			ps.setInt(2, b.getQuantity());
			ps.setInt(3, b.getId());
			int i=ps.executeUpdate();
			if(i>0)
				return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean editBook(int id,String desc){
		Connection con=GetConnection.getConnection();
		try {
			String q="update books set description=? where id=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, desc);
			ps.setInt(2, id);
			int i=ps.executeUpdate();
			if(i>0)
				return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public ArrayList<Student> getIssueBooks(int bookId) {
		ArrayList<Student> stud=new ArrayList<Student>();
		Connection con=GetConnection.getConnection();
		try {
			String q="select s.name,s.email from student s inner join bookissue b on b.bookId=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, bookId);
			ResultSet i=ps.executeQuery();
			while(i.next()){
				Student s=new Student();
				s.setName(i.getString(1));
				s.setEmail(i.getString(2));
				stud.add(s);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return stud;
	}
	
	public ArrayList<ExpireIssuseBooks> expireNooks(int adminId){
		ArrayList<ExpireIssuseBooks> al=new ArrayList<ExpireIssuseBooks>();
		Connection con=GetConnection.getConnection();
		try {
			String q="select b.bookName,bi.returnDate,bi.charges,b.image,b.id,bi.studentId,s.name,s.email,b.id from books b inner join admin on admin.id=? inner "
					+ "join bookissue bi on bi.bookId=b.id inner join student s on bi.studentId=s.id where returnDate<now() and isReturn=false";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, adminId);
			ResultSet i=ps.executeQuery();
			while(i.next()){
				ExpireIssuseBooks s=new ExpireIssuseBooks();
				s.setBookName(i.getString(1));
				s.setReturnDate(i.getDate(2));
				s.setCharges(i.getInt(3));
				s.setImage(i.getString(4));
				s.setStudentName(i.getString(7));
				s.setEmail(i.getString(8));
				s.setBookId(i.getInt(9));
				al.add(s);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return al;
	}
}
