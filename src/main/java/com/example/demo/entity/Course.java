package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@Column(name = "idcourse")
	private String idCourse;
	@Column(name = "namecourse")
	private String nameCourse;
	@Column(name = "cost")
	private int cost;
	@Column(name = "startingday")
	private Date startingDay;
	@Column(name = "description")
	private String description;
	@Column(name = "summary")
	private String summary;
	@Column(name = "image")
	private String image;
	
	@OneToOne
	@JoinColumn(name = "idtype", nullable = false)
	private TypeCourse typeCourse;

	@OneToOne
	@JoinColumn(name = "idstatus", nullable = false)
	private StatusCourse statusCourse;

	public Course() {

	}

	public Course(String idCourse, String nameCourse, int cost, Date startingDay, String description, String summary,
			String image, TypeCourse typeCourse, StatusCourse statusCourse) {
		super();
		this.idCourse = idCourse;
		this.nameCourse = nameCourse;
		this.cost = cost;
		this.startingDay = startingDay;
		this.description = description;
		this.summary = summary;
		this.image = image;
		this.typeCourse = typeCourse;
		this.statusCourse = statusCourse;
	}

	public String getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(String idCourse) {
		this.idCourse = idCourse;
	}

	public String getNameCourse() {
		return nameCourse;
	}

	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Date getStartingDay() {
		return startingDay;
	}

	public void setStartingDay(Date startingDay) {
		this.startingDay = startingDay;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	

	public TypeCourse getTypeCourse() {
		return typeCourse;
	}

	public void setTypeCourse(TypeCourse typeCourse) {
		this.typeCourse = typeCourse;
	}

	public StatusCourse getStatusCourse() {
		return statusCourse;
	}

	public void setStatusCourse(StatusCourse statusCourse) {
		this.statusCourse = statusCourse;
	}

	@Override
	public String toString() {
		return "Course [idCourse=" + idCourse + ", nameCourse=" + nameCourse + ", cost=" + cost + ", startingDay="
				+ startingDay + ", description=" + description + ", summary=" + summary + ", image=" + image
				+ ", typeCourse=" + typeCourse.getNameType() + ", statusCourse=" + statusCourse.getNameStatus() + "]";
	}

	
}
