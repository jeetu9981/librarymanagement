package com.model;

public class Student {
	private int id;
	private String name;
	private String email;
	private String password;
	private String memberShipNo;
	public Student(int id, String name, String email, String password, String memberShipNo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.memberShipNo = memberShipNo;
	}
	public Student(String name, String email, String password, String memberShipNo) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.memberShipNo = memberShipNo;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", memberShipNo=" + memberShipNo + "]";
	}
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
	public String getMemberShipNo() {
		return memberShipNo;
	}
	public void setMemberShipNo(String memberShipNo) {
		this.memberShipNo = memberShipNo;
	}
	
}
