package com.example.demo.models;

import java.sql.Timestamp;

public class RateModel {
	private String fullname;
	private int numstar;
	private String content;
	public RateModel(String fullname, int numstar, String content) {
		super();
		this.fullname = fullname;
		this.numstar = numstar;
		this.content = content;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public int getNumstar() {
		return numstar;
	}
	public void setNumstar(int numstar) {
		this.numstar = numstar;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
