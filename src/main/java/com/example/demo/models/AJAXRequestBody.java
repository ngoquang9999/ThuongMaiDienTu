package com.example.demo.models;

import org.springframework.web.multipart.MultipartFile;

public class AJAXRequestBody {

	String id;
	String idCourse;
	String idComment;
	String idVideo;
	String username;
	String password;
	String status;
	String idCmtToRep;
	String content;
	String rate;
	String datetime;
	String phone;
	String email;
	String address;
	String fullname;
	String idAddressOld;
	String idAddressNew;
	String text;
	MultipartFile file;
	
	

	public String getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(String idVideo) {
		this.idVideo = idVideo;
	}

	public String getIdComment() {
		return idComment;
	}

	public void setIdComment(String idComment) {
		this.idComment = idComment;
	}

	public String getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(String idCourse) {
		this.idCourse = idCourse;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getIdCmtToRep() {
		return idCmtToRep;
	}

	public void setIdCmtToRep(String idCmtToRep) {
		this.idCmtToRep = idCmtToRep;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdAddressOld() {
		return idAddressOld;
	}

	public void setIdAddressOld(String idAddressOld) {
		this.idAddressOld = idAddressOld;
	}

	public String getIdAddressNew() {
		return idAddressNew;
	}

	public void setIdAddressNew(String idAddressNew) {
		this.idAddressNew = idAddressNew;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
