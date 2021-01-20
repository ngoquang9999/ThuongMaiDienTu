package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "ratecourse")
public class RateCourse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 856228268484022312L;
	@Id
	@Column(name = "idrate", length = 250)
	private	String idRate;
	@Column(name = "numstar")
	private int numStar;
	@Column(name = "content")
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "iduser")
	User user;
	
	@ManyToOne
	@JoinColumn(name = "idcourse")
	private Course course;
	
	
	public RateCourse() {
		
	}
	
	

	public String getIdRate() {
		return idRate;
	}



	public void setIdRate(String idRate) {
		this.idRate = idRate;
	}



	public int getNumStar() {
		return numStar;
	}



	public void setNumStar(int numStar) {
		this.numStar = numStar;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Course getCourse() {
		return course;
	}



	public void setCourse(Course course) {
		this.course = course;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public RateCourse(String idRate, int numStar, String content, User user, Course course) {
		super();
		this.idRate = idRate;
		this.numStar = numStar;
		this.content = content;
		this.user = user;
		this.course = course;
	}



	@Override
	public String toString() {
		return "Rate [idRate=" + idRate + ", numStar=" + numStar + ", content=" + content + "]";
	}
	

}
