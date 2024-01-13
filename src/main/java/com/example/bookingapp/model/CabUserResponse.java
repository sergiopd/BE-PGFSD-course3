package com.example.bookingapp.model;

import java.util.List;

public class CabUserResponse {
	
	Integer code;
	String message;
	
	List<CabUser> users;
	
	CabUser	cabUser;
	
	public CabUserResponse() {
		// TODO Auto-generated constructor stub
	}

	public CabUserResponse(Integer code, String message) {
		this.code = code;
		this.message = message;
	}	

	public List<CabUser> getUsers() {
		return users;
	}

	public void setUsers(List<CabUser> users) {
		this.users = users;
	}

	public CabUserResponse(Integer code, String message, List<CabUser> users) {
		this.code = code;
		this.message = message;
		this.users = users;
	}	

	public CabUserResponse(Integer code, String message, CabUser cabUser) {
		this.code = code;
		this.message = message;
		this.cabUser = cabUser;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CabUser getCabUser() {
		return cabUser;
	}

	public void setCabUser(CabUser cabUser) {
		this.cabUser = cabUser;
	}

	@Override
	public String toString() {
		return "CabUserResponse [code=" + code + ", message=" + message + ", users=" + users + ", cabUser=" + cabUser
				+ "]";
	}
	
}
