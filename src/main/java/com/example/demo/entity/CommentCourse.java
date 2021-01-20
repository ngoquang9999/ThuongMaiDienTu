package com.example.demo.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commentcourse")
public class CommentCourse {

	/**
	 * 
	 */
//	private static final long serialVersionUID = 1819432078324095925L;
	@Id
	@Column(name = "idcomment", length = 250)
	private String idCommnent;
	@Column(name = "content")
	private String content;
	@Column(name = "datetime")
	private Timestamp datetime;
	@ManyToOne
	@JoinColumn(name = "iduser")
	User user;
	@OneToOne
	@JoinColumn(name = "idcourse")
	Course course;

	public CommentCourse() {
	}

	public CommentCourse(String idCommnent, String content, Timestamp datetime, User user, Course course) {
		super();
		this.idCommnent = idCommnent;
		this.content = content;
		this.datetime = datetime;
		this.user = user;
		this.course = course;
	}
	
	public boolean checkSameUserName(String userName, CommentCourse commentCourse) {
		boolean same = userName.equalsIgnoreCase(commentCourse.getUser().getUsername()) ? true : false;
		return same;
	}

	public String getIdCommnent() {
		return idCommnent;
	}

	public void setIdCommnent(String idCommnent) {
		this.idCommnent = idCommnent;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
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

	@Override
	public String toString() {
		return "Comment [idCommnent=" + idCommnent + ", content=" + content + "]";
	}

}
