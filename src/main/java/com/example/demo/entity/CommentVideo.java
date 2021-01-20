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
@Table(name = "commentvideo")
public class CommentVideo {

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
	@JoinColumn(name = "idvideo")
	Video video;

	public CommentVideo() {
	}
	
	public boolean checkSameUserName(String userName, CommentVideo commentVideo) {
		boolean same = userName.equalsIgnoreCase(commentVideo.getUser().getUsername()) ? true : false;
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

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public CommentVideo(String idCommnent, String content, Timestamp datetime, User user, Video video) {
		super();
		this.idCommnent = idCommnent;
		this.content = content;
		this.datetime = datetime;
		this.user = user;
		this.video = video;
	}

	@Override
	public String toString() {
		return "CommentVideo [idCommnent=" + idCommnent + ", content=" + content + ", datetime=" + datetime + ", user="
				+ user + ", video=" + video + "]";
	}

}
