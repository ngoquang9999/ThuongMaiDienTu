package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "schedule")
public class Schedule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4305371926079559981L;
	@Id
	@Column(name = "idschedule", length = 250)
	private String idSchedule;
	@Column(name = "position")
	private String position;
	@Column(name = "daysofweek")
	private String daysOfWeek;
	
	@ManyToOne
	@JoinColumn(name = "iduser")
	User user;

	@OneToOne
	@JoinColumn(name = "idcourse")
	Course course;
	
	
	public Schedule() {
		
	}
	
	

	public String getIdSchedule() {
		return idSchedule;
	}



	public void setIdSchedule(String idSchedule) {
		this.idSchedule = idSchedule;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public String getDaysOfWeek() {
		return daysOfWeek;
	}



	public void setDaysOfWeek(String daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
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



	public Schedule(String idSchedule, String position, String daysOfWeek, User user, Course course) {
		super();
		this.idSchedule = idSchedule;
		this.position = position;
		this.daysOfWeek = daysOfWeek;
		this.user = user;
		this.course = course;
	}



	@Override
	public String toString() {
		return "Schedule [idSchedule=" + idSchedule + ", position=" + position + ", daysOfWeek=" + daysOfWeek + "]";
	}
	
	
	
	

}
