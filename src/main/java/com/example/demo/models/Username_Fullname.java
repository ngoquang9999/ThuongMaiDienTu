package com.example.demo.models;

public class Username_Fullname {
	private String fullname;
	private String username;
	public Username_Fullname(String fullname, String username) {
		super();
		this.fullname = fullname;
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
