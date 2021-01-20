package com.example.demo.models;

import java.sql.Date;

public class UserRegisterForm {
	private String accountname;
	private String password;
	private String fullname;
	private Date date;
	private String sex;
	private String email;
	private String phonenumber;
	private String address;
	private String avatar;
	private String diploma;
	private String biography;

	public UserRegisterForm() {

	}

	public UserRegisterForm(String accountname, String password, String fullname, Date date, String sex, String email,
			String phonenumber, String address, String avatar, String diploma, String biography) {
		super();
		this.accountname = accountname;
		this.password = password;
		this.fullname = fullname;
		this.date = date;
		this.sex = sex;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
		this.avatar = avatar;
		this.diploma = diploma;
		this.biography = biography;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getDiploma() {
		return diploma;
	}

	public void setDiploma(String diploma) {
		this.diploma = diploma;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	
}
