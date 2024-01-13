package com.example.bookingapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CabUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer userID;
	
	String userName;
	String phone;
	String email;
	String userPassword;
	
	public CabUser() {
		// TODO Auto-generated constructor stub
	}

	public CabUser(Integer userID, String userName, String phone, String email, String userPassword) {
		this.userID = userID;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.userPassword = userPassword;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "CabUser [userID=" + userID + ", userName=" + userName + ", phone=" + phone + ", email=" + email
				+ ", userPassword=" + userPassword + "]";
	}

}
