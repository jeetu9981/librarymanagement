package com.librarymanagement.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.librarymanagement.entity.AdminEntity;
import com.librarymanagement.util.GetConnection;

public class AdminModel {
	public boolean addAdmin(AdminEntity a) {
		Connection con=GetConnection.getConnection();
		try {
			String q="insert into admin(name,email,password) values(?,?,?)";
			PreparedStatement pd=con.prepareStatement(q);
			pd.setString(1,a.getName());
			pd.setString(2, a.getEmail());
			pd.setString(3, a.getPassword());
			int i=pd.executeUpdate();
			if(i>0)
				return true;
		}
		catch(Exception e) {
			System.out.println(e);
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
	
	public boolean signup(AdminEntity a) {
		Connection con=GetConnection.getConnection();
		System.out.println(a);
		try {
			String q="update admin set address=?,libraryName=?,memeberShipNo=? where email=?";
			PreparedStatement pd=con.prepareStatement(q);
			pd.setString(1,a.getAddress());
			pd.setString(2, a.getLibraryName());
			pd.setString(3, a.getMemebershipNumber());
			pd.setString(4, a.getEmail());
			int i=pd.executeUpdate();
			if(i>0)
				return true;
		}
		catch(Exception e) {
			System.out.println(e);
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
	
	@SuppressWarnings("null")
	public AdminEntity signin(AdminEntity a) {
		AdminEntity a1=null;
		Connection con=GetConnection.getConnection();
		try {
			String q="select * from admin where email=? and memeberShipNo=?";
			PreparedStatement pd=con.prepareStatement(q);
			pd.setString(1, a.getEmail());
			pd.setString(2, a.getMemebershipNumber());
			ResultSet i=pd.executeQuery();
			if(i.next()) {
				a1=new AdminEntity();
				a1.setId(i.getInt(1));
				a1.setName(i.getString(2));
				a1.setLibraryName(i.getString(3));
				a1.setEmail(i.getString(4));
				a1.setPassword(i.getString(5));
				a1.setMemebershipNumber(i.getString(7));
				a1.setAddress(i.getString(6));
				return a1;
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return a1;
	}
}
