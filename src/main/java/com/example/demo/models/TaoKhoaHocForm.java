package com.example.demo.models;

import java.sql.Date;

public class TaoKhoaHocForm {
	private String nameCourse;
	private int cost;
	private String description;
	private String summary;
	private String imageLink;
	private Date dateStart;
	private String type;

	public TaoKhoaHocForm() {

	}

	public TaoKhoaHocForm(String nameCourse, int cost, String description, String summary, String imageLink,
			Date dateStart, String type) {
		super();
		this.nameCourse = nameCourse;
		this.cost = cost;
		this.description = description;
		this.summary = summary;
		this.imageLink = imageLink;
		this.dateStart = dateStart;
		this.type = type;
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

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	


}
