package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	private String iduser;
	private String username;
	private String password;
	private String status;

	@OneToOne
	@JoinColumn(name = "iduserinfo")
	Userinfo userInfo;

	public User() {

	}

	public String getIduser() {
		return iduser;
	}

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Userinfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(Userinfo userInfo) {
		this.userInfo = userInfo;
	}

	public User(String iduser, String username, String password, String idlevel, String status, Userinfo userInfo) {
		super();
		this.iduser = iduser;
		this.username = username;
		this.password = password;
		this.status = status;
		this.userInfo = userInfo;
	}

}
