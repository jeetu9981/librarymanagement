package com.model;

import java.sql.Date;

public class ExpireIssuseBooks {
	private int id;
	private String studentName;
	private int bookId;
	private String bookName;
	private Date returnDate;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "ExpireIssuseBooks [id=" + id + ", studentName=" + studentName + ", bookName=" + bookName
				+ ", returnDate=" + returnDate + ", charges=" + charges + ", image=" + image + "]";
	}
	public ExpireIssuseBooks() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public int getCharges() {
		return charges;
	}
	public void setCharges(int charges) {
		this.charges = charges;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	private int charges;
	private String image;
	public ExpireIssuseBooks(int id, String studentName, String bookName, Date returnDate, int charges, String image) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.bookName = bookName;
		this.returnDate = returnDate;
		this.charges = charges;
		this.image = image;
	}
}
