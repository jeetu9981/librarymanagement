package com.model;

import java.util.Date;

public class BookIssue {
	private int id;
	private int studentId;
	private int bookId;
	private Date returnDate;
	private int charges;
	private boolean isReturn;
	@Override
	public String toString() {
		return "BookIssue [id=" + id + ", studentId=" + studentId + ", bookId=" + bookId + ", returnDate=" + returnDate
				+ ", charges=" + charges + ", isReturn=" + isReturn + "]";
	}
	public BookIssue() {
		super();
	}
	public BookIssue(int studentId, int bookId, Date returnDate, int charges, boolean isReturn) {
		super();
		this.studentId = studentId;
		this.bookId = bookId;
		this.returnDate = returnDate;
		this.charges = charges;
		this.isReturn = isReturn;
	}
	public BookIssue(int id, int studentId, int bookId, Date returnDate, int charges, boolean isReturn) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.bookId = bookId;
		this.returnDate = returnDate;
		this.charges = charges;
		this.isReturn = isReturn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
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
	public boolean isReturn() {
		return isReturn;
	}
	public void setReturn(boolean isReturn) {
		this.isReturn = isReturn;
	}
}
