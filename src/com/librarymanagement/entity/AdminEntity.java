package com.librarymanagement.entity;

public class AdminEntity {
	private int id;
	private String name;
	private String libraryName;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemebershipNumber() {
		return memebershipNumber;
	}
	public void setMemebershipNumber(String memebershipNumber) {
		this.memebershipNumber = memebershipNumber;
	}
	public AdminEntity(String name, String libraryName, String address, String email, String password,
			String memebershipNumber) {
		super();
		this.name = name;
		this.libraryName = libraryName;
		this.address = address;
		this.email = email;
		this.password = password;
		this.memebershipNumber = memebershipNumber;
	}
	public AdminEntity() {
		super();
	}
	public AdminEntity(int id, String name, String libraryName, String address, String email, String password,
			String memebershipNumber) {
		super();
		this.id = id;
		this.name = name;
		this.libraryName = libraryName;
		this.address = address;
		this.email = email;
		this.password = password;
		this.memebershipNumber = memebershipNumber;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", libraryName=" + libraryName + ", address=" + address
				+ ", email=" + email + ", password=" + password + ", memebershipNumber=" + memebershipNumber + "]";
	}
	private String email;
	private String password;
	private String memebershipNumber;
}
