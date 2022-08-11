package com.model;

public class Book {
	private int id;
	private String bookName;
	private String authorName;
	private String edition;
	private String description;
	private String image;
	private boolean isDelete;
	private int adminId;
	private int quantity;
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", authorName=" + authorName + ", edition=" + edition
				+ ", description=" + description + ", image=" + image + ", isDelete=" + isDelete + ", adminId="
				+ adminId + ", quantity=" + quantity + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Book() {
		super();
	}
	public Book(String bookName, String authorName, String edition, String description, String image, boolean isDelete,
			int adminId, int quantity) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
		this.edition = edition;
		this.description = description;
		this.image = image;
		this.isDelete = isDelete;
		this.adminId = adminId;
		this.quantity = quantity;
	}
	public Book(int id, String bookName, String authorName, String edition, String description, String image,
			boolean isDelete, int adminId, int quantity) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.authorName = authorName;
		this.edition = edition;
		this.description = description;
		this.image = image;
		this.isDelete = isDelete;
		this.adminId = adminId;
		this.quantity = quantity;
	}
}
