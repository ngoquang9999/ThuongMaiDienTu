package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userinfo")
public class Userinfo {
	@Id
	private String iduserinfo;
	private String fullname;
	private Date date;
	private String sex;
	private String avatar;
	private String position;
	private String gmail;
	private String phonenumber;
	private String address;
	private String diploma;
	private String biography;

	public Userinfo() {

	}

	public Userinfo(String iduserinfo, String fullname, Date date, String sex, String avatar, String position,
			String gmail, String phonenumber, String address, String diploma, String biography) {
		super();
		this.iduserinfo = iduserinfo;
		this.fullname = fullname;
		this.date = date;
		this.sex = sex;
		this.avatar = avatar;
		this.position = position;
		this.gmail = gmail;
		this.phonenumber = phonenumber;
		this.address = address;
		this.diploma = diploma;
		this.biography = biography;
	}

	public String getIduserinfo() {
		return iduserinfo;
	}

	public void setIduserinfo(String iduserinfo) {
		this.iduserinfo = iduserinfo;
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
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
