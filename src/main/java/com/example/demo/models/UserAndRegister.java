package com.example.demo.models;

import com.example.demo.entity.User;

public class UserAndRegister {

	private User user;
	private int countRegister;

	public UserAndRegister(User user, int countRegister) {
		super();
		this.user = user;
		this.countRegister = countRegister;
	}
	public UserAndRegister() {
		
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCountRegister() {
		return countRegister;
	}
	public void setCountRegister(int countRegister) {
		this.countRegister = countRegister;
	}
	@Override
	public String toString() {
		return "UserNameAndRegister [user=" + user + ", countRegister=" + countRegister + "]";
	}
	

}
