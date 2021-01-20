package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "video")
public class Video {

	/**
	 * 
	 */

	@Id
	@Column(name="idvideo")
	
	String idVideo;
	@Column(name="namevideo")
	 String nameVideo;
	@Column(name="link")
	 String link;
	@Column(name="image")
	String image;
	@Column(name="type")
	String type;
	@Column(name="view")
	int view;
	@ManyToOne
	@JoinColumn(name="idcourse")
	 Course course;
	@ManyToOne
	@JoinColumn(name="iduser")
	 User user;

	public Video() {
	}

	public Video(String idVideo, String nameVideo, String link, String image, String type, int view, Course course,
			User user) {
		super();
		this.idVideo = idVideo;
		this.nameVideo = nameVideo;
		this.link = link;
		this.image = image;
		this.type = type;
		this.view = view;
		this.course = course;
		this.user = user;
	}

	public String getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(String idVideo) {
		this.idVideo = idVideo;
	}

	public String getNameVideo() {
		return nameVideo;
	}

	public void setNameVideo(String nameVideo) {
		this.nameVideo = nameVideo;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
