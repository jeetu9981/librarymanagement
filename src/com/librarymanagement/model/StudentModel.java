package com.librarymanagement.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.librarymanagement.controller.StudentIssueBook;
import com.librarymanagement.entity.BookEntity;
import com.librarymanagement.entity.BookIssueEntity;
import com.librarymanagement.entity.ExpireIssuseBooksEntity;
import com.librarymanagement.entity.StudentEntity;
import com.librarymanagement.util.GetConnection;

public class StudentModel {
	public boolean signup(StudentEntity s) {
		Connection con=GetConnection.getConnection();
		try {
			String q="insert into student(name,email,password,memberShip) values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1,s.getName());
			ps.setString(2,s.getEmail());
			ps.setString(3,s.getPassword());
			ps.setString(4,s.getMemberShipNo());
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
	
	public StudentEntity signin(StudentEntity s) {
		StudentEntity s1=null;
		Connection con=GetConnection.getConnection();
		try {
			s1=new StudentEntity();
			String q="select * from student where email=? and memberShip=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1,s.getEmail());
			ps.setString(2,s.getMemberShipNo());
			ResultSet i=ps.executeQuery();
			if(i.next()){
				s1.setId(i.getInt(1));
				s1.setName(i.getString(2));
				s1.setEmail(i.getString(3));
				s1.setPassword(i.getString(4));
				s1.setMemberShipNo(i.getString(5));
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
		return s1;
	}
	
	public ArrayList<BookEntity> getAllBooks(){
		Connection con=GetConnection.getConnection();
		ArrayList<BookEntity> books=new ArrayList<BookEntity>();
		try {
			String q="select * from books where isDelete=false and quantity>0";
			PreparedStatement ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				BookEntity b=new BookEntity();
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
	
	public boolean bookIssue(BookIssueEntity ib){
		Connection con=GetConnection.getConnection();
		try {
			String q="insert into bookissue(studentId,bookId,charges,isReturn,returnDate) values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, ib.getStudentId());
			ps.setInt(2, ib.getBookId());
			ps.setInt(3, ib.getCharges());
			ps.setBoolean(4, ib.isReturn());
			java.sql.Date sqlPackageDate= new java.sql.Date(ib.getReturnDate().getTime());
			ps.setDate(5, sqlPackageDate);
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
	
	public boolean updateQuantity(int bookId) {
		Connection con=GetConnection.getConnection();
		try {
			String q="update books set quantity=quantity-1 where id=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, bookId);
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
	
	public ArrayList<ExpireIssuseBooksEntity> getAllIssueBooks(int studentId) {
		ArrayList<ExpireIssuseBooksEntity> al=new ArrayList<ExpireIssuseBooksEntity>();
		Connection con=GetConnection.getConnection();
		try {
			String q="select b.bookName,bi.returnDate,bi.charges,b.image,b.id from books b inner join bookissue bi on bi.bookId=b.id where studentId=? and isReturn=false and now()<bi.returnDate;";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, studentId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ExpireIssuseBooksEntity e=new ExpireIssuseBooksEntity();
				e.setBookName(rs.getString(1));
				e.setReturnDate(rs.getDate(2));
				e.setCharges(rs.getInt(3));
				e.setImage(rs.getString(4));
				e.setBookId(rs.getInt(5));
				al.add(e);
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
	
	public boolean returnBook(int bookId,int studentId){
		Connection con=GetConnection.getConnection();
		try {
			String q="delete from bookissue where bookId=? and studentId=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(2, studentId);
			ps.setInt(1, bookId);
			int row=ps.executeUpdate();
			if(row>0)
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
	
	public boolean increaseQuantity(int bookId) {
		Connection con=GetConnection.getConnection();
		try {
			String q="update books set quantity=quantity+1 where id=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, bookId);
			int row=ps.executeUpdate();
			if(row>0)
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
	
	public boolean studentRenewBook(int studentId,int bookId,java.util.Date date){
		java.sql.Date sqlPackageDate= new java.sql.Date(date.getTime());
		Connection con=GetConnection.getConnection();
		try {
			String q="update bookissue set returnDate=? where studentId=? and bookId=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setDate(1,sqlPackageDate);
			ps.setInt(2, studentId);
			ps.setInt(3,bookId);
			int row=ps.executeUpdate();
			if(row>0)
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
	
	public boolean checkIssuOrNot(int bookId,int studentId){
		
		Connection con=GetConnection.getConnection();
		try {
			String q="select * from bookIssue where studentId=? and bookId=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, studentId);
			ps.setInt(2,bookId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
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
	
	public ArrayList<BookEntity> getAllBooksByName(String name){
		Connection con=GetConnection.getConnection();
		ArrayList<BookEntity> books=new ArrayList<BookEntity>();
		try {
			String q="select * from books where bookName like '%"+name+"%';";
			PreparedStatement ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				BookEntity b=new BookEntity();
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
	
	public BookEntity getSingleBook(int id){
		Connection con=GetConnection.getConnection();
		BookEntity b=null;
		try {
			String q="select * from books where id=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				b=new BookEntity();
				b.setId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthorName(rs.getString(3));
				b.setEdition(rs.getString(4));
				b.setQuantity(rs.getInt(5));
				b.setImage(rs.getString(6));
				b.setDescription(rs.getString(7));
				b.setDelete(rs.getBoolean(8));
				b.setAdminId(rs.getInt(9));
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
		return b;
	}
}

